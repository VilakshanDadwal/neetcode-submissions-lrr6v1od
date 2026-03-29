class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0],b[0]));
        var previousEnd = intervals[0][1];
        int count =0;
        for(int i=1; i < intervals.length; i++) {
            if(previousEnd > intervals[i][0]) {
                count++;
                previousEnd = Math.min(previousEnd, intervals[i][1]);
            } else {
                previousEnd = intervals[i][1];
            }
        }
        return count;
    }
}
