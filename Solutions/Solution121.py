class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        maxProfit = 0

        low = prices[0]
        for i in range(len(prices)):
            if prices[i] < low:
                low = prices[i]

            if prices[i] - low > maxProfit:
                maxProfit = prices[i] - low

        return maxProfit

        
        