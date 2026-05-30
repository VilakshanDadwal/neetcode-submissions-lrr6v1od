class Solution {
    public String decodeString(String s) {
        var stack = new Stack<String>();
        for(int i =0; i<s.length(); i++) {
            if(s.charAt(i) != ']') {
                stack.push(String.valueOf(s.charAt(i)));
            } else {
                var currentString = new StringBuilder();
                while(!stack.peek().equals("[")) {
                    currentString.insert(0, stack.pop());
                }
                stack.pop();

                var timesToRepeatString = new StringBuilder();
                while(!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))) {
                    timesToRepeatString.insert(0, stack.pop());
                }
                var timesToRepeat = Integer.parseInt(timesToRepeatString.toString());
                var expandedString = currentString.toString().repeat(timesToRepeat);
                stack.push(expandedString);
            }
        }

        var result = new StringBuilder();
        while(!stack.isEmpty()) {
            result.insert(0,stack.pop());
        }
        return result.toString(); 
    }
}