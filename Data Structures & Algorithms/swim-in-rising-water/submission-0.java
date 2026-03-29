class Solution {
    public int swimInWater(int[][] grid) {
        var visited = new boolean[grid.length][grid.length];
        var minHeap = new PriorityQueue<int[]>(Comparator.comparingInt(a -> a[0]));
        int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        // array in heap represents, maxHeightAlongPath, cell row and column
        minHeap.add(new int[]{grid[0][0], 0, 0});
        visited[0][0] = true;

        while(!minHeap.isEmpty()) {
            var current = minHeap.poll();
            var maxHeightAlongPath = current[0];
            var row = current[1];
            var col = current[2];
            if(row == grid.length - 1 && col == grid.length - 1) return maxHeightAlongPath;
            for(int[] direction: directions) {
                int neighbourRow = row + direction[0];
                int neighbourCol = col + direction[1];
                if(neighbourRow >= 0 && neighbourCol >= 0
                    && neighbourRow < grid.length && neighbourCol < grid.length
                    && !visited[neighbourRow][neighbourCol]) {
                        visited[neighbourRow][neighbourCol] = true;
                        minHeap.add(new int[] {
                            Math.max(maxHeightAlongPath, grid[neighbourRow][neighbourCol]),
                            neighbourRow, neighbourCol});
                        }
            }
        }
        return 0;
    }
}
