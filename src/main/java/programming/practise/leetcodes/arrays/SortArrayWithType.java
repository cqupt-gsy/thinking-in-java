package programming.practise.leetcodes.arrays;

// 颜色分类
public class SortArrayWithType {
    public static void main(String[] args) {

    }

    public void sortColors(int[] nums) {
        int begin = 0;
        int end = nums.length - 1;
        while (begin < end) {
            if (nums[begin] != 0 && nums[end] == 0) {
                int temp = nums[begin];
                nums[begin] = nums[end];
                nums[end] = temp;
                begin++;
                end--;
            } else if (nums[begin] == 0 && nums[end] == 0) {
                begin++;
            } else {
                end--;
            }

        }
        end = nums.length - 1;
        if (nums[begin] == 0) {
            begin++;
        }
        while (begin < end) {
            if (nums[begin] != 1 && nums[end] == 1) {
                int temp = nums[begin];
                nums[begin] = nums[end];
                nums[end] = temp;
                begin++;
                end--;
            } else if (nums[begin] == 1 && nums[end] == 1) {
                begin++;
            } else {
                end--;
            }

        }
    }
}
