// Revision
class Solution {
    public int[] dailyTemperatures(int[] temps) {
        var stack = new Stack<Integer>();
        var result = new int[temps.length];
        stack.push(temps.length-1);
        result[temps.length-1] = 0;
        for(int i = temps.length-2 ; i>=0; i--) {
            var current = temps[i];
            while(!stack.isEmpty() && current >= temps[stack.peek()])
                stack.pop();
            if(stack.isEmpty()) {
                result[i] = 0;
            } else {
                result[i] = stack.peek() - i;
            }
            stack.push(i);
        }
        return result;
    }
}
    
