package programming.practise.leetcodes;

public class LongestPalindromicSubstring_05 {

    public String longestPalindrome(String s) {
        int start = 0, end = 0;
        for (int index = 0; index < s.length(); ++index) {
            int palindromeLengthOfOddString = getPalindromeLength(s, index, index);
            int palindromeLengthOfEvenString = getPalindromeLength(s, index, index + 1);
            int longestLength = Math.max(palindromeLengthOfOddString, palindromeLengthOfEvenString);
            //because longestLength is the length of the palindrome string
            //so, in order to find the start and end index of the palindrome string
            //need to cut half of it
            if (longestLength > end - start + 1) {
                start = index - (longestLength - 1) / 2;
                end = index + longestLength / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int getPalindromeLength(String originalString, int leftIndex, int rightIndex) {
        while (leftIndex >= 0 && rightIndex < originalString.length() && originalString.charAt(leftIndex) == originalString.charAt(rightIndex)) {
            leftIndex--;
            rightIndex++;
        }
        return rightIndex - leftIndex - 1;
    }
}
