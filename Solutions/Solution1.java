import java.util.HashMap;
import java.util.Map;

class Solution1 {
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> numsMap = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      numsMap.put(nums[i], i);
    }

    for (int i = 0; i < nums.length; i++) {
      int workingTarget = target - nums[i];
      System.out.println(workingTarget);
      if (numsMap.containsKey(workingTarget) && numsMap.get(workingTarget) != i) {
        return new int[] {i, numsMap.get(workingTarget)};
      }
    }

    return new int[] {};
  }
}
