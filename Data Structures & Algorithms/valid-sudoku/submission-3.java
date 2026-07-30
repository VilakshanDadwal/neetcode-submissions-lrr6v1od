class Solution {
    public boolean isValidSudoku(char[][] board) {
        var rows = new ArrayList<Set<Character>>();
        var cols = new ArrayList<Set<Character>>();
        var boxes = new ArrayList<Set<Character>>();

        for(int i=0; i<9; i++) {
            rows.add(new HashSet<Character>());
            cols.add(new HashSet<Character>());
            boxes.add(new HashSet<Character>());
        }

        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                var current = board[i][j];
                if(current == '.') continue;
                var boxId = 3 * (i/3) + j/3;
                if(rows.get(i).contains(current) || cols.get(j).contains(current) 
                        || boxes.get(boxId).contains(current))
                    return false;
                rows.get(i).add(current);
                cols.get(j).add(current);
                boxes.get(boxId).add(current);
            }
        }
        return true;
    }
}
