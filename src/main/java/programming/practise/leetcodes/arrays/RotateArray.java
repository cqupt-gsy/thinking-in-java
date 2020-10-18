package programming.practise.leetcodes.arrays;

import java.util.Arrays;

// 旋转数组
public class RotateArray {
    public static void main(String[] args) {

        RotateArray rotateArray = new RotateArray();
        rotateArray.rotate(new int[] {1,2,3,4,5,6,7}, 3);
    }

    public void rotate(int[] nums, int k) {
        int pivot = nums.length;
        for (int i = 0; i < k; i++) {
            pivot--;
            if (pivot <= 0) {
                pivot = nums.length;
            }

        }
        int[] left = Arrays.copyOfRange(nums, 0, pivot);
        int[] right = Arrays.copyOfRange(nums, pivot, nums.length);

        System.arraycopy(right, 0, nums, 0, right.length);
        System.arraycopy(left, 0, nums, right.length, left.length);
    }
}
