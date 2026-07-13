class Solution {
    public int findKthLargest(int[] nums, int k) {
        var minHeap = new PriorityQueue<Integer>();
        for(int num: nums) {
            if(minHeap.size()<k) {
                minHeap.add(num);
            } else if(minHeap.size()==k && minHeap.peek() < num) {
                minHeap.poll();
                minHeap.add(num);
            }  
        }
        return minHeap.peek();
    }
}
