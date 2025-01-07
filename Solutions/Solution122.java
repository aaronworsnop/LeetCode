class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        
        if (prices.length < 2) {
            return maxProfit;
        }

        int buyIndex = 0;
        int sellIndex = 0;
        
        while (buyIndex <= sellIndex && sellIndex < prices.length) {

            if (prices[sellIndex] > prices[buyIndex]) {
                maxProfit += prices[sellIndex] - prices[buyIndex];
            } 
            
            buyIndex = sellIndex;
            sellIndex++;
        }

        return maxProfit;
    }
}