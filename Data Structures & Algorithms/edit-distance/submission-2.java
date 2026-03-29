// Memoization.
class Solution {
    public int minDistance(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int j = 0; j <= s2.length(); j++) {
            dp[s1.length()][j] = s2.length() - j;
        }
        for (int i = 0; i <= s1.length(); i++) {
            dp[i][s2.length()] = s1.length() - i;
        }

        for(int i=s1.length()-1; i>=0; i--) {
            for(int j=s2.length()-1; j>=0; j--) {
                if(s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = dp[i+1][j+1];
                 } else {
                    dp[i][j] = 1 + Math.min(dp[i+1][j],
                                 Math.min(
                                    dp[i][j+1], 
                                    dp[i+1][j+1]));
                }
            }
        }
        return dp[0][0];
    }
}
