class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int maxProfit = 0;
        int minPrice = 100000;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else {
                maxProfit = std::max(maxProfit, price - minPrice);
            }
        }

        return maxProfit;
    }
};
