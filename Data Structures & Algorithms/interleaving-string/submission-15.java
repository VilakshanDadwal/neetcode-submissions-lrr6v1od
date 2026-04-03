// Revision - Bottom up 1D space optimized
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length() != s3.length()) return false;
        var smaller = s1;
        var bigger = s2;
        
        if(s1.length() > s2.length()) {
            smaller = s2;
            bigger = s1;
        }

        var current = new boolean[smaller.length()+1];
        
        // This case represents, can we form 0 length string of s3 
        // using 0 chars from s1 and 0 from s2. Yes we can. Empty+Empty = empty
        current[0] = true;
        
        // Populate first row
        for(int j=1; j<=smaller.length(); j++) {
            // If current chars matching, check the previous use previos col result.
            current[j] = smaller.charAt(j-1) == s3.charAt(j-1)
                         && current[j-1] ;
        }
        for(int i=1; i<=bigger.length(); i++) {
            for(int j=0; j<=smaller.length(); j++) {
                var k=i+j;
                // Need to fill 0th row. represents a string with only chars of s1.
                if(i>0 && bigger.charAt(i-1) != s3.charAt(k-1)) {
                    current[j] = false;
                }
                // Need to fill 0th col. represents only chars of s2
                if(j>0 && smaller.charAt(j-1) == s3.charAt(k-1)) {
                    current[j] = current[j] || current[j-1];
                }
            }
        }
        return current[smaller.length()];
    }
}
