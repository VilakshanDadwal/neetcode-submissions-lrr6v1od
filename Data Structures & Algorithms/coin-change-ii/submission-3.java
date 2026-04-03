// bottom up revision - starting from 0,0. single array.
class Solution {
    public int change(int amount, int[] coins) {
        var dp = new int[amount+1];

        dp[0] = 1;

        for(int i=1; i<=coins.length; i++) {
            for(int target=1; target<=amount; target++) {
                if(coins[i-1] <= target) {
                    dp[target] = dp[target] + dp[target - coins[i-1]];
                } else {
                    dp[target] = dp[target];
                }
            }
        }
        return dp[amount];
    }
}
