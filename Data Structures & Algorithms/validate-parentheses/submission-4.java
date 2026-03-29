class Solution {
    public boolean isValid(String s) {
        var map = new HashMap<Character, Character>();
        map.put('}','{');
        map.put(')','(');
        map.put(']','[');
        var stack = new Stack();

        for(int i=0; i<s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                // checking stack isEmpty to check for scenario liek - ']' (where starting with open bracket)
                if(stack.isEmpty() || map.get(s.charAt(i)) != stack.pop()) {
                    return false;
                } 
            } else {
                stack.push(s.charAt(i));
            }
           
        }
        return stack.isEmpty();
    }
}
