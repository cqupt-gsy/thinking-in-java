package programming.practise.leetcodes;

import static java.lang.Character.isDigit;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LongestSubstringWithDigitalNumber {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (sc.hasNext()) {
      String inputValue = sc.nextLine();
      int longestSubstringWithDigitalNumberLength = Integer.MIN_VALUE;
      List<String> longestSubstringWithDigitalNumber = new ArrayList<>();

      for (int index = 0; index < inputValue.length(); ++index) {
        if (isDigit(inputValue.charAt(index))) {
          int secondIndex = index + 1;
          for (; secondIndex < inputValue.length(); ++secondIndex) {
            if (!isDigit(inputValue.charAt(secondIndex))) {
              longestSubstringWithDigitalNumberLength =
                  getLongestSubstringWithDigitalNumberLength(
                      index,
                      secondIndex,
                      inputValue,
                      longestSubstringWithDigitalNumberLength,
                      longestSubstringWithDigitalNumber);
              index = secondIndex;
              break;
            }
          }
          if (index != secondIndex) {
            longestSubstringWithDigitalNumberLength =
                getLongestSubstringWithDigitalNumberLength(
                    index,
                    secondIndex,
                    inputValue,
                    longestSubstringWithDigitalNumberLength,
                    longestSubstringWithDigitalNumber);
            index = secondIndex;
          }
        }
      }

      longestSubstringWithDigitalNumber.forEach(System.out::print);
      System.out.print(",");
      System.out.println(longestSubstringWithDigitalNumberLength);
    }
  }

  private static int getLongestSubstringWithDigitalNumberLength(
      int index,
      int secondIndex,
      String inputValue,
      int longestSubstringWithDigitalNumberLength,
      List<String> longestSubstringWithDigitalNumber) {
    int substringWithDigitalNumberLength = secondIndex - index;
    if (substringWithDigitalNumberLength == longestSubstringWithDigitalNumberLength) {
      longestSubstringWithDigitalNumber.add(inputValue.substring(index, secondIndex));
    }
    if (substringWithDigitalNumberLength > longestSubstringWithDigitalNumberLength) {
      longestSubstringWithDigitalNumberLength = substringWithDigitalNumberLength;
      longestSubstringWithDigitalNumber.clear();
      longestSubstringWithDigitalNumber.add(inputValue.substring(index, secondIndex));
    }
    return longestSubstringWithDigitalNumberLength;
  }
}
