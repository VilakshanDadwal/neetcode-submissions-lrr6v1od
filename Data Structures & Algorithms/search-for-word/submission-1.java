class Solution {
    public boolean exist(char[][] board, String word) {
        boolean visited[][] = new boolean[board.length][board[0].length];
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(dfs(i, j, board, word, 0, visited)) 
                  return true;
            }
        }
        return false;
    }

    boolean dfs(int row, int col, char[][] board, String word, int wordIdx, boolean[][] visited) {
        if(wordIdx == word.length())
          return true;
        
        if(row <0 || col <0 || row>=board.length || col >= board[0].length
          || word.charAt(wordIdx) != board[row][col] 
          // This check is to avoid circular checks
          || visited[row][col]) 
            return false;
        
        visited[row][col] = true;
        boolean right = dfs(row, col+1, board, word, wordIdx+1, visited);
        boolean left = dfs(row, col-1, board, word, wordIdx+1, visited);
        boolean up = dfs(row-1, col, board, word, wordIdx+1, visited);
        boolean down = dfs(row+1, col, board, word, wordIdx+1, visited);
        
        visited[row][col] = false;
        
        return right || left || up || down;
    }
}
