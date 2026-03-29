// Bottom Up
class Solution {
    public int numDistinct(String s, String t) {
        if(t.length() > s.length()) return 0;
        var dp = new int[s.length()+1][t.length()+1];
        for(int i=0; i<= s.length(); i++) {
            dp[i][t.length()] = 1; // If reached end of t, distinct subsequence found.
        }
        for(int i=s.length()-1; i>=0; i--) {
            for(int j=t.length()-1; j>=0; j--) {
                dp[i][j] = dp[i+1][j];
                if(s.charAt(i) == t.charAt(j)) {
                    dp[i][j] += dp[i+1][j+1];
                }
            }
        }
        return dp[0][0];
    }
}
