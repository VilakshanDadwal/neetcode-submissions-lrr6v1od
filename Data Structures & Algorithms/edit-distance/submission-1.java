// Memoization.
class Solution {
    public int minDistance(String s1, String s2) {
        int[][] cache = new int[s1.length() + 1][s2.length() + 1];
        for(int i=0; i<=s1.length(); i++) {
            for(int j=0; j<=s2.length(); j++) {
                cache[i][j] = -1;
            }
        }
        return minDistance(s1, s2, 0, 0, cache);
    }

    int minDistance(String s1, String s2, int i, int j, int[][] cache) {
        if(i==s1.length() && j==s2.length())
            return 0;
        if(i==s1.length()) return s2.length()-j;
        if(j==s2.length()) return s1.length()-i;
        
        if(cache[i][j] != -1)
            return cache[i][j];
        if(s1.charAt(i) == s2.charAt(j)) {
            cache[i][j] = minDistance(s1, s2, i+1, j+1, cache);
        } 
         else {
            cache[i][j] = 1 + Math.min(minDistance(s1, s2, i+1, j, cache),
                                 Math.min(
                                    minDistance(s1, s2, i, j+1, cache), 
                                    minDistance(s1, s2, i+1, j+1, cache)));
         }
        
        return cache[i][j];
    }
}
