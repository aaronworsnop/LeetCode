class Solution {
  public int rob(int[] nums) {
    // Circular
    // Remainder indexing

    // 100, 100, 30, 5, 20, 5, 6
    //      ^
    // range1: 126 | range2: 150 -> supposedly, our maxProfit = 150

    // range1: 150 | 135 -> 150

    // range1: 135 | 150 -> 150

    // range1: 150 | 126 -> 150

    // Edgecases
    if (nums == null || nums.length == 0) {
      // No houses, no profit
      return 0;
    } else if (nums.length == 1) {
      // Only one house to rob from
      return nums[0];
    }

    int maxProfit = 0;

    int range1 = robRange(nums, 0, nums.length - 2);
    int range2 = robRange(nums, 1, nums.length - 1);
    maxProfit = Math.max(range1, range2);

    return maxProfit;
  }

  /**
   * Determine the maximum profit by robbing houses, without ever robbing adjacent ones. These
   * houses are in one long row.
   */
  private int robRange(int[] nums, int start, int end) {
    int range = end - start + 1;

    // Edgecases
    if (range == 0) {
      return 0;
    } else if (range == 1) {
      return nums[start];
    }

    int maxProfit = 0;
    int index = start;
    int[] profit = new int[range];

    // The maximum accumulative profit of each house depends on
    // the previous houses
    for (int count = 0; count < range; count++) {
      if (count == 0 || count == 1) {
        // The first houses don't depend on previous ones
        profit[count] = nums[index];
      } else if (count == 2) {
        // The third house can only sum with the first
        profit[count] = profit[0] + nums[index];
      } else {
        profit[count] = Math.max(profit[count - 2], profit[count - 3]) + nums[index];
      }

      index = (index + 1) % nums.length;
    }

    maxProfit = Math.max(profit[range - 1], profit[range - 2]);
    return maxProfit;
  }
}
