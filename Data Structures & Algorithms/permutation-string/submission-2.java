// Attemp to try out optimal solution using map
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (char c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int matches = 0;
        int required = need.size();
        int l = 0;

        for (int r = 0; r < s2.length(); r++) {
            char c = s2.charAt(r);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if (need.containsKey(c) && window.get(c).intValue() == need.get(c).intValue()) {
                matches++;
            }

            // keep window size == s1.length()
            if (r - l + 1 > s1.length()) {
                char leftChar = s2.charAt(l);
                if (need.containsKey(leftChar) &&
                    window.get(leftChar).intValue() == need.get(leftChar).intValue()) {
                    matches--;
                }

                window.put(leftChar, window.get(leftChar) - 1);
                if (window.get(leftChar) == 0) {
                    window.remove(leftChar);
                }
                l++;
            }

            if (matches == required) {
                return true;
            }
        }
        return false;
    }
}
