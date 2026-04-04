// Revision 1 array
class Solution {
    public int minDistance(String word1, String word2) {
        var bigger = word1;
        var smaller = word2;
        if(word1.length() < word2.length()) {
            smaller = word1;
            bigger = word2;
        }

        var current = new int[smaller.length()+1];
        
        for(int j=0; j<=smaller.length(); j++) {
            current[j] = j;
        }
        
        for(int i=1; i<= bigger.length(); i++) {
            // Init the diagonal previous value representing prev[j-1]. prev[0] 0,1,2,3,4,5.
            var prevValue = i - 1;
            current[0] = i;
            for(int j=1; j<=smaller.length(); j++) {
                int newCurrentValue;
                if(bigger.charAt(i-1) == smaller.charAt(j-1)) {
                    newCurrentValue = prevValue;
                } else {
                    newCurrentValue = 1 + Math.min(current[j], 
                                        Math.min(prevValue, current[j-1]));
                }
                // Use the existing value to set prevValue
                prevValue = current[j];
                current[j] = newCurrentValue; // Update new calculated vlaue in the array.
            }
        }
        return current[smaller.length()];
    }
}
