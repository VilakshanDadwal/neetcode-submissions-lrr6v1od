// Bottom up optimized.
class Solution {
    public int minDistance(String s1, String s2) {
        String bigger = s1;
        String smaller = s2;
        if(s1.length() < s2.length()) {
            smaller = s1;
            bigger = s2;
        }

        var current = new int[smaller.length()+1];
        var prev = new int[smaller.length()+1];

        for (int j = 0; j <= smaller.length(); j++) {
            prev[j] = smaller.length() - j;
        }

        for(int i=bigger.length()-1; i>=0; i--) {
            current[smaller.length()] = bigger.length()-i;
            for(int j=smaller.length()-1; j>=0; j--) {
                if(bigger.charAt(i) == smaller.charAt(j)) {
                    current[j] = prev[j+1];
                 } else {
                    current[j] = 1 + Math.min(prev[j],
                                 Math.min(
                                    current[j+1], 
                                    prev[j+1]));
                }
            }
            var tmp = prev;
            prev = current;
            current = tmp;
        }
        return prev[0];
    }
}
