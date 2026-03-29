// Sliding Window
class Solution {
    public int characterReplacement(String s, int k) {
        int longestLength = 0;
        var charSet = new HashSet<Character>();
        for(char c: s.toCharArray()) {
            charSet.add(c);
        }

        for(char c: charSet) {
            int charCount = 0;
            int left=0;
            for(int right=0; right<s.length(); right++) {
                char currentChar = s.charAt(right);
                if(currentChar == c) 
                    charCount++;
                
                // Repeatable char substring not possible.
                while((right-left+1) - charCount > k) {
                    if(s.charAt(left) == c)
                        charCount--;
                    left++;
                }
                // if repeatable char substring possible
                longestLength = Math.max(longestLength, right-left+1);
            }
        }
        return longestLength;
    }
}
