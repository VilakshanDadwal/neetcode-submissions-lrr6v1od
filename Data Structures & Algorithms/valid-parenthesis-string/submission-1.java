class Solution {
    public boolean checkValidString(String s) {
        var left = new Stack<Integer>();
        var star = new Stack<Integer>();

        for(int i=0; i<s.length(); i++) {
            var c = s.charAt(i);
            if(c =='(') {
                left.push(i);
            } else if(c == '*') {
                star.push(i);
            } else { // Closing parentheses
                // No left or star present to match with closed parentheses 
                // Example ()) or (*)))
                if(left.isEmpty() && star.isEmpty()) return false;
                if(!left.isEmpty()) {
                    left.pop();
                } else if(!star.isEmpty()) {
                    star.pop();
                }
            }
        }
        // If left parentheses are left, * can be used as a closing parentheses
        // example (()*. This is valid if left parenthes occurs before star.
        // Extra star left in the stack can be treated as empty string and thus ignored.
        while(!left.isEmpty() && !star.isEmpty()) {
            if(left.pop() > star.pop()) return false;
        }
        return left.isEmpty();
    }
}
