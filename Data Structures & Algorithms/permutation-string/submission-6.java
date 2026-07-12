// Latest optimisied code removing unnecessary checks.
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        if (s1.length() > s2.length())
            return false;
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

            // ONLY track the character if it is needed for s1
            // Increment currentMatches, if same count for currentChar in s1.
            if (s1CharCount.containsKey(currentChar)) {
                s2CharCount.put(currentChar, s2CharCount.getOrDefault(currentChar, 0) + 1);

                // Use .equals() for safe Integer object comparison
                if (s1CharCount.get(currentChar).equals(s2CharCount.get(currentChar))) {
                    currentMatches++;
                }
            }

            var windowSize = right - left + 1;
            if (windowSize > s1.length()) {
                var leftChar = s2.charAt(left);

                // ONLY adjust if we were actually tracking this character
                if (s1CharCount.containsKey(leftChar)) {
                    if (s1CharCount.get(leftChar).equals(s2CharCount.get(leftChar))) {
                        currentMatches--;
                    }
                    s2CharCount.put(leftChar, s2CharCount.get(leftChar) - 1);
                }
                left++;
            }

            if (matchesNeeded == currentMatches)
                return true;
        }
        return false;
    }
}
