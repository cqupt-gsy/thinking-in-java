package programming.practise.leetcodes;

import java.util.HashMap;
import java.util.Map;

public class TwoSum_01 {

  // https://leetcode-cn.com/problems/two-sum/submissions/
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> indexMapper = new HashMap<>();
    for (int startIndex = 0; startIndex < nums.length; startIndex++) {
      int addedNumber = target - nums[startIndex];
      if (indexMapper.containsKey(addedNumber)) {
        return new int[] {indexMapper.get(addedNumber), startIndex};
      }
      indexMapper.put(nums[startIndex], startIndex);
    }

    return null;
  }
}
