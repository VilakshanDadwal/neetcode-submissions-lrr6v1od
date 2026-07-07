class Solution {
    public int numDecodings(String s) {
        var next1Digit = 1;
        var next2Digit = 0;
        var current = 0;

        for(int i=s.length()-1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                current = 0;
            } else {
                current = next1Digit;
                if(i<s.length()-1 && isValid(s, i)) {
                    current += next2Digit;
                }
            }
            next2Digit = next1Digit;
            next1Digit = current; 
            current = 0;
        }
        return next1Digit;
    }

    private boolean isValid(String s, int i) {
        if (s.charAt(i) - '0' > 2 
            || (s.charAt(i) - '0' == 2 && s.charAt(i + 1) - '0' > 6))
            return false;
        return true;
    }
}
