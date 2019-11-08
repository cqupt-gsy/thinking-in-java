package programming.practise.interview;

import static org.apache.commons.io.FileUtils.readLines;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.regex.Pattern;

public class IpListImpl implements IpList {

  private static final IpListImpl INSTANCE = new IpListImpl();



  private static final Set<String> IP_SETS = new ConcurrentSkipListSet<>();

  private static final Pattern IP_PATTERN =
      Pattern.compile("^\\d{0,3}.\\d{0,3}.\\d{0,3}.\\d{0,3}$");

  private IpListImpl() {}

  public static synchronized IpListImpl initialIpList(String ipListFile) throws IOException {
    if (IP_SETS.isEmpty()) {
      IP_SETS.addAll(
          readLines(new File(IpListImpl.class.getClassLoader().getResource(ipListFile).getPath())));
    }
    return INSTANCE;
  }

  @Override
  public boolean isInList(String ip) {
    if (!IP_PATTERN.matcher(ip).matches()) {
      return false;
    }
    return IP_SETS.contains(ip);
  }
}
