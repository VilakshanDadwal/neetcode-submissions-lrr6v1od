class Solution {
        public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;

        int[][] dp = new int[n][2]; // 0 = holding, 1 = can buy

        dp[0][0] = -prices[0];  // if we buy on day 0
        dp[0][1] = 0;           // if we do nothing on day 0

        for (int i = 1; i < n; i++) {
            // If we hold a stock today:
            dp[i][0] = Math.max(
                dp[i - 1][0],                    // keep holding
                (i >= 2 ? dp[i - 2][1] : 0) - prices[i] // buy today after cooldown
            );

            // If we can buy today:
            dp[i][1] = Math.max(
                dp[i - 1][1],     // stay in buy state
                dp[i - 1][0] + prices[i]  // sell today
            );
        }

        // At the end, we must not be holding (buying = 1)
        return dp[n - 1][1];
    }
}
