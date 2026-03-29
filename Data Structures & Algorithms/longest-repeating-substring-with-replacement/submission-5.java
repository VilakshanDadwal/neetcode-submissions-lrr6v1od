// Sliding Window - Optimal
class Solution {
    public int characterReplacement(String s, int k) {
        int longestLength = 0;
        var charCount = new HashMap<Character, Integer>();
    
        int left=0;
        int maxFreqTillNow = 0;

        for(int right=0; right<s.length(); right++) {
            char currentChar = s.charAt(right);
            charCount.put(currentChar, charCount.getOrDefault(currentChar,0) + 1);
            maxFreqTillNow = Math.max(maxFreqTillNow, charCount.get(currentChar));
            
            // Move window if right char not creating valid substring.
            while(right-left+1 - maxFreqTillNow > k) {
                charCount.put(s.charAt(left), charCount.get(s.charAt(left)) - 1);
                left++;
            }
            longestLength = Math.max(longestLength, right-left+1);
        }
        return longestLength;
    }
}
