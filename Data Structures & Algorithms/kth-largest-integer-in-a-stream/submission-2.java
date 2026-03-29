
// Different approach. Checking peek value and maintaining minHeap of size k.
// In this approach not exceeding k elements. Comparing peek value and incoming value.
class KthLargest {
    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>();
        for(int num : nums) {
            add(num);
        }
    }
    
    public int add(int val) {
        if(minHeap.size()<k) {
            minHeap.add(val);
        } else if(val > minHeap.peek()) {
            // Change heap only if val can be greater than smallest number of heap.
            // Because if it is lesser than smallest value of peek, it can never be kth largest.
            minHeap.poll();
            minHeap.add(val);
        }
        return minHeap.peek();
    }
}
