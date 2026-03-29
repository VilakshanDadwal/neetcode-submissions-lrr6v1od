class Solution {
    int[][] directions = {{0,1}, {1,0}, {-1,0}, {0,-1}};

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j]==1) {
                    maxArea = Math.max(maxArea, findArea(i, j, grid));
                }
            }
        }
        return maxArea;
    }

    int findArea(int i, int j, int[][] grid) {
        var stack = new Stack<int []>();
        stack.push(new int[]{i, j});
        grid[i][j] = '0';
        int area = 0;
        while(!stack.isEmpty()) {
            int[] current = stack.pop();
            int row = current[0];
            int col = current[1];
            area++;
            for(int[] dir : directions) {
                int x = row + dir[0];
                int y = col + dir[1];

                if(x>=0 && x <grid.length
                    && y>=0 && y<grid[0].length
                    && grid[x][y] ==1) {
                        stack.push(new int[]{x, y});
                        grid[x][y] = 0;
                    }
            }
        }
        return area;
    }
}
