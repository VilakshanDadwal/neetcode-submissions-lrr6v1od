class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        
        var s1CharCount = new HashMap<Character, Integer>();
        var s2CharCount = new HashMap<Character, Integer>();

        for (char c : s1.toCharArray()) {
            s1CharCount.put(c, s1CharCount.getOrDefault(c, 0) + 1);
        }

        var matchesNeeded = s1CharCount.size();
        var currentMatches = 0;
        var left = 0;

        for (int right = 0; right < s2.length(); right++) {
            var currentChar = s2.charAt(right);
            
            // 1. Add the new character to the window
            if (s1CharCount.containsKey(currentChar)) {
                s2CharCount.put(currentChar, s2CharCount.getOrDefault(currentChar, 0) + 1);
                
                if (s1CharCount.get(currentChar).equals(s2CharCount.get(currentChar))) {
                    currentMatches++;
                }
            }
            
            // 2. Check for a win immediately after adding
            if (matchesNeeded == currentMatches) return true;
            
            // 3. STRICT WINDOW CONTROL: 
            // If the window is exactly full, we drop the left character immediately 
            // BEFORE the loop can add a new one on the right.
            var windowSize = right - left + 1;
            if (windowSize == s1.length()) {
                var leftChar = s2.charAt(left);
                
                if (s1CharCount.containsKey(leftChar)) {
                    if (s1CharCount.get(leftChar).equals(s2CharCount.get(leftChar))) {
                        currentMatches--;
                    }
                    s2CharCount.put(leftChar, s2CharCount.get(leftChar) - 1);
                }
                // Slide the left pointer forward so the window size drops to s1.length() - 1
                left++; 
            }
        }
        return false;
    }
}