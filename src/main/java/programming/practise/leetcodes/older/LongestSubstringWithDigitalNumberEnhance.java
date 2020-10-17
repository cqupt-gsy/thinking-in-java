package programming.practise.leetcodes.older;

import static java.lang.Character.isDigit;

import java.util.Scanner;

public class LongestSubstringWithDigitalNumberEnhance {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (sc.hasNext()) {
      String inputValue = sc.nextLine();
      String longestSubstringWithDigitalNumber = "";

      for (int index = 0; index < inputValue.length(); ++index) {
        char character = inputValue.charAt(index);
        if (isDigit(character) || isFirstCharacterBelongToSignal(character)) {
          int pointNumber = 0;
          boolean back = false;
          int secondIndex = index + 1;
          for (; secondIndex < inputValue.length(); ++secondIndex) {
            char nextCharacter = inputValue.charAt(secondIndex);
            if (isDigit(nextCharacter)) {
              continue;
            }
            if (isPoint(nextCharacter)) {
              pointNumber++;
            }
            if (pointNumber <= 1
                && secondIndex + 1 < inputValue.length()
                && isDigit(inputValue.charAt(secondIndex - 1))
                && isDigit(inputValue.charAt(secondIndex + 1))) {
              pointNumber++;
              continue;
            }

            int substringWithDigitalNumberLength = secondIndex - index;
            if (substringWithDigitalNumberLength >= longestSubstringWithDigitalNumber.length()) {
              longestSubstringWithDigitalNumber = inputValue.substring(index, secondIndex);
            }
            if (pointNumber > 1) {
              for (int temp = secondIndex - 1; temp > 0; temp--) {
                if (!isDigit(inputValue.charAt(temp))) {
                  index = temp;
                  back = true;
                  break;
                }
              }
            } else {
              index = secondIndex - 1;
            }
            break;
          }
          if (index != secondIndex - 1 && !back) {
            int substringWithDigitalNumberLength = secondIndex - index;
            if (substringWithDigitalNumberLength >= longestSubstringWithDigitalNumber.length()) {
              longestSubstringWithDigitalNumber = inputValue.substring(index, secondIndex);
            }
            index = secondIndex - 1;
          }
        }
      }

      System.out.println(longestSubstringWithDigitalNumber);
    }
  }

  private static boolean isFirstCharacterBelongToSignal(char character) {
    return character == '+' || character == '-';
  }

  private static boolean isPoint(char character) {
    return character == '.';
  }
}
