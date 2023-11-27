import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution15 {
  public List<List<Integer>> threeSum(int[] nums) {
    // Initialise return structure
    List<List<Integer>> sums = new LinkedList<>();

    // This problem is really the same as a smaller problem,
    // ``Two Sum 2, with a dynamic target and multiple solutions.
    Arrays.sort(nums);

    for (int i = 0; i < nums.length; i++) {
      if (i > 0 && nums[i - 1] == nums[i]) continue;
      int leftPoint = i + 1;
      int rightPoint = nums.length - 1;
      int target = 0 - nums[i];

      while (leftPoint < rightPoint) {
        if (nums[leftPoint] + nums[rightPoint] > target) rightPoint--;
        else if (nums[leftPoint] + nums[rightPoint] < target) leftPoint++;
        else {
          List<Integer> sum = new LinkedList<>();
          sum.add(nums[i]);
          sum.add(nums[leftPoint]);
          sum.add(nums[rightPoint]);
          sums.add(sum);
          leftPoint++;
          while (nums[leftPoint] == nums[leftPoint - 1] && leftPoint < rightPoint) leftPoint++;
        }
      }
    }

    return sums;
  }
}
