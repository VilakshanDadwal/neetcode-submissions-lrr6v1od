// Revision O(26.n) solution.
class Solution {
    public int characterReplacement(String s, int k) {
        var charCount = new int[26];
        var left = 0;
        var longest = 0;
        for(int right = 0; right < s.length(); right++) {
            charCount[s.charAt(right) - 'A']++;
            var subStringSize = right-left+1;
            while(subStringSize - getMaxCharCount(charCount) > k) {
                charCount[s.charAt(left) - 'A']--;
                subStringSize--;
                left++;
            }
            longest = Math.max(longest, subStringSize);
        }
        return longest;
    }

    private int getMaxCharCount(int[] charCount) {
        var maxCount=0;
        for(int count : charCount) {
            maxCount=Math.max(maxCount, count);
        }
        return maxCount;
    }
}
