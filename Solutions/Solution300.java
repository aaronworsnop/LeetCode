class Solution300 {
  public int lengthOfLIS(int[] nums) {
    int[] LIS = new int[nums.length];

    for (int i = 0; i < LIS.length; i++) {
      LIS[i] = 1;
    }

    for (int index = nums.length - 1; index >= 0; index--) {
      for (int sequence = index; sequence < nums.length; sequence++) {
        if (nums[sequence] > nums[index]) {
          LIS[index] = Math.max(LIS[index], 1 + LIS[sequence]);
        }
      }
    }

    int max = 1;

    for (int i = 0; i < LIS.length; i++) {
      max = Math.max(max, LIS[i]);
    }

    return max;
  }
}
