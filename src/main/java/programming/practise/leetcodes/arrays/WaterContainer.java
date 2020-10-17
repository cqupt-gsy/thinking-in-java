package programming.practise.leetcodes.arrays;

// 盛最多水的容器
public class WaterContainer {
    public static void main(String[] args) {

    }

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = Integer.MIN_VALUE;
        while (left < right) {
            int x = right - left;
            int y = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, x * y);
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
