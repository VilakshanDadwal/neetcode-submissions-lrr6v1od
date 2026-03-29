class Solution {
    private Queue<Integer> maxHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());
    public int lastStoneWeight(int[] stones) {
        for(int stone: stones) {
            maxHeap.add(stone);
        }

        while(maxHeap.size() >1) {
            int largest = maxHeap.poll();
            int secondLargest = maxHeap.poll();
            int diff = largest - secondLargest;

            if(diff>0) {
               maxHeap.add(diff);
            }
        }
        return maxHeap.size() > 0 ? maxHeap.peek():0;
    }
}
