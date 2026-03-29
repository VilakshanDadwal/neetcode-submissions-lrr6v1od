class Solution {
    public int coinChange(int[] coins, int amount) {
        var cache = new HashMap<Integer, Integer>();
        cache.put(0,0);
        int minCoins = minCoins(coins, amount, cache);
        return minCoins == Integer.MAX_VALUE ? -1 : minCoins;
    }
    int minCoins(int[] coins, int amount, Map<Integer, Integer> cache) {
        if(amount==0) return 0;
        if(cache.containsKey(amount)) return cache.get(amount);

        int minCoins = Integer.MAX_VALUE;
        for(int coin: coins) {
            if(amount-coin >= 0) {
                int coinChange = minCoins(coins, amount - coin, cache);
                if(coinChange == Integer.MAX_VALUE) {
                    minCoins = Math.min(minCoins, coinChange);
                } else {
                    minCoins = Math.min(minCoins, 1 + coinChange);
                }
            }
        }
        cache.put(amount, minCoins);
        return minCoins;
    }
}
