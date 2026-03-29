class Solution {
    public int lengthOfLongestSubstring(String s) {
        var left =0;
        var longest = 0;
        var map = new HashMap<Character, Integer>();
        for(int right=0; right < s.length(); right++) {
            var currentChar = s.charAt(right);
            if(map.containsKey(currentChar) && map.get(currentChar) >= left) {
                left = map.get(currentChar) + 1;
                map.put(currentChar, right);
            } else {
                map.put(currentChar, right);
            }
            longest=Math.max(longest, right - left + 1);
        }
        return longest;
    }
}
