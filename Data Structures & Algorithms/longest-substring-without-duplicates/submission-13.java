class Solution {
    public int lengthOfLongestSubstring(String s) {
        var freq = new HashMap<Character, Integer>();
        var maxLength = 0;
        var left = 0;
        for(int right=0; right<s.length(); right++) {
            var currentChar = s.charAt(right);
            if(!freq.containsKey(currentChar) || freq.get(currentChar) < left) {
                maxLength = Math.max(maxLength, right - left + 1);
            } else if(freq.get(currentChar) >= left) {
                left = freq.get(currentChar) + 1;
            }
            freq.put(currentChar, right);
        }
        return maxLength;
    }
}
