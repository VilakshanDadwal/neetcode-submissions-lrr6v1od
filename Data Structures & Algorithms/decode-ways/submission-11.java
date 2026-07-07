class Solution {
    public int numDecodings(String s) {
        var dp = new int[s.length()+1];
        dp[s.length()] = 1;
        for(int i=s.length()-1 ;i>=0; i--) {
            if(s.charAt(i) == '0') {
                dp[i] = 0;
                continue;
            }

            dp[i] = dp[i+1];

            if(i<s.length()-1 && isValid(s, i)) {
                dp[i] += dp[i+2];
            }
        }
        return dp[0];
    }

    boolean isValid(String s, int i) {
        if(s.charAt(i) -'0' > 2 
            || (s.charAt(i) - '0' == 2 && s.charAt(i+1) -'0' > 6))
            return false;
        return true;
    }
}
