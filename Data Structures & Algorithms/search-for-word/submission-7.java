// Revision
class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(search(i,j,0,board, word)) return true;
            }
        }
        return false;
    }

    private boolean search(int row, int col, int idx, char[][] board, String word) {
        if(idx == word.length()) return true;

        if(row < 0 || col <0 || row >= board.length || col >= board[0].length) return false;
        
        if(word.charAt(idx) != board[row][col]) return false;
        
        board[row][col] = '#';

        var isWordFound =  search(row+1, col, idx+1, board, word) 
        || search(row-1, col, idx+1, board, word) 
        || search(row, col+1, idx+1, board, word) 
        || search(row, col-1, idx+1, board, word);
        
        if(isWordFound) return true;

        board[row][col] = word.charAt(idx);
        return false;
    }
}
