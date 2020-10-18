package programming.practise.leetcodes.arrays;

// 删除排序数组中的重复项
public class RemoveRepeatElementInArray {
    public static void main(String[] args) {

    }

    public int removeDuplicates(int[] nums) {
        int slowIndex = 0;
        int fastIndex = 1;
        while (fastIndex < nums.length) {
            if (nums[fastIndex] != nums[slowIndex]) {
                nums[++slowIndex] = nums[fastIndex];
            }
            fastIndex++;
        }
        return slowIndex + 1;
    }
}
