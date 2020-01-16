package programming.practise.leetcodes;

import static org.junit.Assert.*;

import org.junit.Test;

public class IpToIntegerTest {

  @Test
  public void name() {
    System.out.println(integerToBinary("167969729"));
    System.out.println(Integer.parseInt("10110000", 2));
  }

  private String integerToBinary(String integer) {
    return Integer.toBinaryString(Integer.parseInt(integer));
  }
}