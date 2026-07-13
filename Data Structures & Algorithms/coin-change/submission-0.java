class Solution {
    public int coinChange(int[] coins, int amount) {
        var result = coinChange(0, coins, amount);
        return result == Integer.MAX_VALUE/2 ? -1: result;
    }
    private int coinChange(int i, int[] coins, int target) {
        if(target ==0 ) return 0;
        if(i==coins.length) return Integer.MAX_VALUE/2;
        var minCoins = Integer.MAX_VALUE/2;
        if(coins[i] <= target) {
            minCoins = Math.min(1 + coinChange(i, coins, target-coins[i]) 
                                , coinChange(i+1, coins, target));
        } else {
            minCoins = coinChange(i+1, coins, target);
        }
        return minCoins;
    }
}
