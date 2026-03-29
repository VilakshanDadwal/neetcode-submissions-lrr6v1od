class MaxStack {

    private Stack<int[]> stack;
    private Queue<int[]> maxHeap;
    private Set<Integer> removed;
    private int idx;

    public MaxStack() {
        stack = new Stack<>();
        removed = new HashSet<>();
        // If two values are same, keep the one added later at the top.
        maxHeap = new PriorityQueue<int[]>((a,b) -> b[0] - a[0] == 0
                                                ? b[1] - a[1]
                                                : b[0] - a[0]);    
    }
    
    public void push(int x) {
        stack.push(new int[]{x, idx});
        maxHeap.add(new int[]{x, idx});
        idx++;
    }
    
    public int pop() {
        // if the current number at top is marked for removal , remove it.
        // This would happen if popMax was called.
        while(removed.contains(stack.peek()[1])) 
            stack.pop();
        var top = stack.pop();
        removed.add(top[1]);
        return top[0];
    }
    
    public int top() {
        // if the current number at top is marked for removal, remove it.
        while(removed.contains(stack.peek()[1])) 
            stack.pop();
        return stack.peek()[0];
    }
    
    public int peekMax() {
        // if the current number at top is marked for removal, remove it.
        while(removed.contains(maxHeap.peek()[1])) 
            maxHeap.poll();
        return maxHeap.peek()[0];
    }
    
    public int popMax() {
         // if the current number at top is marked for removal , remove it.
        // This would happen if pop was called 
        while(removed.contains(maxHeap.peek()[1])) 
            maxHeap.poll();
        var top = maxHeap.poll();
        removed.add(top[1]);
        return top[0];
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */
