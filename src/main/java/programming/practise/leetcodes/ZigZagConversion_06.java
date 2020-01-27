package programming.practise.leetcodes;

import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion_06 {

    // https://leetcode-cn.com/problems/zigzag-conversion/submissions/
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        List<StringBuilder> zigZagStringBuilders = new ArrayList<>();
        for (int index = 0; index < Math.min(s.length(), numRows); index++) {
            zigZagStringBuilders.add(new StringBuilder());
        }

        boolean goingDown = false;
        int currentRowIndex = 0;

        for (int index = 0; index < s.length(); index++) {
            zigZagStringBuilders.get(currentRowIndex).append(s.charAt(index));
            if (currentRowIndex == 0 || currentRowIndex == numRows - 1) {
                goingDown = !goingDown;
            }
            currentRowIndex += goingDown ? 1 : -1;
        }

        StringBuilder zigZagString = new StringBuilder();
        zigZagStringBuilders.forEach(zigZagString::append);
        return zigZagString.toString();
    }
}
