class Solution {
    public int findKthLargest(int[] nums, int k) {
        var minHeap = new PriorityQueue<Integer>();
        for(int num : nums) {
            minHeap.add(num);
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
}
