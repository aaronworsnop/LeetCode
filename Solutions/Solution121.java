class Solution121 {
  public int maxProfit(int[] prices) {
    // For an integer array, find the maximum range between n and m where n[ind] < m[ind]
    int low = Integer.MAX_VALUE;
    int highProfit = 0;

    for (int i = 0; i < prices.length; i++) {
      if (prices[i] < low) {
        low = prices[i];
      } else if (prices[i] - low > highProfit) {
        highProfit = prices[i] - low;
      }
    }
    return highProfit;
  }
}
