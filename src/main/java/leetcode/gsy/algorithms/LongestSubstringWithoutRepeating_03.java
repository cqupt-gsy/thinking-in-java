package leetcode.gsy.algorithms;

import java.util.Arrays;

public class LongestSubstringWithoutRepeating_03 {

    public int lengthOfLongestSubstring(String s) {
        int beginIndexOfWindow = 0;
        int endIndexOfWinddow = 0;
        int maxSubStringLength = 0;
        int[] characterMapper = new int[256];
        Arrays.fill(characterMapper, -1);
        int stringLength = s.length();
        while (beginIndexOfWindow < stringLength && endIndexOfWinddow < stringLength) {
            if (characterMapper[s.charAt(endIndexOfWinddow)] == -1) {
                characterMapper[s.charAt(endIndexOfWinddow++)] = 1;
                maxSubStringLength = Math.max(maxSubStringLength, endIndexOfWinddow - beginIndexOfWindow);
            } else {
                characterMapper[s.charAt(beginIndexOfWindow++)] = -1;
            }
        }
        return maxSubStringLength;
    }

}
