// Revision - Bottom up
class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==1) return 0;

        // Col 0 represent notHolding, 1 represent holding
        var cache = new int[prices.length][2];
        cache[0][1] = -prices[0];
        for(int i=1; i<prices.length; i++) {
            cache[i][0] = Math.max(cache[i-1][0], cache[i-1][1] + prices[i]);
            if(i==1) {
                cache[i][1] = Math.max(cache[i-1][1], 0-prices[i]);
            } else {
                cache[i][1] = Math.max(cache[i-1][1], cache[i-2][0] - prices[i]);
            }
        }
        return Math.max(cache[prices.length-1][0], cache[prices.length-1][1]);
    }
}
