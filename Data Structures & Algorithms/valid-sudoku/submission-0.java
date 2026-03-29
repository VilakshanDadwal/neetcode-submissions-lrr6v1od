class Solution {
    public boolean isValidSudoku(char[][] board) {
        var rows = new HashMap<Integer, Set<Character>>();
        var cols = new HashMap<Integer, Set<Character>>();
        var squares = new HashMap<String, Set<Character>>();

        for(int row=0; row < 9; row++) {
            for(int col=0; col < 9; col++) {
                var currentChar = board[row][col];
                // This is the main thing to come up with in the solution.
                // To uniquely identify a 3 by 3 square, this key is used.
                var squareKey = row/3 + "," + col/3;
                if(board[row][col] == '.') continue;
                if(rows.computeIfAbsent(row, k -> new HashSet())
                    .contains(currentChar) 
                    || cols.computeIfAbsent(col, k -> new HashSet())
                        .contains(currentChar)
                    || squares.computeIfAbsent(squareKey, k -> new HashSet())
                        .contains(currentChar))
                    return false;
                rows.get(row).add(currentChar);
                cols.get(col).add(currentChar);
                squares.get(squareKey).add(currentChar);
            }
        }
        return true;
    }
}