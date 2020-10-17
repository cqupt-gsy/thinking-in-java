package programming.practise.leetcodes.arrays;

import java.util.HashMap;
import java.util.Map;

//四数相加 II
public class FourSumNumbersInArray {
    public static void main(String[] args) {

    }

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> firstMap = new HashMap<>();
        Map<Integer, Integer> secondMap = new HashMap<>();
        initMaps(firstMap, A, B);
        initMaps(secondMap, C, D);

        int result = 0;
        for (Map.Entry<Integer, Integer> entry : firstMap.entrySet()) {
            Integer key = -entry.getKey();
            if (secondMap.containsKey(key)) {
                result += entry.getValue() * secondMap.get(key);
            }
        }

        return result;
    }

    private void initMaps(Map<Integer, Integer> map, int[] first, int[] second) {
        for (int a : first) {
            for (int b : second) {
                int sum = a + b;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
    }

}
