class Solution {
    public boolean isValid(String s) {
        var map = new HashMap<Character, Character>();
        map.put('{','}');
        map.put('(',')');
        map.put('[',']');
        var stack = new Stack<Character>();
        for(char c: s.toCharArray()) {
            // Open bracket
            if(map.containsKey(c)) {
                stack.push(map.get(c));
            } else if(!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();  
    }
}
