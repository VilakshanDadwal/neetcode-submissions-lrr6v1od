// Revision - Top Down
class Solution {
    public int uniquePaths(int m, int n) {
        var cache = new int[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                cache[i][j] = -1;
            }
        }
        return dfs(0,0, cache);
    }
    private int dfs(int i, int j, int[][] cache) {
        if(i>=cache.length || j >= cache[0].length)
            return 0;
        if(i==cache.length-1 && j==cache[0].length-1) 
            return 1;
        if(cache[i][j] != -1) return cache[i][j];
        cache[i][j] = dfs(i+1, j, cache) + dfs(i, j+1, cache);
        return cache[i][j];
    }
}
