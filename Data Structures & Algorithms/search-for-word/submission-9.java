// Revision using existing board for visited
class Solution {
    private int[][] directions = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
    public boolean exist(char[][] board, String word) {
        for(int row=0; row<board.length; row++) {
            for(int col=0; col<board[0].length; col++) {
                if(dfs(0, row, col, board, word))
                    return true;
            }
        }
        return false;
    }

    boolean dfs(int idx, int row, int col, char[][] board, String word) {
        if(idx == word.length()) return true;
        if(row >= board.length || row <0 || col<0 || col>= board[0].length
           || board[row][col] =='*' || word.charAt(idx) != board[row][col]) return false;
        
        board[row][col] = '*';
        for(int[] direction : directions) {
            var newRow = row + direction[0];
            var newCol = col + direction[1];
            if(dfs(idx+1, newRow, newCol, board, word))
                return true;
        }
        board[row][col] =  word.charAt(idx);
        return false;
    }
}
