package programming.practise.leetcodes.arrays;

import java.util.Arrays;

//除自身以外数组的乘积
public class MultipleArrays {
    public static void main(String[] args) {
    }

    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int[] leftArray = new int[nums.length];
        int[] rightArray = new int[nums.length];
        Arrays.fill(result, 1);
        Arrays.fill(leftArray, 1);
        Arrays.fill(rightArray, 1);

        for (int pivot = 1; pivot < nums.length; pivot++) {
            leftArray[pivot] = leftArray[pivot - 1] * nums[pivot - 1];
        }

        for (int pivot = nums.length - 2; pivot >= 0; pivot--) {
            rightArray[pivot] = rightArray[pivot + 1] * nums[pivot + 1];
        }

        for (int index = 0; index < result.length; index++) {
            result[index] = leftArray[index] * rightArray[index];
        }
        return result;
    }
}
