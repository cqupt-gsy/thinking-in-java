package programming.practise.interview;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.BitSet;
import java.util.regex.Pattern;

import com.google.common.io.Files;

public class IpListImpl implements IpList {

  private static final IpListImpl INSTANCE = new IpListImpl();

  private static final BitSet IP_SETS_1 = new BitSet(Integer.MAX_VALUE);
  private static final BitSet IP_SETS_2 = new BitSet(Integer.MAX_VALUE);
  private static final BitSet IP_SETS_3 = new BitSet(2);

  private static final Pattern IP_PATTERN =
      Pattern.compile("^\\d{1,3}.\\d{1,3}.\\d{1,3}.\\d{1,3}$");

  private IpListImpl() {}

  public static synchronized IpListImpl initialIpList(String ipListFile) throws IOException {
    if (IP_SETS_1.isEmpty() && IP_SETS_2.isEmpty() && IP_SETS_3.isEmpty()) {
      Files.readLines(
              new File(IpListImpl.class.getClassLoader().getResource(ipListFile).getPath()),
              Charset.defaultCharset())
          .forEach(
              line -> {
                if (IP_PATTERN.matcher(line).matches()) {
                  long ipLong = ipToLong(line);
                  if (ipLong >= 0 && ipLong < Integer.MAX_VALUE) { // 0 ~ 2^31-2
                    IP_SETS_1.set(Math.toIntExact(ipLong));
                  } else if (ipLong >= Integer.MAX_VALUE
                      && ipLong < Integer.MAX_VALUE * 2L) { // 2^31-1 ~ 2^32-3
                    IP_SETS_2.set(Math.toIntExact(ipLong - Integer.MAX_VALUE));
                  } else if (ipLong >= Integer.MAX_VALUE * 2L
                      && ipLong <= 1L << 32) { // 2^32-2 ~ 2^32
                    IP_SETS_3.set(Math.toIntExact(ipLong - Integer.MAX_VALUE * 2L));
                  }
                }
              });
    }
    return INSTANCE;
  }

  private static long ipToLong(String ip) {
    String[] ipInArray = ip.split("\\.");
    long result = 0;
    for (int i = 0; i < ipInArray.length; i++) {
      int power = 3 - i;
      int ipNumber = Integer.parseInt(ipInArray[i]);
      result += ipNumber * Math.pow(256, power);
    }
    return result;
  }

  @Override
  public boolean isInList(String ip) {
    if (!IP_PATTERN.matcher(ip).matches()) {
      return false;
    }
    long ipLong = ipToLong(ip);
    if (ipLong >= 0 && ipLong < Integer.MAX_VALUE) {
      return IP_SETS_1.get(Math.toIntExact(ipLong));
    } else if (ipLong >= Integer.MAX_VALUE && ipLong < Integer.MAX_VALUE * 2L) {
      return IP_SETS_2.get(Math.toIntExact(ipLong - Integer.MAX_VALUE));
    } else if (ipLong >= Integer.MAX_VALUE * 2L && ipLong <= 1L << 32) {
      return IP_SETS_3.get(Math.toIntExact(ipLong - Integer.MAX_VALUE * 2L));
    }
    return false;
  }
}
