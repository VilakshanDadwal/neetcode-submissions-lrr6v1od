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

            // If a task has not been picked.
            if(!maxHeap.isEmpty()) {
                int remainingFreq = maxHeap.poll()-1;
                if(remainingFreq > 0) {
                    int nexExecutableAt = currentTime + n;
                    waitingTasks.add(new int[]{remainingFreq, nexExecutableAt});
                }
            }

            if(!waitingTasks.isEmpty() && waitingTasks.peek()[1] == currentTime) {
                maxHeap.add(waitingTasks.poll()[0]);
            }
        }
        return currentTime;

    }
}
