// Revision - recursion cleaner
class Solution {
    public boolean isMatch(String s, String p) {
        return isMatch(0, 0, s, p);
    }

    private boolean isMatch(int i, int j, String s, String p) {
        if(j==p.length()) return i==s.length();
        var areCharsMatching = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.' );
        
        if(j<p.length()-1 && p.charAt(j+1) == '*') {
          return isMatch(i, j+2, s, p) // Case isMatch(i, j+2, s, p) - consider current char at j and * combo as. '' no char.
          || (areCharsMatching && isMatch(i+1, j, s,p)); //Case - * exists j+1 , current j matches with i
        } 
        return areCharsMatching && isMatch(i+1, j+1, s, p); // Case - when current char matches with pattern char.
    } 
}
