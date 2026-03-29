class Solution {
    public int numIslands(char[][] grid) {
        var visited = new boolean[grid.length][grid[0].length];
        int result = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(visited[i][j]) continue;
                if(grid[i][j] == '1') {
                    result++;
                    markVisited(i, j, grid, visited);
                }
                visited[i][j] = true;
            }
        }
        return result;
    }

    void markVisited(int i, int j, char[][] grid, boolean[][] visited) {
        if( i>= grid.length || i<0
            || j >=grid[0].length || j<0
            || visited[i][j] 
            || grid[i][j] == '0') 
                return;
                
        visited[i][j] = true;

        markVisited(i+1, j, grid, visited);
        markVisited(i-1, j, grid, visited);
        markVisited(i, j+1, grid, visited);
        markVisited(i, j-1, grid, visited);
    }
}
