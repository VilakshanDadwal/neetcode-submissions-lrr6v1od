// Neater Implementation.
class Solution {
    int[][] directions = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};
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
        if(cache[i][j] !=0) return cache[i][j];
        // Every cell has itself as LIP. so starting LIP is 1.
        var currentLIP =1;
        for(int[] dir: directions) {
            var newRow = i+dir[0];
            var newCol = j+dir[1];
            // If invalid neighbour , skip it, because other neighbours still need to be checked.
            if(newRow<0 || newCol<0 
                || newRow >= matrix.length || newCol >= matrix[0].length) 
                continue;
            // DFS if neighbour is greater.
            if(matrix[i][j] < matrix[newRow][newCol]) {
                currentLIP = Math.max(currentLIP, 1 + dfs(newRow, newCol, matrix, cache));
            }          
        }
        
        return cache[i][j] = currentLIP;
    }
}
