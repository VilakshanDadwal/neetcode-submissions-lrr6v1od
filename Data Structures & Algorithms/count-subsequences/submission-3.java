// Bottom Up - Space Optmised - 1 Array
class Solution {
    public int numDistinct(String s, String t) {
        if(t.length() > s.length()) return 0;
        var current = new int[t.length()+1];
        current[0] = 1;
        for(int i=1; i <= s.length(); i++) {
            var prev = 1;
            for(int j=1; j <= t.length(); j++) {       
                var temp = current[j];       
                if(s.charAt(i-1) == t.charAt(j-1)) {
                    current[j] += prev;
                }
                prev = temp;
            }
        }
        return current[t.length()];
    }
}
