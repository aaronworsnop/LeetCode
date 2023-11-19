import java.util.*;

class Solution15 {
  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> triples = new LinkedList();

    for (int i = 0; i < nums.length - 2; i++) {
      if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
        int low = i + 1;
        int high = nums.length - 1;
        int target = nums[i] * -1;

        while (low < high) {
          if (nums[low] + nums[high] == target) {
            List<Integer> triple = new LinkedList();
            triple.add(nums[i]);
            triple.add(nums[low]);
            triple.add(nums[high]);
            triples.add(triple);

            while (low < high && nums[low] == nums[low + 1]) {
              low++;
            }

            while (low < high && nums[high] == nums[high - 1]) {
              high--;
            }

            low++;
            high--;
          } else if (nums[low] + nums[high] > target) {
            high--;
          } else {
            low++;
          }
        }
      }
    }

    return triples;
  }
}
