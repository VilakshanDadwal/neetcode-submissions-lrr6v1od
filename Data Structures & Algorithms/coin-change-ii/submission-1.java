class Solution {
    public int change(int amount, int[] coins) {
        var curr = new int[amount+1];
        curr[0] = 1;
        for(int coin :coins) {
            for(int j=0; j<=amount; j++) {
                if(j-coin>=0) {
                    curr[j] += curr[j-coin];
                }
            }
        }
        return curr[amount];
    }
}
