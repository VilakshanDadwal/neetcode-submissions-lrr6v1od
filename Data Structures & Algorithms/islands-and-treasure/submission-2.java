class Solution {
    public void islandsAndTreasure(int[][] grid) {
        var q = new LinkedList<int[]>();
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 0) 
                    q.add(new int[]{i,j});
            }
        }
        var directions = new int[][]{{0,1}, {0,-1},{1,0}, {-1,0}};
        var distance = 1;
        while(!q.isEmpty()) {
            var qLength = q.size();
            for(int i=1; i<=qLength; i++) {
                var cell = q.poll();
                var row = cell[0];
                var col = cell[1];
                for(int[] dir: directions) {
                    var nRow = row+dir[0];
                    var nCol = col+dir[1];
                    if(nRow>=0 && nCol>=0 
                        && nRow <grid.length && nCol <grid[0].length
                        && grid[nRow][nCol] == Integer.MAX_VALUE) {
                            grid[nRow][nCol] = distance;
                            q.add(new int[]{nRow, nCol});
                        }
                }
            }
            distance++;
        }
    }
}