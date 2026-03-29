// BFS
class Solution {
    public int numIslands(char[][] grid) {
        int result = 0;
        var stack = new Stack();
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

    void  markVisited(int i, int j, char[][] grid) {
        grid[i][j] = '0'; // marking visited, by using input array.
        var queue = new LinkedList<int[]>();
        queue.add(new int[]{i, j});
        while(!queue.isEmpty()) {
            int[] current = queue.poll(); 
            int row = current[0];
            int col = current[1];
            // DFS to mark neighbours
            markNeighbours(row, col, grid, queue);
        }
    }

    void markNeighbours(int i, int j, char[][] grid, Queue<int[]> queue) {
        // Get neighbours and mark them visited.
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for(int[] dir: dirs) {
            int row = i + dir[0];
            int col = j + dir[1];
            if( row<grid.length && row>=0 && col < grid[0].length && col>=0
                && grid[row][col] == '1') {
                    queue.add(new int[]{row, col});
                    grid[row][col] = '0'; // Mark visited.
                }
        }
    }
}
