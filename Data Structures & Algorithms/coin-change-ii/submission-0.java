class Solution {
    public int change(int amount, int[] coins) {
        var curr = new int[amount+1];
        var prev = new int[amount+1];

        for(int coin :coins) {
            for(int j=0; j<=amount; j++) {
                if(j==0) {
                    curr[j] = 1;
                    continue;
                }
                if(j-coin>=0) {
                    curr[j] = prev[j] + curr[j-coin];
                } else {
                    curr[j] = prev[j];
                }
            }
            prev = curr;
        }
        return curr[amount];
    }
}
