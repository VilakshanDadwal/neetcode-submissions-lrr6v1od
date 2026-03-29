// Revision
class Solution {
    public List<String> generateParenthesis(int n) {
        var result = new ArrayList<String>();
        generate(0,0,n, new StringBuilder(), result);
        return result;
    }
    private void generate(int openCount, int closedCount, int n, StringBuilder current, List<String> result) {
        if(openCount==n && closedCount == n) {
            result.add(current.toString());
            return;
        }

        if(openCount < n) {
            generate(openCount+1, closedCount, n, current.append('('), result);
            current.deleteCharAt(current.length()-1);
        } 

        if(openCount > closedCount) {
            generate(openCount, closedCount+1, n, current.append(')'), result);
            current.deleteCharAt(current.length()-1);
        }
    }
}
