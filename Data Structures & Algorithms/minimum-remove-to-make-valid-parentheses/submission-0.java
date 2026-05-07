
class Solution {
    public String minRemoveToMakeValid(String s) {
        var temp = new StringBuilder();
        var count =0;
        for(char c: s.toCharArray()) {
            if(c == '(') {
                // Valid open parentheses
                temp.append(c);
                count++;
            } else if(c ==')' && count > 0) {
                // Valid Close parentheses )
                temp.append(c);
                count--;
            } else if(c != ')') {
                // Its a character and not a parenthese
                temp.append(c);
            }
            // For the case of ) && count<0  , char needs to be skipped, so no code added for it.
        }

        var result = new StringBuilder();
        for(int i=temp.length()-1; i>=0; i--) {
            var c = temp.charAt(i);
            if(c=='(' && count >0) {
                count--;
            } else {
                result.append(c);
            }
        }
        return result.reverse().toString();
    }
}