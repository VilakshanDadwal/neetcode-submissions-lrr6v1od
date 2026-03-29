class Solution {
    public int lengthOfLongestSubstring(String s) {
        int startIdx = 0;
        int maxLength = 0;
        var uniqueChars = new HashMap<Character, Integer>();
        for(int i=0; i<s.length(); i++) {
            var currentChar = s.charAt(i);
            if(uniqueChars.containsKey(currentChar) && uniqueChars.get(currentChar) >= startIdx) {
                startIdx = uniqueChars.get(currentChar) + 1;
                uniqueChars.put(currentChar, i);
            } else {
                uniqueChars.put(currentChar, i);
                int currentLength = i - startIdx + 1;
                maxLength = Math.max(currentLength, maxLength);
            }

        }
        return maxLength;
    }
}
