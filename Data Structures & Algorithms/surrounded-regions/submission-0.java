class Solution {
    public void solve(char[][] board) {
        var rows = new int[]{0, board.length-1};
        var cols = new int[]{0, board[0].length -1};

        for(int j=0; j<board[0].length; j++) {
            for(int row: rows) {
                if(board[row][j] =='O') {
                    dfs(row, j, board);
                }
            }
        }

        for(int i=0; i<board.length; i++) {
            for(int col: cols) {
                if(board[i][col] =='O') {
                    dfs(i, col, board);
                }  
            }
        }

        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(board[i][j] == 'O') board[i][j] ='X';
                if(board[i][j] == '1') board[i][j] ='O';
            }
        }
    }

    void dfs(int row, int col, char[][] board) {
        if(row <0 || row >= board.length
            || col<0 || col >= board[0].length
            || board[row][col] == '1' || board[row][col] == 'X') 
                return;

        board[row][col] = '1';

        dfs(row+1, col, board);
        dfs(row-1, col, board);
        dfs(row, col+1, board);
        dfs(row, col-1, board);
    }
}
