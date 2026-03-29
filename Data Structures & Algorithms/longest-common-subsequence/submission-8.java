class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        String bigger = text1;
        String smaller = text2;
        if(bigger.length() < smaller.length()) {
            bigger = text2;
            smaller = text1;
        }

        var current = new int[smaller.length()+1];
        for(int i=1; i<=bigger.length(); i++) {
            int prev = 0;// previous value when char matches. 
            for(int j=1; j<=smaller.length(); j++) {
                int tmp = current[j];
                if(bigger.charAt(i-1) == smaller.charAt(j-1)) {
                    current[j] = 1+prev;
                } else {
                    current[j] = Math.max(current[j], current[j-1]);
                }
                prev = tmp; 
                // with each col change, the prev value changes.
                // thats why this is in the col for loop and not outside.
            }
            
        }
        return current[smaller.length()];
    }
}
