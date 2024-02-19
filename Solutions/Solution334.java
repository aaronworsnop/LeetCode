class Solution334 {
  public boolean increasingTriplet(int[] nums) {
    // Edge and known cases
    if (nums == null || nums.length < 3) {
      return false;
    }

    int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;

    for (int num = 0; num < nums.length; num++) {
      if (nums[num] <= first) {
        first = nums[num];
      } else if (nums[num] <= second) {
        second = nums[num];
      } else {
        return true;
      }
    }

    return false;
  }
}
