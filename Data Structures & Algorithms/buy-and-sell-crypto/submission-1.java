// Revision
class Solution {
    public int maxProfit(int[] prices) {
        var left = 0;
        var maxProfit = 0;
        for(int right=1; right < prices.length; right++) { 
            if(prices[left] > prices[right]) {
                left = right;
                continue;
            }
            maxProfit = Math.max(maxProfit, prices[right] - prices[left]);
        }
        return maxProfit;
    }
}
