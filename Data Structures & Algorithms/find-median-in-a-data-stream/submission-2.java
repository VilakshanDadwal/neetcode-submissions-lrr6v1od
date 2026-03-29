
// Simplified solution not using explicit conditions.
class MedianFinder {

    private Queue<Integer> leftMaxHeap;
    private Queue<Integer> rightMinHeap;

    public MedianFinder() {
        leftMaxHeap = new PriorityQueue<Integer>((a,b) -> Integer.compare(b,a));
        rightMinHeap = new PriorityQueue<Integer>();
    }
    
    public void addNum(int num) {
        if(leftMaxHeap.isEmpty() || num <= leftMaxHeap.peek()) {
            // Covers 2 conditions, 
            // Condition 1 - If left heap is empty, add to left heap. This is chosen as a convention no specific reason why left is chosen.
            // Condition 2 - num <= left max value, then it should go into left.
            leftMaxHeap.add(num);
        } else {
            // num > left max, then number can be greater than right peek or between left max and right peek.
            // In both cases, its fine to add it in right peek. Coz it will be rebalanced later. 
            rightMinHeap.add(num);
        } 
        // Rebalancing heaps after adding the number.
        if(leftMaxHeap.size() - rightMinHeap.size() > 1) {
            rightMinHeap.add(leftMaxHeap.poll());
        } else if(rightMinHeap.size() - leftMaxHeap.size() > 1) {
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
