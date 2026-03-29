// Sliding Window - Optimal- Trying out wit array
class Solution {
    public int characterReplacement(String s, int k) {
        int longestLength = 0;
        var charCount = new int[26];
    
        int left=0;
        int maxFreqTillNow = 0;

        for(int right=0; right<s.length(); right++) {
            char currentChar = s.charAt(right);
            charCount[currentChar -'A']++;
            maxFreqTillNow = Math.max(maxFreqTillNow, charCount[currentChar -'A']);
            
            // Move window if right char not creating valid substring.
            while(right-left+1 - maxFreqTillNow > k) {
                charCount[s.charAt(left) - 'A']--;
                left++;
            }
            longestLength = Math.max(longestLength, right-left+1);
        }
        return longestLength;
    }
}
