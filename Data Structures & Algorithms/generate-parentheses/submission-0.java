class Solution {
    public List<String> generateParenthesis(int n) {
        var result = new ArrayList<String>();
        backtrack(n, n, new StringBuilder(), result);
        return result;
    }

    private void backtrack(int openRemaining, int closeRemaining, StringBuilder current, List<String> result) {
        if(openRemaining==0 && closeRemaining==0) {
            result.add(current.toString());
            return;
        }

        if(openRemaining >0) {
            current.append('(');
            backtrack(openRemaining-1, closeRemaining, current, result);
            current.deleteCharAt(current.length()-1);
        }

        if(closeRemaining>openRemaining) {
            current.append(')');
            backtrack(openRemaining, closeRemaining-1, current, result);
            current.deleteCharAt(current.length()-1);
        }
    }
}
