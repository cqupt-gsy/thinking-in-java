package programming.practise.leetcodes.arrays;

// 只出现一次的数字
public class FindAppearOneTimeNumber {

    public static void main(String[] args) {

    }

    public int singleNumber(int[] nums) {
        int pivot = nums[0];
        for (int index = 1; index < nums.length; index++) {
            pivot = pivot ^ nums[index];
        }
        return pivot;
    }
}
