class Solution {
    int[][] directions = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};
    public int longestIncreasingPath(int[][] matrix) {
        var ROWS = matrix.length;
        var COLS = matrix[0].length;
        int[][] cache = new int[ROWS][COLS];
        var LIP = Integer.MIN_VALUE;
        for(int i=0; i<ROWS; i++) {
            for(int j=0; j<COLS; j++) {
                if(cache[i][j]==0) {
                    cache[i][j] = dfs(i, j, matrix, cache);
                }
                LIP = Math.max(LIP, cache[i][j]);
            }
        }
        return LIP;
    }

    private int dfs(int i, int j, int[][] matrix, int[][] cache) {
        if(cache[i][j] !=0) return cache[i][j];
        for(int[] dir: directions) {
            var newRow = i+dir[0];
            var newCol = j+dir[1];
            // Valid neighbour
            if(newRow<0 || newCol<0 
                || newRow >= matrix.length || newCol >= matrix[0].length) continue;
            // DFS if neighbour is greater.
            if(matrix[i][j] < matrix[newRow][newCol]) {
                cache[i][j] = Math.max(cache[i][j], 1 + dfs(newRow, newCol, matrix, cache));
            }          
        }
        if(cache[i][j]==0) cache[i][j]=1;
        return cache[i][j];
    }
}
