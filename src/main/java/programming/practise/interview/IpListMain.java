package programming.practise.interview;

import java.io.IOException;

public class IpListMain {
  public static void main(String[] args) throws IOException {
    IpListImpl ipList = IpListImpl.initialIpList("ip.txt");
    System.out.println(ipList.isInList("192.192.192.192"));
  }
}
