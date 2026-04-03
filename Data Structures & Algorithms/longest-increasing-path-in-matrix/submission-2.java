// Neater Implementation.
class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        var ROWS = matrix.length;
        var COLS = matrix[0].length;
        int[][] cache = new int[ROWS][COLS];
        var LIP = Integer.MIN_VALUE;
        for(int i=0; i<ROWS; i++) {
            for(int j=0; j<COLS; j++) {
                LIP = Math.max(LIP, dfs(i, j, matrix, cache));
            }
        }
        return LIP;
    }

    private int dfs(int i, int j, int[][] matrix, int[][] cache) {
        // Check if invalid row col 
        if(i<0 || i >= matrix.length ||
            j < 0 || j >= matrix[0].length) return 0;

        if(cache[i][j] !=0) return cache[i][j];
        var left =  (i > 0 && matrix[i][j] < matrix[i-1][j]) ? dfs(i-1, j, matrix, cache) : 0;
        var right = (i < matrix.length - 1 && matrix[i][j] < matrix[i+1][j]) ? dfs(i+1, j, matrix, cache) : 0;
        var up =  (j > 0 && matrix[i][j] < matrix[i][j-1]) ? dfs(i, j-1, matrix, cache) : 0;
        var down =  (j < matrix[0].length - 1 && matrix[i][j] < matrix[i][j+1]) ? dfs(i, j+1, matrix, cache) : 0;

        
        
        
        return cache[i][j] = 1 + Math.max(Math.max(left, right), Math.max(up,down));
    }
}
