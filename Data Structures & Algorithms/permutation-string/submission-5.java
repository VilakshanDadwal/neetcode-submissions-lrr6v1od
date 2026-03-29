// Revision Optimal Map solution
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        var s1CharCount = new HashMap<Character, Integer>();
        var s2CharCount = new HashMap<Character, Integer>();

        for(char c: s1.toCharArray()) {
            s1CharCount.put(c, s1CharCount.getOrDefault(c, 0) + 1);
        }

        var matchesNeeded = s1CharCount.size();
        var currentMatches = 0;
        var left = 0;

        // Update matches for current window
        for(int right=0; right<s2.length(); right++) {
            var currentChar = s2.charAt(right);
            s2CharCount.put(currentChar, s2CharCount.getOrDefault(currentChar, 0) + 1);
            
            // Increment currentMatches, if same count for currentChar in s1.
            if(s1CharCount.containsKey(currentChar) 
                && s1CharCount.get(currentChar) == s2CharCount.get(currentChar))
                    currentMatches++;
            // If window size greater than s1 size, remove left from current window.
            // Also decrement matches, if removing left , removes a matching char count.
            var windowSize = right - left + 1;
            if(windowSize > s1.length()) {
                var leftChar = s2.charAt(left);
                // If the left char in s2 was matching with same char in s1 before removal.
                if(s1CharCount.containsKey(leftChar) 
                    && s1CharCount.get(leftChar) == s2CharCount.get(leftChar))
                    currentMatches--;
                s2CharCount.put(leftChar, s2CharCount.get(leftChar) - 1);
                if(s2CharCount.get(leftChar) == 0) s2CharCount.remove(leftChar);
                left++;
            }
            if(matchesNeeded == currentMatches) 
                return true;
        }
        return false;
    }
}
