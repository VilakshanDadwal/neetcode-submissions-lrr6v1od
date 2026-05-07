// Revision - reformat
class Solution {
    public int lengthOfLongestSubstring(String s) {
        var posn = new HashMap<Character, Integer>();
        var maxLength = 0;
        var startIdx =0;
        for(int endIdx=0; endIdx < s.length(); endIdx++) {
            char c = s.charAt(endIdx);
            if(posn.containsKey(c) && posn.get(c) >= startIdx) {
                startIdx = posn.get(c) + 1; 
            }
            maxLength = Math.max(maxLength, endIdx - startIdx + 1);
            posn.put(c, endIdx);
        }
        return maxLength;
    }
}
