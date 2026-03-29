// Revision
class Solution {
    public int coinChange(int[] coins, int amount) {
        var cache = new int[amount+1];
        // - 1 represents not computed yet.
        Arrays.fill(cache, -1);
        cache[0] = 0;
        var result = coinChanges(coins, amount, cache);
        return result == Integer.MAX_VALUE ? -1 : result;  
    }

    private int coinChanges(int[] coins, int target, int[] cache) {
        if(target == 0) return 0; 
        if(cache[target] != -1) return cache[target];
        // This represents , valid result cannot be found. 
        // This will be used as the default vlaue.
        cache[target] = Integer.MAX_VALUE;
        for(int coin : coins) {
            if(target >= coin) {
                var result = coinChanges(coins, target-coin, cache);
                // Could be that target could not be made.
                if(result != Integer.MAX_VALUE) 
                    cache[target] = Math.min(cache[target], 1 + result);
            }
        }
        return cache[target];
    }
}
