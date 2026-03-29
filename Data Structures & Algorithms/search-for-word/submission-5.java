// Revision - With visited array.
class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0; i< board.length; i++) {
            for(int j=0; j < board[0].length; j++) {
                if(dfs(0, i, j, word, board))
                    return true;
            }
        }
        return false;
    }

    private boolean dfs(int idx, int row, int col, String word, char[][] board) {
        if(idx == word.length()) 
            return true;
        if(row<0||row>=board.length || col<0 || col>=board[0].length) 
            return false;
        // If already visited in current path.
        if(board[row][col] == '#') 
            return false;
        if(word.charAt(idx) != board[row][col]) 
            return false;
        
        // This is a way to mark it visited along current path. 
        // Dont need a separate visited array then.
        board[row][col] = '#';
        
        var result = dfs(idx+1, row-1, col, word, board)
            || dfs(idx+1, row+1, col, word, board)
            || dfs(idx+1, row, col-1, word, board)
            || dfs(idx+1, row, col+1, word, board);

        // Resetting it to original value because it should not be considered visited
        // in other depth first search paths.
        board[row][col] = word.charAt(idx);
        return result;
    }
}
