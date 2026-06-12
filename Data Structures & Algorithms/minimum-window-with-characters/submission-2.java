class Solution {
    public String minWindow(String s, String t) {
        var targetFreq = new HashMap<Character, Integer>();
        for(char c: t.toCharArray()) {
            targetFreq.put(c, targetFreq.getOrDefault(c, 0) + 1);
        }
        var matchesNeeded = targetFreq.size();
        var currentFreq = new HashMap<Character, Integer>();
        var currentMatches = 0;
        var left = 0;
        // Keeping indices larger than the length of the string
        var indices = new int[]{-1, s.length()};
        for(int right = 0; right < s.length(); right++) {
            var rightChar = s.charAt(right);
            if(!targetFreq.containsKey(rightChar)) continue;

            currentFreq.put(rightChar, currentFreq.getOrDefault(rightChar, 0) + 1);
            // If frequency of current char is equal to needed freq of that char, increment matches
            if(currentFreq.get(rightChar).equals(targetFreq.get(rightChar))) {
                currentMatches++;
            }
            // Reduce the left side of window till needed matches equals current matches
            // This loop will be broken out of when a leftChar is found which reduces number of matches
            // It will continue for chars which are not present in target string
            while(currentMatches == matchesNeeded) {
                // index[0] == -1 signifies that this is the first valid window we've found,
                // so record it immediately."
                if(indices[0] == -1 || right - left < indices[1] - indices[0]) {
                    indices[0] = left;
                    indices[1] = right;
                }

                var leftChar = s.charAt(left);
                if(targetFreq.containsKey(leftChar)) {
                    currentFreq.put(leftChar, currentFreq.get(leftChar) - 1);
                    if(currentFreq.get(leftChar) < targetFreq.get(leftChar))
                        currentMatches--;
                }
                left++;
            }
        }
        return indices[0] == -1 ? "" : s.substring(indices[0], indices[1] + 1);
    }
}
