// Modifing existing grid for visited check.
class Solution {
    private int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int shortestDistance(int[][] grid) {
        var distance = new int[grid.length][grid[0].length];
        var minDistance = Integer.MAX_VALUE;

        var expectedVisitedValue = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 1)
                    continue;
                var currentPassMinDistance = Integer.MAX_VALUE;
                var queue = new LinkedList<int[]>();
                queue.add(new int[] {i, j});
                var level = 0;
                while (!queue.isEmpty()) {
                    var size = queue.size();
                    level++;
                    for (int s = 0; s < size; s++) {
                        var current = queue.poll();
                        var row = current[0];
                        var col = current[1];
                        for (int[] direction : directions) {
                            var nextRow = row + direction[0];
                            var nextCol = col + direction[1];
                            if (nextRow >= 0 && nextCol >= 0 && nextRow < grid.length
                                && nextCol < grid[0].length
                                && grid[nextRow][nextCol] == expectedVisitedValue) {
                                distance[nextRow][nextCol] = distance[nextRow][nextCol] + level;
                                grid[nextRow][nextCol] = grid[nextRow][nextCol] - 1;
                                queue.add(new int[] {nextRow, nextCol});
                                currentPassMinDistance =
                                    Math.min(currentPassMinDistance, distance[nextRow][nextCol]);
                            }
                        }
                    }
                }
                minDistance = currentPassMinDistance;
                expectedVisitedValue--;
            }
        }
        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }
}
