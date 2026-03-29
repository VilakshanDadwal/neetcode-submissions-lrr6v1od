// Bottom up optimized Using single array.
class Solution {
    public int minDistance(String s1, String s2) {
        String bigger = s1;
        String smaller = s2;
        if(s1.length() < s2.length()) {
            smaller = s1;
            bigger = s2;
        }

        var current = new int[smaller.length()+1];
        var prevNext = 0;
        for (int j = 0; j <= smaller.length(); j++) {
            current[j] = smaller.length() - j;
        }

        for(int i=bigger.length()-1; i>=0; i--) {
            // This needs to be done before setting current[smaller.length()] in the next line.
            prevNext = current[smaller.length()];
            current[smaller.length()] = bigger.length()-i;
            for(int j=smaller.length()-1; j>=0; j--) {
                // Storing the value of current[j], because it needs to be used in next iteration of j.
                var tmp = current[j];
                if(bigger.charAt(i) == smaller.charAt(j)) {
                    current[j] = prevNext;
                 } else {
                    current[j] = 1 + Math.min(current[j],
                                 Math.min(
                                    current[j+1], 
                                    prevNext));
                }
                // Assigning the previous current[j] value to prevNext variable.
                // This is used in next iteration.
                prevNext = tmp;
            }
        }
        return current[0];
    }
}