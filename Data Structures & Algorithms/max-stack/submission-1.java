// Revision
class MaxStack {
    private Stack<Item> stack;
    private Queue<Item> maxHeap;
    private Set<Integer> staleIds;
    int count;

    public MaxStack() {
        stack = new Stack<Item>();
        maxHeap = new PriorityQueue<Item>((a,b) -> a.value == b.value 
                                                ? Integer.compare(b.id, a.id)
                                                : Integer.compare(b.value, a.value));
        staleIds = new HashSet<Integer>();
        count = 0;
    }
    
    public void push(int x) {
        stack.push(new Item(count, x));
        maxHeap.add(new Item(count, x));
        count++;
    }
    
    public int pop() {
        while(staleIds.contains(stack.peek().id)) 
            stack.pop();
        var item = stack.pop();
        staleIds.add(item.id);
        return item.value;
    }
    
    public int top() {
        while(staleIds.contains(stack.peek().id)) 
            stack.pop();
        return stack.peek().value;
    }
    
    public int peekMax() {
        while(staleIds.contains(maxHeap.peek().id))
            maxHeap.poll();
            
        return maxHeap.peek().value;
    }
    
    public int popMax() {
        while(staleIds.contains(maxHeap.peek().id))
            maxHeap.poll();
        var item = maxHeap.poll();
        staleIds.add(item.id);
        return item.value;
    }

    private class Item {
        int id;
        int value;
        Item(int id, int value) {
            this.id = id;
            this.value = value;
        }
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
