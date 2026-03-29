class KthLargest {

    private Queue<Integer> minHeap;
    private int kthLargest;
    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<Integer>();
        kthLargest = k;
        for(int i=0; i<nums.length; i++) {
            minHeap.add(nums[i]);
            // This is to keep size of minHeap to size k.
            if(minHeap.size() > kthLargest)
                minHeap.poll();
        }
    }
    
    public int add(int val) {
        minHeap.add(val);
        // No while loop needed becasue the size of minHeap is k. 
        // So when new val is added, it becomes k+1 and one element is removed.
        if(minHeap.size()> kthLargest)
            minHeap.poll();
        return minHeap.peek();
    }
}
