class Solution {
    private int currentIndex = 0;
    // We are passing a bracket level recursively and returning the resilved decoded string within a bracket level. 
    public String decodeString(String s) {
        var decodedString = new StringBuilder();
        var repeatCount = 0;
        while(currentIndex < s.length()) {
            var currentChar = s.charAt(currentIndex);
            if(Character.isDigit(currentChar)) {
                repeatCount = repeatCount*10 + (currentChar - '0');
            } else if(currentChar == '[') {
                // resolve the string inside this bracket level
                currentIndex++;
                var innerString = decodeString(s);
                // Append inner string repeatCount times
                for(int i=0; i<repeatCount; i++) {
                    decodedString.append(innerString);
                }
                repeatCount =0;
            } else if(currentChar == ']') {
                // Current bracked level is done, return the decoded string.
                return decodedString.toString();
            } else {
                decodedString.append(currentChar);
            }
            currentIndex++;
        }
        return decodedString.toString();
    }
}