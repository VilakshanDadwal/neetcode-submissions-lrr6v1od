class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] minCoins = new int[amount+1];
        Arrays.fill(minCoins, Integer.MAX_VALUE);
        minCoins[0]=0;
        for(int i=1; i<=amount; i++) {
            for(int coin:coins) {
                if(i-coin>=0 && minCoins[i-coin] != Integer.MAX_VALUE){
                        minCoins[i] = Math.min(minCoins[i], 1 + minCoins[i-coin]);
                    }
                }
            }
        return minCoins[amount]==Integer.MAX_VALUE? -1 : minCoins[amount];
    }
}
