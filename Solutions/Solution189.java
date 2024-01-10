class Solution189 {
  public void rotate(int[] nums, int k) {
    k %= nums.length;
    int[] remember = new int[k];

    for (int i = nums.length - k; i < nums.length; i++) {
      remember[i - nums.length + k] = nums[i];
    }

    for (int i = nums.length - 1 - k; i >= 0; i--) {
      nums[i + k] = nums[i];
    }

    for (int i = 0; i < k; i++) {
      nums[i] = remember[i];
    }
  }
}
