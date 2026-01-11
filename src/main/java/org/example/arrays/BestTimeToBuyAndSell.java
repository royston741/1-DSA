package org.example.arrays;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
class BestTimeToBuyAndSell {
    public int maxProfit(int[] prices) {
        int buy = 0;
        int sell = 1;
        int maxProfit = 0;

        while (sell < prices.length) {
            int buyPrice = prices[buy];
            int sellPrice = prices[sell];
            // if sell price is greater than calculate the profit
            if (sellPrice > buyPrice) {
                int profit = prices[sell] - prices[buy];
                maxProfit = Math.max(profit, maxProfit);
            } else { // else skip the between elements and move the buy to sell
                buy = sell;
            }
            sell++;
        }


        return maxProfit;
    }
}