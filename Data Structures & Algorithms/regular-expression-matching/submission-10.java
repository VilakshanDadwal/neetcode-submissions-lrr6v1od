// Revision - Bottom up 1 Array
class Solution {
    public boolean isMatch(String s, String p) {
        var current = new boolean[p.length()+1];
        for(int i=s.length(); i>=0; i--) {
            current[p.length()] = i == s.length() ? true : false;
            var prevValue = i==s.length()-1 ? true : false;
            for(int j=p.length()-1; j>=0; j--) {
                var temp = current[j];
                var areCharsMatching = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.' );
                if(j<p.length()-1 && p.charAt(j+1) == '*') {
                    current[j] = current[j+2] || (areCharsMatching && current[j]);
                } else {
                    current[j] = areCharsMatching && prevValue;
                }
                prevValue = temp;
            }
        }
        return current[0];
    }
}
