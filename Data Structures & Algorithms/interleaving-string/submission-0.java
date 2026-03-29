// Memoization
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length())
            return false;
        var cache = new Boolean[s1.length()+1][s2.length()+1];
        return helper(s1, s2, s3, 0,0,0, cache);  
    }

    boolean helper(String s1, String s2, String s3, int i, int j, int k, Boolean[][] cache) {
    
        if(i==s1.length() && j==s2.length() && k==s3.length())
            return true;
        if(cache[i][j] != null)
            return cache[i][j];
        
        cache[i][j] = false;
        if(i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            cache[i][j] = helper(s1, s2, s3, i+1, j, k+1, cache);
            if(cache[i][j]) return true;
        }
        
        if(j < s2.length() && s2.charAt(j) == s3.charAt(k))
            cache[i][j] = helper(s1, s2, s3, i, j+1, k+1, cache);
        
        return cache[i][j];
    }
}
