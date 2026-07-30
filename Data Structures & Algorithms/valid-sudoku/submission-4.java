class Solution {
    public boolean isValidSudoku(char[][] board) {
        var rows = new boolean[9][9];
        var cols = new boolean[9][9];
        var boxes = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    continue;

                // Map char '1'-'9' to index 0-8
                int val = board[i][j] - '1';
                int boxId = (i / 3) * 3 + (j / 3);

                if (rows[i][val] || cols[j][val] || boxes[boxId][val]) {
                    return false;
                }

                rows[i][val] = true;
                cols[j][val] = true;
                boxes[boxId][val] = true;
            }
        }
        return true;
    }
}
