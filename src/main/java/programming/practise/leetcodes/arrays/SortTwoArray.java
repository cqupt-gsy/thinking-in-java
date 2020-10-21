package programming.practise.leetcodes.arrays;

// 合并两个有序数组
public class SortTwoArray {
    public static void main(String[] args) {

    }


    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums2.length == 0) {
            return;
        }
        int end = m;
        int firstIndex = 0;
        int secondIndex = 0;
        while (firstIndex < nums1.length && secondIndex < nums2.length) {
            if (nums1[firstIndex] > nums2[secondIndex]) {
                moveElement(nums1, firstIndex, end);
                nums1[firstIndex] = nums2[secondIndex];
                secondIndex++;
                end++;
            }
            firstIndex++;
        }
        while (secondIndex < nums2.length) {
            for (int i = end; i < nums1.length; i++) {
                nums1[i] = nums2[secondIndex++];
            }
        }
    }

    private void moveElement(int[] nums, int begin, int end) {
        if (end - begin >= 0) System.arraycopy(nums, begin, nums, begin + 1, end - begin);
    }
}
