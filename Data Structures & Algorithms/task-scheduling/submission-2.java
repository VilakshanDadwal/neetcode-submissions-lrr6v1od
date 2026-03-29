class Solution {
    public int leastInterval(char[] tasks, int n) {
        var cpuCycles = 0;
        var frequency = buildFrequencyMap(tasks);
        var maxHeap = buildHeap(frequency);
        
        // Create a queue to track tasks in cooldown.
        // Need to store the frequencyCount and the next cycle when task becomes available.
        var queue = new LinkedList<CoolDownInfo>();

        // While there are tasks left in heap or queue
        // Using tasks and adding to queue for cooldown.
        while(!maxHeap.isEmpty() || !queue.isEmpty()) {
            // Incrementing cpu cycle
            cpuCycles++;

            if(!maxHeap.isEmpty()) {
                var currentTaskCount = maxHeap.poll();
                currentTaskCount--;
                if(currentTaskCount > 0) {
                    // The availableAt Time is one less than when it will actually be vailable.
                    // This is because the task needs to be added to heap, just before the cpu cycle when it will be available.
                    // task will be available at cpuCycles+n+1, so it needs to be added to maxHeap at cpyCycle = cpuCycles+n
                    queue.add(new CoolDownInfo(currentTaskCount, cpuCycles + n));
                }
            }

            if(!queue.isEmpty() && queue.peek().availableAt == cpuCycles) {
                // If the task in cooldown can be used in the next cycle, add it to heap.
                maxHeap.add(queue.poll().count);
            }
        }
        return cpuCycles;
    }

    private Map<Character, Integer> buildFrequencyMap(char[] tasks) {
        // Create occurrence count map
        var frequency = new HashMap<Character, Integer>();
        for(char task : tasks) {
            frequency.put(task, frequency.getOrDefault(task, 0) + 1);
        }
        return frequency;
    }

    private Queue<Integer> buildHeap(Map<Character, Integer> frequency) {
        // Create Heap from occurrence count map.
        // Saving only count values in heap, because aim is to find noCPUCycles used
        // Its not important to know which task was used.
        var maxHeap = new PriorityQueue<Integer>((a,b) -> Integer.compare(b, a));
        for(Map.Entry<Character, Integer> entry: frequency.entrySet()) {
            maxHeap.add(entry.getValue());
        }
        return maxHeap;
    }

    static class CoolDownInfo {
        private int count;
        private int availableAt;

        CoolDownInfo(int count, int availableAt) {
            this.count = count;
            this.availableAt = availableAt;
        }
    }
}
