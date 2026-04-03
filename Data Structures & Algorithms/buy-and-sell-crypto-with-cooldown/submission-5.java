// Revision - Memoization
class Solution {
    public int maxProfit(int[] prices) {
        var cache = new int[prices.length][2];
        for(int i=0; i<prices.length; i++) {
            Arrays.fill(cache[i], -1);
        }
        return maxProfit(prices, false, 0, cache);
    }
    private int maxProfit(int[] prices, boolean isHolding, int idx, int[][] cache) {
        if(idx >= prices.length) return 0;
        var isHoldingIdx = isHolding ? 1 : 0;

        if(cache[idx][isHoldingIdx] != -1) return cache[idx][isHoldingIdx];

        if(isHolding) {
            // If isHolding stock, sell and skip next price as cooldown.
            cache[idx][isHoldingIdx] = prices[idx] + maxProfit(prices, false, idx+2, cache);
        } else {
            // If not holding, buy
            cache[idx][isHoldingIdx] = maxProfit(prices, true, idx+1, cache) - prices[idx];
        }
        // Can skip this price and not buy or sell. 
        cache[idx][isHoldingIdx] = Math.max(cache[idx][isHoldingIdx], maxProfit(prices, isHolding, idx+1, cache));
        return cache[idx][isHoldingIdx];
    }
}
