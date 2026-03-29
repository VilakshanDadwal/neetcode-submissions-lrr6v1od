// Brute Force
class Solution {
    public int characterReplacement(String s, int k) {
        int longestLength = 0;
        for(int i=0; i<s.length(); i++) {
            var charCount = new HashMap<Character, Integer>();
            // Keeping track of maximum frequency of character in current substring.
            int maxFreqChar = 0;
            for(int j=i; j< s.length(); j++) {
                char currentChar = s.charAt(j);
                charCount.put(currentChar, charCount.getOrDefault(currentChar, 0) + 1);
                maxFreqChar = Math.max(maxFreqChar, charCount.get(currentChar));
                int currentSubstringLength = j-i+1;
                if(currentSubstringLength - maxFreqChar <=k) {
                    longestLength = Math.max(longestLength, currentSubstringLength);
                }
            }
        }
        return longestLength;
    }
}
