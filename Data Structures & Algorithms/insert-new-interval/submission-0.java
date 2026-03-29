class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        var result = new ArrayList<int[]>();

        int idx=0;
        // If current interval has no overlap with new interval.
        while(idx < intervals.length && intervals[idx][1] < newInterval[0]) {
            result.add(intervals[idx]);
            idx++;              
        }

        // Here it means current interval end is greater than new interval start.
        // Another needed check is if new interal end is greater than current interval start.
        // In both these cases, intervals need to be merged.
        while(idx < intervals.length && newInterval[1] >= intervals[idx][0]) {
            var currentStart = intervals[idx][0];
            var currentEnd = intervals[idx][1];
            var newStart = newInterval[0];
            var newEnd = newInterval[1];
            // Storing temporarily in new Interval, because old interval value is obsolete now.
            newInterval[0] = Math.min(newStart, currentStart);
            newInterval[1] = Math.max(newEnd, currentEnd);
            idx++;
        }
        // THis adds the overlap interval.
        // It also takes care of the case when above conditions not met,, i.e when interval is before all intervals.
        result.add(newInterval);
        // Add remaining, non overlapping intervals after merging new intercal.
        while(idx < intervals.length) {
            result.add(intervals[idx]);
            idx++;
        }
        var resultArray = new int[result.size()][2];
        for(int i=0; i<result.size(); i++) {
            resultArray[i] = result.get(i);
        }
        return resultArray;
    }
}
