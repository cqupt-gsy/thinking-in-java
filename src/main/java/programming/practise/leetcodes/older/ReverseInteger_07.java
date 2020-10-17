package programming.practise.leetcodes.older;

public class ReverseInteger_07 {

    // https://leetcode-cn.com/problems/reverse-integer/submissions/
    public int reverse(int x) {
        int[] separatedInteger = new int[10];
        int currentIndex = 0;
        while (x != 0) {
            separatedInteger[currentIndex] = x % 10;
            x = x / 10;
            currentIndex++;
        }
        int result = 0;
        for (int index = 0, reverseIntLength = currentIndex - 1; reverseIntLength >= 0 ; reverseIntLength--, index++) {
            if (separatedInteger[index] == 0 && result == 0) {
                currentIndex--;
                continue;
            }
            result += separatedInteger[index] * Math.pow(10, reverseIntLength);
        }
        return result == Integer.MAX_VALUE || result == Integer.MIN_VALUE ? 0 : result;
    }
}
