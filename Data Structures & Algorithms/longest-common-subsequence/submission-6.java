class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        String bigger = text1;
        String smaller = text2;
        if(bigger.length() < smaller.length()) {
            bigger = text2;
            smaller = text1;
        }

        var current = new int[smaller.length()+1];
        var prev = new int[smaller.length()+1];
        current[0]=0;
        for(int i=1; i<=bigger.length(); i++) {
            for(int j=1; j<=smaller.length(); j++) {
                if(bigger.charAt(i-1) == smaller.charAt(j-1)) {
                    current[j] = 1+prev[j-1];
                } else {
                    current[j] = Math.max(prev[j], current[j-1]);
                }
            }
            int[] tmp = prev;
            prev = current;
            current = tmp;
        }
        return prev[smaller.length()];
    }
}
