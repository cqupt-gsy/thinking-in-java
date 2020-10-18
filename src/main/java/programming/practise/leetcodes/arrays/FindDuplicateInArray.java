package programming.practise.leetcodes.arrays;

import java.util.Arrays;

// 存在重复元素
public class FindDuplicateInArray {
    public static void main(String[] args) {

    }

    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        int slowIndex = 0;
        for (int fastIndex = 1; fastIndex < nums.length; fastIndex++) {
            if (nums[slowIndex++] == nums[fastIndex]) {
                return true;
            }

        }
        return false;
    }
}
