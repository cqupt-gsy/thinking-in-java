package programming.practise.leetcodes.older;

import java.util.Arrays;

public class LongestSubstringWithoutRepeating_03 {

    // https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
    public int lengthOfLongestSubstring(String s) {
        int beginIndexOfWindow = 0;
        int endIndexOfWindow = 0;
        int maxSubStringLength = 0;
        int[] characterMapper = new int[256];
        Arrays.fill(characterMapper, -1);
        int stringLength = s.length();
        while (beginIndexOfWindow < stringLength && endIndexOfWindow < stringLength) {
            if (characterMapper[s.charAt(endIndexOfWindow)] == -1) {
                characterMapper[s.charAt(endIndexOfWindow++)] = 1;
                maxSubStringLength = Math.max(maxSubStringLength, endIndexOfWindow - beginIndexOfWindow);
            } else {
                characterMapper[s.charAt(beginIndexOfWindow++)] = -1;
            }
        }
        return maxSubStringLength;
    }

}
