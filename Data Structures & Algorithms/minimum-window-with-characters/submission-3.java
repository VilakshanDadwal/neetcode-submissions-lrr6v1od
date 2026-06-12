
class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        var targetFreq = new HashMap<Character, Integer>();
        for (char c : t.toCharArray()) {
            targetFreq.put(c, targetFreq.getOrDefault(c, 0) + 1);
        }
        
        var matchesNeeded = targetFreq.size();
        var currentFreq = new HashMap<Character, Integer>();
        var currentMatches = 0;
        
        var left = 0;
        var indices = new int[]{-1, s.length()};

        for (int right = 0; right < s.length(); right++) {
            var rightChar = s.charAt(right);
            
            // 1. Expand the right side
            if (targetFreq.containsKey(rightChar)) {
                currentFreq.put(rightChar, currentFreq.getOrDefault(rightChar, 0) + 1);
                if (currentFreq.get(rightChar).equals(targetFreq.get(rightChar))) {
                    currentMatches++;
                }
            }

            // 2. PROACTIVELY shrink the left side (Your Intuition)
            // We keep moving left forward as long as it points to a useless character.
            while (left <= right) {
                char leftChar = s.charAt(left);
                
                if (!targetFreq.containsKey(leftChar)) {
                    // Character isn't in target string at all -> Skip it
                    left++;
                } else if (currentFreq.get(leftChar) > targetFreq.get(leftChar)) {
                    // Character is in target, but we have more than we need -> Drop one and skip
                    currentFreq.put(leftChar, currentFreq.get(leftChar) - 1);
                    left++;
                } else {
                    // Left is pointing to a strictly necessary character. We cannot shrink further.
                    break;
                }
            }

            // 3. Record the window if it's valid
            // Because of step 2, we know 'left' is already perfectly positioned.
            if (currentMatches == matchesNeeded) {
                if (indices[0] == -1 || right - left < indices[1] - indices[0]) {
                    indices[0] = left;
                    indices[1] = right;
                }
            }
        }
        
        return indices[0] == -1 ? "" : s.substring(indices[0], indices[1] + 1);
    }
}