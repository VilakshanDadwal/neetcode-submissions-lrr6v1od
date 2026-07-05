class Solution {

    public boolean isValid(String s) {
        var map = new HashMap<Character, Character>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        var stack = new Stack<Character>();

        for(char c : s.toCharArray()) {
            if(map.containsKey(c)) {
                stack.push(map.get(c));
                continue;
            }
            if(stack.isEmpty() || stack.peek() != c)
                return false;
            stack.pop();
        }
        return stack.isEmpty();
    }
}
