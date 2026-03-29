
// Verbose solution explaining the conditions more clearly.
class MedianFinder {

    private Queue<Integer> leftMaxHeap;
    private Queue<Integer> rightMinHeap;

    public MedianFinder() {
        leftMaxHeap = new PriorityQueue<Integer>((a,b) -> Integer.compare(b,a));
        rightMinHeap = new PriorityQueue<Integer>();
    }
    
    public void addNum(int num) {
        if(!leftMaxHeap.isEmpty() && num <= leftMaxHeap.peek()) {
            leftMaxHeap.add(num);
        } else if(!rightMinHeap.isEmpty() && num > rightMinHeap.peek()) {
            rightMinHeap.add(num);
        } else {
            // This will be executed when number is between left peek and right peek
            // It will also be executed when both left and right are empty, choosing left by default.
            leftMaxHeap.add(num);
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
