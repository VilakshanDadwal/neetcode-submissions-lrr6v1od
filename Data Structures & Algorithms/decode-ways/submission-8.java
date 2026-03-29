// Revision- bottom up.
class Solution {
    public int numDecodings(String s) {
        // Taking length() + 1 to take care of base case, having found a way.
        var currentWays = 0;
        // Initialising base case to 1
        var oneDigitWays = 1;
        var twoDigitWays = 0;
        for(int i=s.length()-1; i>=0;i--) {
            if(s.charAt(i) == '0') {
                currentWays = 0;
            } else {
                // If char is not 0, single char check is valid.
                currentWays = oneDigitWays;
                // For the last char, no need to check for 2 digits, becasue there will be only 1 digit.
                // thats why i < s.length()-1 check.
                if(i<s.length()-1 && validTwoDigit(s, i)) {
                 currentWays = currentWays + twoDigitWays;
                 }
            }
            twoDigitWays = oneDigitWays;
            oneDigitWays = currentWays;
            currentWays =0;
        }
        return oneDigitWays;
    }

    boolean validTwoDigit(String s, int i) {
        // ASCII value subtraction gives the number , because ASCII values of 0-9 are in order.
        int currentNum = s.charAt(i) - '0';
        int nextNum = s.charAt(i+1) - '0';
        if(currentNum ==1 || (currentNum==2 && nextNum<=6)) {
            return true;
        }
        return false;
    }
}