// Bottom up optimised 2 array solution.
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length())
            return false;
        var bigger = s1;
        var smaller = s2;
        if(s1.length() < s2.length()) {
            smaller = s1;
            bigger = s2;
        }

        var current = new boolean[smaller.length()+1];
        var prev = new boolean[smaller.length()+1];
        
        // Base case of both empty string comparing with empty k string
        prev[smaller.length()] = true;
        // Filling prev. This is the last row. It represents when bigger string is consumed
        // and only smaller row chars are left.
        for(int j = smaller.length()-1; j>=0; j--) {
            prev[j] = (smaller.charAt(j) == s3.charAt(j+bigger.length())) && prev[j+1];
        }

        for (int i = bigger.length()-1; i >=0; i--) {
            // Filling last value of last column, this is when smaller string is consumed, 
            // and comparing the current bigger string char with s3 current char at(i + smaller.length())
            current[smaller.length()] = (bigger.charAt(i) == s3.charAt(i+smaller.length()) 
                                            && prev[smaller.length()]);

            for (int j = smaller.length()-1; j >=0; j--) {
                current[j] = false;
                var k = i+j;
                if(bigger.charAt(i) == s3.charAt(k) && prev[j]) {
                    current[j] = true;
                    continue;
                }
                if(smaller.charAt(j) == s3.charAt(k)) {
                    current[j] = current[j+1];
                }
            }
            var tmp = prev;
            prev = current;
            current = tmp;
        }  
        return prev[0];     
    }
}
