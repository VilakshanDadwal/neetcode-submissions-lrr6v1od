// Recursive
class Solution {
    public String decodeString(String s) {
        var stack = new Stack<String>();
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) != ']') {
                stack.push(String.valueOf(s.charAt(i)));
            } else {
                var subString = new StringBuilder();
                // Add subString Until open bracket encountered
                while(!stack.peek().equals("[")) {
                    subString.insert(0, stack.pop());
                }
                // Pop open bracket [
                stack.pop();
                 // Find number of times to repeat the substring found above
                 // This is becasue after open bracked a number is guaranteed.
                var noOfTimesToRepeat = new StringBuilder();
                while(!stack.isEmpty()) {
                    var singleDigit = stack.peek().charAt(0);
                    if(!Character.isDigit(singleDigit)) 
                        break;
                    noOfTimesToRepeat.insert(0, stack.pop());
                }
                var repeatCount = Integer.parseInt(noOfTimesToRepeat.toString());
                var repeatedString = subString.toString().repeat(repeatCount);
                stack.push(repeatedString);
            }   
        }
        var result = new StringBuilder();
        while(!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }
        return result.toString();
    }
}