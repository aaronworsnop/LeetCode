class Solution18 {
  public List<List<Integer>> fourSum(int[] nums, int target) {
    List<List<Integer>> quadruplets = new LinkedList<>();

    if (nums == null || nums.length < 4) {
      return quadruplets;
    }

    // Sort the array
    Arrays.sort(nums);

    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        long aim = (long) target - ((long) nums[i] + (long) nums[j]);
        int low = j + 1;
        int high = nums.length - 1;

        while (low < high) {
          if (nums[low] + nums[high] > aim) {
            high--;
          } else if (nums[low] + nums[high] < aim) {
            low++;
          } else {
            List<Integer> quadruplet = new LinkedList<>();
            quadruplet.add(nums[i]);
            quadruplet.add(nums[j]);
            quadruplet.add(nums[low]);
            quadruplet.add(nums[high]);
            quadruplets.add(quadruplet);

            // Avoid duplicates
            int lowNum = nums[low];
            int highNum = nums[high];
            while (nums[low] == lowNum && low < high) low++;
            while (nums[high] == highNum && low < high) high--;
          }
          while (j + 1 < nums.length && nums[j] == nums[j + 1]) {
            j++;
          }
        }
        while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
          i++;
        }
      }
    }

    return quadruplets;
  }
}
