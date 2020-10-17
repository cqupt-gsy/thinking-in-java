package programming.practise.leetcodes.older;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class IpToInteger {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (sc.hasNext()) {
      String ipOriginalString = sc.nextLine();
      String ipLongString = sc.nextLine();

      System.out.println(ipToLong(ipOriginalString));
      System.out.println(longToIp(Long.valueOf(ipLongString)));
    }
  }

  private static Long ipToLong(String ipOriginalString) {
    List<String> intValues =
        Arrays.stream(ipOriginalString.split("\\."))
            .filter(s -> !s.isEmpty())
            .collect(Collectors.toList());
    if (intValues.size() != 4) {
      return 0L;
    }
    StringBuilder intValueToBinary = new StringBuilder();
    intValues.forEach(intValue -> intValueToBinary.append(intToBinary(intValue)));
    return Long.parseLong(intValueToBinary.toString(), 2);
  }

  private static String intToBinary(String intValue) {
    String binaryString = Integer.toBinaryString(Integer.parseInt(intValue, 10));
    return complementZeroForBinary(binaryString, 8);
  }

  private static String longToIp(Long ipIntegerString) {
    String binaryString = complementZeroForBinary(Long.toBinaryString(ipIntegerString), 32);

    StringBuilder ipString = new StringBuilder();
    while (binaryString.length() > 0) {
      ipString.append(binaryToInt(binaryString.substring(0, 8)));
      if (binaryString.length() > 8) {
        ipString.append(".");
      }
      binaryString = binaryString.substring(8);
    }
    return ipString.toString();
  }

  private static Integer binaryToInt(String binaryString) {
    return Integer.parseInt(binaryString, 2);
  }

  private static String complementZeroForBinary(String originalBinaryString, int complementLength) {
    int shortString = complementLength - originalBinaryString.length();
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < shortString; i++) {
      result.append("0");
    }
    return result.append(originalBinaryString).toString();
  }
}
