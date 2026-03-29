class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int costIdx = 0;
        int sellIdx = 1;

        while(sellIdx < prices.length) {
            if(prices[sellIdx] < prices[costIdx]) {
                costIdx = sellIdx;
                sellIdx++;
                continue;
            }
            maxProfit = Math.max(maxProfit, prices[sellIdx] - prices[costIdx]);
            sellIdx++;
        }
        return maxProfit;
    }
}
