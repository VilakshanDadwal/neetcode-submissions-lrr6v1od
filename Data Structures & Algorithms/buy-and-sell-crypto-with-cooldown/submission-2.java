class Solution {
    public int maxProfit(int[] prices) {
        var dp = new int[prices.length][2];
        // 0 column represents you have the stock, 1 represents you dont have the stock.
        dp[0][0] = -prices[0]; // if buy on day1 profit is -price
        dp[0][1] = 0; // cant sell on day 1
        for(int i=1; i<prices.length; i++) {
            if(i==1) {
                dp[i][0] = Math.max(dp[i-1][0], -prices[i]);
            } else {
                dp[i][0] = Math.max(dp[i-1][0], dp[i-2][1] - prices[i]);
            }
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + prices[i]);
        }
        // In the end, we must be in a buying state. 
        return dp[prices.length-1][1];
    }
}
