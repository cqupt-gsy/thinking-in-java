package programming.practise.leetcodes;

public class MedianofTwoSortedArrays_04 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int numsLength_1 = nums1.length;
        int numsLength_2 = nums2.length;
        int mergeLength = numsLength_1 + numsLength_2;
        int[] mergedNums = new int[mergeLength];
        int mergeNumsIndex = 0;
        int numsIndex_1 = 0;
        int numsIndex_2 = 0;
        while (numsIndex_1 < numsLength_1 && numsIndex_2 < numsLength_2) {
            if (nums1[numsIndex_1] <= nums2[numsIndex_2]) {
                mergedNums[mergeNumsIndex++] = nums1[numsIndex_1++];
            } else {
                mergedNums[mergeNumsIndex++] = nums2[numsIndex_2++];
            }
        }
        while (numsIndex_1 < numsLength_1) {
            mergedNums[mergeNumsIndex++] = nums1[numsIndex_1++];
        }
        while (numsIndex_2 < numsLength_2) {
            mergedNums[mergeNumsIndex++] = nums2[numsIndex_2++];
        }
        if (mergeLength % 2 == 0) {
            return (mergedNums[mergeLength / 2] + mergedNums[mergeLength / 2 - 1]) / 2.0;
        } else {
            return mergedNums[mergeLength / 2];
        }
    }
}
