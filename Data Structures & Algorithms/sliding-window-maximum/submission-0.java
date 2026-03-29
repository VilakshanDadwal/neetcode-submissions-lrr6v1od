class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        var resultArrLength = nums.length - k + 1;
        if(k > nums.length) resultArrLength = 1;
        var result = new int[resultArrLength];
        var maxHeap = new PriorityQueue<WindowMax>((a,b) -> Integer.compare(b.value, a.value));
        var left =0;
        
        for(int right=0; right<nums.length; right++) {
            // Always add the new element.
            maxHeap.add(new WindowMax(nums[right], right));
            // To check if the window is formed of k elements.
            if(right >= k-1) {
                // discard max if its the leftmost element
                // the new max should be within the window.
                while(!maxHeap.isEmpty() && maxHeap.peek().index <= right- k) {
                    maxHeap.poll();
                }
                // The current max in heap is the result.
                result[left] = maxHeap.peek().value;
                left++;
            }
        }
        return result;
    }
    static class WindowMax {
        int value;
        int index;
        WindowMax(int value, int index) {
            this.index = index;
            this.value = value;
        }
    }
}
