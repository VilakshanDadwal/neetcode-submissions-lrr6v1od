// 2 stack optimal.
class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }
    
    public void push(int val) {
        stack.push(val);
        // Add to minStack only when minValue changes.
        if(minStack.isEmpty() || val <= minStack.peek())
            minStack.push(val);
    }
    
    public void pop() {
        if(stack.isEmpty()) return;
        int poppedNumber = stack.pop();
        // Need to pop from minStack only if top value in main stack is the minValue
        if(minStack.peek() == poppedNumber) {
            minStack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
