class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int numRows = heights.length;
        int numCols = heights[0].length;
        boolean[][] pacific = new boolean[numRows][numCols];
        boolean[][] atlantic = new boolean[numRows][numCols];
        for(int i=0;i<numRows;i++) {
            dfs(i, 0, pacific, heights);
            dfs(i, numCols-1, atlantic, heights);
        }

        for(int j=0;j<numCols;j++) {
            dfs(0, j, pacific, heights);
            dfs(numRows-1, j, atlantic, heights);
        }

        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i<numRows; i++) {
            for(int j=0; j< numCols; j++) {
                if(pacific[i][j] && atlantic[i][j])
                    result.add(Arrays.asList(i,j));
            }
        }
        return result;
    }

    void dfs(int row, int col, boolean[][] reachable, int[][] heights) {
        int[][] directions = {{1, 0}, {-1, 0},
                                  {0, 1}, {0, -1}};
        reachable[row][col] = true;
        for(int[] dir: directions) {
            int nRow = row + dir[0];
            int nCol = col + dir[1];
            if(nRow>=0 && nRow < heights.length
                && nCol>=0 && nCol < heights[0].length
                && !reachable[nRow][nCol] // not visited
                && heights[nRow][nCol] >= heights[row][col]) {
                    dfs(nRow, nCol, reachable, heights);
                }
        }

    }
}
