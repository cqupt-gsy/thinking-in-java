package programming.practise.interview;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class IpListImplTest {
  private IpListImpl ipListImpl;

  @Before
  public void setUp() throws Exception {
    ipListImpl = IpListImpl.initialIpList("ip.txt");
  }

  @Test
  public void should_validate_ip_success() {
    assertTrue(ipListImpl.isInList("192.192.192.192"));
    assertTrue(ipListImpl.isInList("0.0.0.0"));
    assertTrue(ipListImpl.isInList("22.22.22.22"));
    assertTrue(ipListImpl.isInList("192.12.12.1"));
    assertTrue(ipListImpl.isInList("255.255.255.255"));
    assertTrue(ipListImpl.isInList("192.33.33.1"));
    assertFalse(ipListImpl.isInList("as.2.2."));
    assertFalse(ipListImpl.isInList("192.2..2"));
    assertFalse(ipListImpl.isInList("192.2..2"));
    assertFalse(ipListImpl.isInList("192.2..2"));
    assertFalse(ipListImpl.isInList("192.2.1.2"));
  }

}
