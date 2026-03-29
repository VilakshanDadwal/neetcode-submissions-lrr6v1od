
// Added more comments
class Solution {
    public int leastInterval(char[] tasks, int n) {
        // Create task Frequency
        var taskFreq = new int[26];
        for(char task : tasks) 
            taskFreq[task - 'A']++;

        // Create Max Heap
        var maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int freq: taskFreq) {
            if(freq>0) maxHeap.add(freq);
        }

        var waitingTasks = new LinkedList<int[]>();
        int currentTime=0;

        while(!maxHeap.isEmpty() || !waitingTasks.isEmpty()) {
            currentTime++;

            // If still tasks to be done are present.
            if(!maxHeap.isEmpty()) {
                int remainingFreq = maxHeap.poll()-1;
                // Add to waiting only if there is a task of this type left.
                if(remainingFreq > 0) {
                    int nexExecutableAt = currentTime + n;
                    waitingTasks.add(new int[]{remainingFreq, nexExecutableAt});
                }
            }

            // If the waiting task can be used again, add it to heap.
            if(!waitingTasks.isEmpty() && waitingTasks.peek()[1] == currentTime) {
                maxHeap.add(waitingTasks.poll()[0]);
            }
            // If maxHeap is empty but there are waiting tasks present but they are not ready to be executed.
            // Time is incremented to simulate the ideal time slot. 
        }
        return currentTime;

    }
}
