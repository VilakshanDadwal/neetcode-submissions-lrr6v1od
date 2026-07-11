class Solution {
    public int minCostClimbingStairs(int[] cost) {
        var dp = new int[cost.length+1];
        dp[cost.length-1] = cost[cost.length-1];
        if(cost.length == 1) return dp[0];
        
        for(int i=cost.length-2; i>=0; i--) {
            dp[i] = cost[i] + Math.min(dp[i+1], dp[i+2]);
        } 
        return Math.min(dp[0], dp[1]);
    }
}
