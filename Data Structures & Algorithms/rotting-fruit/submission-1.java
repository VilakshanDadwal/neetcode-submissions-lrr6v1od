class Solution {
    public int orangesRotting(int[][] grid) {
        var queue = new LinkedList<int[]>();
        int noOfFreshOranges = 0;
        int minutes =0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 2) queue.add(new int[] {i,j});
                if(grid[i][j] == 1) noOfFreshOranges++;
            }
        }

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        // noOfFreshOranges>0 needed because in the last iteration. 
        // there will be rotte fruit in the queue so queue wont be empty but we do not need to process the last rotten fruits.
        // so noOfFreshOranges > 0 helps to check if any more processing is needed.
        while(noOfFreshOranges>0 && !queue.isEmpty()) {
            minutes++; // Increment minute if elements left in queue
            // Using for loop removes all elements at same level in queue.
            // Usually one element is removed in a queue. 
            // Using this logic all neighbours added in previous iteration are removed. 
            int queueLength = queue.size();
            for(int i=0; i<queueLength; i++) {
                int[] current = queue.poll();
                int currentRow = current[0];
                int currentCol = current[1];
                for(int[] dir: directions) {
                    int row = currentRow + dir[0];
                    int col = currentCol + dir[1];

                    if(row>=0 && row<grid.length
                        && col>=0 && col<grid[0].length
                        && grid[row][col] ==1) {
                            noOfFreshOranges--;
                            grid[row][col] =2;
                            queue.add(new int[]{row, col});
                    }
                }
            }
        }
        return noOfFreshOranges == 0 ? minutes : -1;
    }
}
