// Optimal Solution
class Solution {
    public String minRemoveToMakeValid(String s) {
        var temp = new StringBuilder(s);
        var stack = new Stack<Integer>();
        // Update invalid ) parenthese with #
        for(int i=0; i<temp.length(); i++) {
            var c = temp.charAt(i);
            if(c == '(') {
                // Valid open parentheses
                stack.push(i);
            } else if(c ==')') {
               if(!stack.isEmpty()) {
                stack.pop();
               } else {
                temp.setCharAt(i, '#');
               }
            } 
        }
        // Replace invalid open parentheses with #
        while(!stack.isEmpty()) 
            temp.setCharAt(stack.pop(), '#');

        var result = new StringBuilder();
        for(int i=0; i<temp.length(); i++) {
            if(temp.charAt(i) != '#')
                result.append(temp.charAt(i));
        }
        return result.toString();
    }
}