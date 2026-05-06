class Solution {
    public int maxDepth(String s) {
        var openBracketsCount = 0;
        var maxCount = 0;
        for(char c: s.toCharArray()) {
            if(c=='(') {
                openBracketsCount++;
                maxCount = Math.max(maxCount, openBracketsCount);
            } else if(c==')') {
                openBracketsCount--;
            }
        }
        return maxCount;
    }
}