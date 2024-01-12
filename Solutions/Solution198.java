class Solution198 {
  public int rob(int[] nums) {
    if (nums.length == 1) return nums[0];

    int houseOne = 0;
    int houseTwo = 0;

    for (int num : nums) {
      int remember = Math.max(houseOne + num, houseTwo);
      houseOne = houseTwo;
      houseTwo = remember;
    }

    return houseTwo;
  }
}
