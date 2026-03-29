class Solution {
    public void islandsAndTreasure(int[][] grid) {
        var queue = new LinkedList<int[]>();
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j]==0) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        updateGrid(grid, queue);
    }
    void updateGrid(int[][] grid, Queue<int[]> queue) {
        int[][] dirs ={{1,0}, {0,1}, {-1,0}, {0,-1}};
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            for(int[] dir:dirs) {
                int r = row + dir[0];
                int c = col + dir[1];
                if(r>=0 && c>=0 && r<grid.length && c<grid[0].length
                    && grid[r][c]==Integer.MAX_VALUE) {
                    queue.add(new int[]{r,c});
                    grid[r][c] = grid[row][col] +1;
                }
            }

        }
    }

}
