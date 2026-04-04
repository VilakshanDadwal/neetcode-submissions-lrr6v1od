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
            // Init the diagonal previous value representing prev[j-1]
            var prevValue = i - 1;
            current[0] = i;
            for(int j=1; j<=smaller.length(); j++) {
                // storing current index value in a temp array.
                var temp = current[j];
                if(bigger.charAt(i-1) == smaller.charAt(j-1)) {
                    current[j] = prevValue;
                } else {
                    current[j] = 1 + Math.min(current[j], 
                                        Math.min(prevValue, current[j-1]));
                }
                // Setting the previous value of current index to a variable
                // This is used in next iteration.
                prevValue = temp;
            }
        }
        return current[smaller.length()];
    }
}
