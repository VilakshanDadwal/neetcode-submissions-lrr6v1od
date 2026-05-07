class FirstUnique {

    private Queue<Integer> queue = new LinkedList<Integer>();
    private Map<Integer, Boolean> uniqueNums = new HashMap<Integer, Boolean>();

    public FirstUnique(int[] nums) {
        for(int num: nums) {
            add(num);
        }
    }
    
    public int showFirstUnique() {
        // Remove from queue the elements which might have become non-unique.
        while(!queue.isEmpty() && !uniqueNums.get(queue.peek())) 
            queue.poll();
        
        return queue.isEmpty() ? -1 : queue.peek();
    }
    
    public void add(int value) {
        if(uniqueNums.containsKey(value)) {
            uniqueNums.put(value, false);
            return;
        }
        uniqueNums.put(value, true);
        // Add unique element to queue.
        queue.add(value);
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */
