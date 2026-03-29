class MedianFinder {

    private Queue<Integer> leftMaxHeap;
    private Queue<Integer> rightMinHeap;

    public MedianFinder() {
        leftMaxHeap = new PriorityQueue<Integer>((a,b) -> Integer.compare(b,a));
        rightMinHeap = new PriorityQueue<Integer>();
    }
    
    public void addNum(int num) {
        // To start with have to add in some heap so adding in smaller number heap i.e leftHeap.
        leftMaxHeap.add(num);
        // Need to move the node from left to right in two conditions.
        // Condition 1 - If size of the left heap is greater than right by more than 1, rebalance.
        // Condition 2 - If size of the two heaps is same, but after adding the numbers the left root > right root.
        // This can happen, if the number should have been added in right but has been added in left.
        // Need to rebalance in this case as well. 
        if(leftMaxHeap.size() - rightMinHeap.size() > 1
            || (!rightMinHeap.isEmpty() && leftMaxHeap.peek() > rightMinHeap.peek())) {
            rightMinHeap.add(leftMaxHeap.poll()); 
        } 

        // This is needed becasue for condition 2, it could be that size of left heap becomes 2 lesser than right.
        // Assume left was size 1 , right was size 2. new num added to left becomes size 2. Now Condition 2 satisfies
        // left is moved to right, left becomes size 1, right becomes size 3. Needs rebalance. This block does that rebalance.
        if(rightMinHeap.size() - leftMaxHeap.size() > 1) {
            leftMaxHeap.add(rightMinHeap.poll());
        }
    }
    
    public double findMedian() {
        if(leftMaxHeap.size() < rightMinHeap.size()) {
            return (double) rightMinHeap.peek();
        } else if (leftMaxHeap.size() > rightMinHeap.size()){
            return (double) leftMaxHeap.peek();
        } else {
            return (double)(leftMaxHeap.peek() + rightMinHeap.peek())/2;
        }
    }
}
