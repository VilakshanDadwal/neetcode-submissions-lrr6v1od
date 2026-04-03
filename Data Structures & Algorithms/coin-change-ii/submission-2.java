// bottom up revision - starting from 0,0
class Solution {
    public int change(int amount, int[] coins) {
        var dp = new int[coins.length+1][amount+1];
        for(int i=0; i<=coins.length; i++) {
            dp[i][0] = 1;
        }

        for(int i=1; i<=coins.length; i++) {
            for(int target=1; target<=amount; target++) {
                if(coins[i-1] <= target) {
                    dp[i][target] = dp[i-1][target] + dp[i][target - coins[i-1]];
                } else {
                    dp[i][target] = dp[i-1][target];
                }
            }
        }
        return dp[coins.length][amount];
    }
}
