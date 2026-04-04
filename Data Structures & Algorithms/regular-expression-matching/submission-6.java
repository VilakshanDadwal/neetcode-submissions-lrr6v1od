// Revision - Memoization
class Solution {
    public boolean isMatch(String s, String p) {
        var cache = new Boolean[s.length()+1][p.length()+1];
        return isMatch(0, 0, s, p, cache);
    }

    private boolean isMatch(int i, int j, String s, String p, Boolean[][] cache) {
        if(j==p.length()) return i==s.length();
        if(cache[i][j] != null) return cache[i][j];

        var areCharsMatching = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.' );
        
        if(j<p.length()-1 && p.charAt(j+1) == '*') {
          cache[i][j] = isMatch(i, j+2, s, p, cache) // Case isMatch(i, j+2, s, p) - consider current char at j and * combo as. '' no char.
          || (areCharsMatching && isMatch(i+1, j, s, p, cache)); //Case - * exists j+1 , current j matches with i
        } else {
            cache[i][j] = areCharsMatching && isMatch(i+1, j+1, s, p, cache); // Case - when current char matches with pattern char.
        }
        return cache[i][j];
    } 
}
