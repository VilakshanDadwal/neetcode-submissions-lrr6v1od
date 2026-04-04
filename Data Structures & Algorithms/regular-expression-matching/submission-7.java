// Revision - Bottom up Backward
class Solution {
    public boolean isMatch(String s, String p) {
        var dp = new boolean[s.length()+1][p.length()+1];
        dp[s.length()][p.length()] = true;
        for(int i=s.length(); i>=0; i--) {
            // Last col represents when pattern is consumed. for all but one case, default value for it will be false
            // Only when both pattern and string consumed , then true, for all other i<s.length , j=p.length its false.
            // Thats why starting from j=p.length()-1
            for(int j=p.length()-1; j>=0; j--) {
                var areCharsMatching = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.' );
                if(j<p.length()-1 && p.charAt(j+1) == '*') {
                    dp[i][j] = dp[i][j+2] || (areCharsMatching && dp[i+1][j]);
                } else {
                    dp[i][j] = areCharsMatching && dp[i+1][j+1];
                }
            }
        }
        return dp[0][0];
    }
}
