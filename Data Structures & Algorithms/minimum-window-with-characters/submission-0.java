class Solution {
    public String minWindow(String s, String t) {
        var freqT = new HashMap<Character, Integer>();
        var windowFreqS = new HashMap<Character, Integer>();
        var shortestLength = Integer.MAX_VALUE;
        var indices = new int[]{-1,-1};
        // Creating a map of frequency of chars in t.
        for(int i=0; i < t.length(); i++) {
            freqT.put(t.charAt(i), freqT.getOrDefault(t.charAt(i), 0) + 1);
        }

        var left = 0;
        var noUniqueCharsInT = freqT.size();
        var noMatchingCharsInWindow = 0;

        for(int right=0; right < s.length(); right++) {
            // Update frequence of current character of s in window.
            var rightCharOfWindow = s.charAt(right);
            windowFreqS.put(rightCharOfWindow, 
                windowFreqS.getOrDefault(rightCharOfWindow, 0) + 1);
            
            if(windowFreqS.get(rightCharOfWindow) == freqT.get(rightCharOfWindow)) {
                noMatchingCharsInWindow++;
            }

            // When a substring is found with all unique chars and their counts matching,
            // need to find the shortest substring which still has all unique chars matching.
            // This is done by reducing size of window from left and checking every time.
            while(noMatchingCharsInWindow == noUniqueCharsInT) {
                var currentSubstringLength = right-left+1;
                if(currentSubstringLength < shortestLength) {
                    shortestLength = currentSubstringLength;
                    indices[0] = left;
                    indices[1] = right;
                }

                var charAtLeft = s.charAt(left);
                // Count of charAtLeft has to be greater than 0, coz its part of window.
                windowFreqS.put(charAtLeft, windowFreqS.get(charAtLeft) -1);
                // If charAtLeft was present in T , 
                // and its count now does not match the count in window, 
                // noMatchingCharsInWindow needs to be decremented.
                if(freqT.containsKey(charAtLeft) 
                    && windowFreqS.get(charAtLeft) < freqT.get(charAtLeft)) {
                        noMatchingCharsInWindow--;
                }
                // If noMatchingCharsInWindow and noUniqueCharsInT are equal or not,
                // need to move left pointer to consider a new substring.
                left++;
            }
        }
        return shortestLength == Integer.MAX_VALUE 
                ? "" 
                : s.substring(indices[0], indices[1] + 1);
    }
}
