// Recursive - Trying out all possible coins in first place, then second .. so on approach
// Alternate approach - passing the invalid value in function
class Solution {

    public int coinChange(int[] coins, int amount) {
        var result = coinChange(0, coins, amount, amount+1);
        return result == amount+1 ? -1 : result;
    }
    private int coinChange(int idx, int[] coins, int target, int INVALID_VALUE) {
        if(target == 0) return 0;
        var minCoins = INVALID_VALUE;
        for(int i=idx; i<coins.length; i++) {
            if(coins[i] <= target) {
                minCoins = Math.min(minCoins, 1 + coinChange(i, coins, target-coins[i], INVALID_VALUE));
            }
        }
        return minCoins;
    }
}
