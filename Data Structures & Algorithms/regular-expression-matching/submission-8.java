// Revision - Bottom up Space Optimized
class Solution {
    public boolean isMatch(String s, String p) {
        var current = new boolean[p.length()+1];
        var prev = new boolean[p.length()+1];
        for(int i=s.length(); i>=0; i--) {
            current[p.length()] = i == s.length() ? true : false;
            for(int j=p.length()-1; j>=0; j--) {
                var areCharsMatching = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.' );
                if(j<p.length()-1 && p.charAt(j+1) == '*') {
                    current[j] = current[j+2] || (areCharsMatching && prev[j]);
                } else {
                    current[j] = areCharsMatching && prev[j+1];
                }
            }
            var temp = prev;
            prev = current;
            current = temp;
        }
        return prev[0];
    }
}
