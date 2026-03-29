class Solution {
    public int maxProfit(int[] prices) {
        // 0 index represents HAVE stock state.
        // 1 index represents NOT HAVE stock state.
        // These states are what you can get into after buying/selling the stock at that index.
        var dp = new int[prices.length][2];
        // To get into HAVE state on day 1, need to buy the stock.
        dp[0][0] = -prices[0];
        // Cant sell on day 1, so profit =0
        dp[0][1] = 0;
        for(int i=1; i<prices.length;i++) {
            // This is done because generic case has i-2
            // Its easier to run generic case for i>=2. 
            // So wrote this edge case explicitly for easier understanding.
            if(i==1) {
                dp[1][0] = Math.max(dp[0][0], -prices[1]);
            } else {
                // To find Max profit to get into HAVE stock state, need to buy the stock.
                // To getmax profit after buying stock today, consider the max profit in "NOT have stock" state 2 days ago.
                // 2 days ago because after selling, there is cooldown of 1 day.
                dp[i][0] = Math.max(dp[i-1][0], dp[i-2][1] - prices[i]);
                // dp[i-1][0] represents not taking action for the stock on that day.
                // So consider max profit till now in HAVE state the previous day.
            }
            // To find Max profit to get into NOT HAVE stock state, need to sell the stock.
            // To get max profit after selling stock today, consider max profit in HAVE stock state till previous day.
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]+prices[i]);
        }
        // At the end, need to be in NOT HAVE state. 
        // Max profit can never be achieved by being in HAVE state coz there will be an unnecessary buy considered.
        return dp[prices.length-1][1];
    }
}
