
class Solution {
    public int numIslands(char[][] grid) {
        int result = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    result++;
                    markVisited(i, j, grid);
                }
            }
        }
        return result;
    }

    void markVisited(int i, int j, char[][] grid) {
        if( i>= grid.length || i<0
            || j >=grid[0].length || j<0
            || grid[i][j] == '0') 
                return;
        // using the input array to track visited and not using visited array
        grid[i][j] = '0';

        markVisited(i+1, j, grid);
        markVisited(i-1, j, grid);
        markVisited(i, j+1, grid);
        markVisited(i, j-1, grid);
    }
}
