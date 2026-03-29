class Solution {
    public boolean isMatch(String s, String p) {
        // s.length()+1 and p.length()+1 , becasuse when idx == s.length p.length base case is evaluated.
        var cache = new Boolean[s.length()+1][p.length()+1];
        return dfs(s, p, 0, 0, cache);
    }

    private boolean dfs(String s, String p, int i, int j, Boolean[][] cache) {
        if(cache[i][j] != null) return cache[i][j];
        // If reached end of both strings, means found a way to match pattern with input string.
        if(i >= s.length() && j >= p.length()) return true;
        // if still characters remaining in string but reached at of pattern, then some chars in input string didnt match with pattern.
        if(i < s.length() && j >= p.length()) return false; 
        // If input string index is at the end of input string, but pattern index is not at the end
        // there can still exist a possible match. This can be in and example aa , a*
        var match = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        if(j+1 < p.length() && p.charAt(j+1) == '*') {
            cache[i][j] = dfs(s, p, i, j+2, cache) // i,j+2 signifies * is not used to represent the current input string char.
                    || (match && dfs(s, p, i+1, j, cache)); // i+1,j signifies * is used to represetn the current input string char.
                    // match is also considered here because only if the char before * matches the input string char, * can be considered.
        } else {
            cache[i][j] = match && dfs(s,p, i+1, j+1, cache);
        }
        return cache[i][j];
    }
}
