// Revision - recursion
class Solution {
    public boolean isMatch(String s, String p) {
        return isMatch(0, 0, s, p);
    }

    private boolean isMatch(int i, int j, String s, String p) {
        if(j==p.length()) return i==s.length();

        if(j<p.length()-1 && p.charAt(j+1) == '*') {
          boolean result = false;
          if(i<s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.' )) {
            result = isMatch(i+1, j, s,p);
          }
          return result || isMatch(i, j+2, s, p);
        } else if (i < s.length() && (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j))){
            return isMatch(i+1, j+1, s, p);
        }
        return false;
    } 
}
