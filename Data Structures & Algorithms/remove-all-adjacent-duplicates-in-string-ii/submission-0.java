class Solution {
    public String removeDuplicates(String s, int k) {
        var stack = new Stack<int[]>();
        for(int i=0; i<s.length(); i++) {
            if(!stack.isEmpty() && s.charAt(i) == stack.peek()[0]) {
                var current = stack.peek();
                current[1] = ++current[1];
                if(current[1] == k) stack.pop();
            } else {
                stack.push(new int[]{s.charAt(i), 1});
            }
        }

        var result = new StringBuilder();
        while(!stack.isEmpty()) {
            var top = stack.pop();
            result.append(Character.toString(top[0]).repeat(top[1]));
        }

        return result.reverse().toString();
    }
}