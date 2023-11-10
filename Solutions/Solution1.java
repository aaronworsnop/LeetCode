class Solution1 {
  public int[] twoSum(int[] nums, int target) {
    int[] inds = {0, 0};
    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < nums.length; j++) {
        if (i == j) {
          break;
        } else if (nums[i] + nums[j] == target) {
          inds[0] = i;
          inds[1] = j;
        }
      }
    }

    return inds;
  }
}
