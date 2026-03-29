class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        
        // Create query Copy for original order
        var queriesCopy = createQueryCopy(queries);

        Arrays.sort(queries);
        var resultMap = new HashMap<Integer, Integer>();
    
        // Heap element would be intervalSize and endTime of interval.
        var minHeap = new PriorityQueue<IntervalInfo>(
            Comparator.comparingInt(intervalInfo -> intervalInfo.size));
        int intervalIdx=0;
        for(int query: queries) {
            // Add valid intervals to the minHeap for this query.
            while(intervalIdx < intervals.length && intervals[intervalIdx][0] <= query) {
                var left = intervals[intervalIdx][0];
                var right = intervals[intervalIdx][1];
                var size = right - left + 1;
                minHeap.add(new IntervalInfo(size, right));
                intervalIdx++;
            }

            // Populate map with the query and the smallest interval size as value.
            while(!minHeap.isEmpty() && query > minHeap.peek().endTime)
                minHeap.poll();
            resultMap.put(query, minHeap.isEmpty() ? -1 : minHeap.peek().size);
        }

        // Create final result array using map.
        var result = new int[queriesCopy.length];
        for(int i=0; i<queriesCopy.length; i++) {
            result[i] = resultMap.get(queriesCopy[i]);
        }
        return result;
    }

    private int[] createQueryCopy(int[] queries){
        var queriesCopy = new int[queries.length];
        for(int i=0; i< queries.length; i++) {
            queriesCopy[i] = queries[i];
        }
        return queriesCopy;
    }

    static class IntervalInfo {
        int size;
        int endTime;
        IntervalInfo(int size, int endTime) {
            this.size = size;
            this.endTime = endTime;
        }
    }
}
