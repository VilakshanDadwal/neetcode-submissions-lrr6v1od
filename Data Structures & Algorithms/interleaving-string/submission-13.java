// Revision - Bottom up 2D
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length() != s3.length()) return false;


        var dp = new boolean[s1.length()+1][s2.length()+1];
        // This case represents, can we form 0 length string of s3 
        // using 0 chars from s1 and 0 from s2. Yes we can. Empty+Empty = empty
        dp[0][0] = true;
        for(int i=0; i<=s1.length(); i++) {
            for(int j=0; j<=s2.length(); j++) {
                var k=i+j;
                // Need to fill 0th row. represents a string with only chars of s1.
                if(i>0 && s1.charAt(i-1) == s3.charAt(k-1)) {
                    dp[i][j] = dp[i-1][j];
                }
                // Need to fill 0th col. represents only chars of s2
                if(j>0 && s2.charAt(j-1) == s3.charAt(k-1)) {
                    dp[i][j] = dp[i][j] || dp[i][j-1];
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
