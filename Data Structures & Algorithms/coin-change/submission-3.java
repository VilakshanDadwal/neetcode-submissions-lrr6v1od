// DP solution
class Solution {

    public int coinChange(int[] coins, int amount) {
        var current = new int[amount+1];
        Arrays.fill(current, amount+1);
        current[0] = 0;

        for(int i=0; i<coins.length; i++) {
            for(int j=0; j<= amount; j++) {
                var currentCoin = coins[i];
                if(currentCoin <= j) {
                    current[j] = Math.min(current[j], 1 + current[j - currentCoin]);
                }
            }
        }
        return current[amount] == amount+1 ? -1 : current[amount];
    }
}
