// Memoization
class Solution {
    public int numDistinct(String s, String t) {
        if(t.length() > s.length()) return 0;
        var cache = new int[s.length()][t.length()];
        for(int i=0; i<s.length(); i++) {
            for(int j=0; j<t.length(); j++) {
                cache[i][j] = -1;
            }
        }
        return numDistinct(0, 0, s, t, cache);
    }

    private int numDistinct(int i, int j, String s, String t, int[][] cache) {
        if(j==t.length()) return 1;
        if(i==s.length()) return 0;

        if(cache[i][j] != -1) return cache[i][j];

        if(s.charAt(i) == t.charAt(j)) {
            cache[i][j] = numDistinct(i+1, j+1, s, t, cache) + numDistinct(i+1, j, s, t, cache);
        } else {
            cache[i][j] = numDistinct(i+1, j, s, t, cache);
        }
        return cache[i][j];
    }
}
