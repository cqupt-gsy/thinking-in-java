package programming.practise.leetcodes.arrays;

import java.util.HashMap;
import java.util.Map;

//四数相加 II
public class FourSumNumbersInArray {
    public static void main(String[] args) {

    }

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : A) {
            for (int b : B) {
                int sum = a + b;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        int result = 0;
        for (int c : C) {
            for (int d : D) {
                int sum = c + d;
                if (map.containsKey(-sum)) {
                    result += map.get(-sum);
                }
            }
        }
        return result;
    }


}
