class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        var maxArea = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, traverse(grid, i, j));
                }
            }
        }
        return maxArea;
    }

    private int traverse(int[][] grid, int row, int col) {
        if(row < 0 || col < 0
            || row >= grid.length || col >= grid[0].length
            || grid[row][col] ==0) {
                return 0;
            }
        grid[row][col] = 0;
        return 1 + traverse(grid, row+1, col) 
                + traverse(grid, row-1, col) 
                + traverse(grid, row, col+1) 
                + traverse(grid, row, col-1);
    }
}
