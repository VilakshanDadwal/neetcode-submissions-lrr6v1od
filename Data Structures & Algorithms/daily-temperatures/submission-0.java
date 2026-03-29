class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        var stack = new Stack<Integer>();
        var result = new int[temperatures.length];
        for(int i=0; i < temperatures.length; i++) {
            while(!stack.isEmpty() 
                && temperatures[i] > temperatures[stack.peek()]) {
                    result[stack.peek()] = i-stack.peek();
                    stack.pop();
            }
            stack.push(i);
        }
        // For temperatures, for which no greater temperature found on right
        // result arary will have 0 beause of default value of 0 in array.
        return result;
    }
}
