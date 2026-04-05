class Solution {
    public boolean isValidSudoku(char[][] board) {
        var rowSeen = new ArrayList<Set<Character>>();
        var colSeen = new ArrayList<Set<Character>>();
        var boxSeen = new ArrayList<Set<Character>>();
        for(int i=0; i< board.length; i++) {
            rowSeen.add(new HashSet<Character>());
            colSeen.add(new HashSet<Character>());
            boxSeen.add(new HashSet<Character>());
        }

        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {     
                var currentChar = board[i][j];           
                if(currentChar == '.') continue;
                // Representing boxes as a single index in a list 
                var boxIdx = i/3 * 3 + j/3;
                if(!rowSeen.get(i).add(currentChar) 
                    || !colSeen.get(j).add(currentChar) 
                    || !boxSeen.get(boxIdx).add(currentChar))
                        return false;
            }
        }
        return true;
    }
}
