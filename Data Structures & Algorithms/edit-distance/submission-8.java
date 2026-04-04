// Revision 2 array
class Solution {
    public int minDistance(String word1, String word2) {
        var bigger = word1;
        var smaller = word2;
        if(word1.length() < word2.length()) {
            smaller = word1;
            bigger = word2;
        }

        var current = new int[smaller.length()+1];
        var prev = new int[smaller.length()+1];
        
        for(int j=0; j<smaller.length(); j++) {
            prev[j] = j;
        }

        for(int i=1; i<= bigger.length(); i++) {
            current[0] = i;
            for(int j=1; j<=smaller.length(); j++) {
                if(bigger.charAt(i-1) == smaller.charAt(j-1)) {
                    current[j] = prev[j-1];
                } else {
                    current[j] = 1 + Math.min(prev[j], 
                                        Math.min(prev[j-1], current[j-1]));
                }
            }
            var temp = prev;
            prev = current;
            current = temp;
        }
        return prev[smaller.length()];
    }
}
