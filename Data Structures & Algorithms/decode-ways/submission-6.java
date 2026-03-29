// Revision- bottom up.
class Solution {
    public int numDecodings(String s) {
        var dp = new int[s.length()+1];
        dp[s.length()] = 1;
        for(int i=s.length()-1; i>=0;i--) {
            if(s.charAt(i) == '0') {
                dp[i] = 0;
                continue;
            }
            // If char is not 0, single char check is valid.
            dp[i] = dp[i+1];
            if(i<s.length()-1 && validTwoDigit(s, i)) {
                dp[i] = dp[i] + dp[i+2];
            }
        }
        return dp[0];
    }

    boolean validTwoDigit(String s, int i) {
        int currentNum = s.charAt(i) - '0';
        int nextNum = s.charAt(i+1) - '0';
        if(currentNum ==1 || (currentNum==2 && nextNum<=6)) {
            return true;
        }
        return false;
    }
}