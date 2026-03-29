// Revision
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        var result = new ArrayList<int[]>();
        var newStart = newInterval[0];
        var newEnd = newInterval[1];
        var idx=0;
        // If current interval ends before new interval starts.
        // This means the current interval can be safely added to result. 
        while(idx<intervals.length && intervals[idx][1] < newStart) {
            result.add(intervals[idx]);
            idx++;
        }
        // When above loop is done , this means, the new interval starts before current interval ends.
        // Now there can be many possibilities. The possibillities are best visualised on paper using dashes for intervals.
        // There will be an overlap if current interval starts before new interval ends. 
        while(idx < intervals.length && newEnd >= intervals[idx][0]) {
            newStart = Math.min(newStart, intervals[idx][0]);
            newEnd = Math.max(newEnd, intervals[idx][1]);
            idx++;
        }
        result.add(new int[]{newStart, newEnd});
        // Now, only non overlapping intervals remain, add them
        // This is so because after merging all possible intervals above 
        // Only condition left is new interval ends before current interval.
        while(idx<intervals.length && newEnd < intervals[idx][0]) {
            result.add(intervals[idx]);
            idx++;
        }

        return result.toArray(new int[result.size()][]);
    }
}
