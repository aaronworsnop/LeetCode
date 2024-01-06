class Solution152 {
  public int maxProduct(int[] nums) {
    if (nums.length == 1) return nums[0];

    int maxProduct = nums[0];
    int currentMaxProduct = nums[0];
    int currentMinProduct = nums[0];

    for (int num = 1; num < nums.length; num++) {
      int tempMax = currentMaxProduct;
      currentMaxProduct =
          Math.max(
              Math.max(currentMaxProduct * nums[num], currentMinProduct * nums[num]), nums[num]);
      currentMinProduct =
          Math.min(Math.min(tempMax * nums[num], currentMinProduct * nums[num]), nums[num]);
      maxProduct = Math.max(maxProduct, currentMaxProduct);
    }

    return maxProduct;
  }
}
