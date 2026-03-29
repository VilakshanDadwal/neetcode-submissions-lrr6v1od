// Revision
class Solution {
    public int[][] merge(int[][] intervals) {
        var result = new ArrayList<int[]>();
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        result.add(intervals[0]);
        for(int i=1; i<intervals.length; i++) {
            var currentStart = intervals[i][0];
            var currentEnd = intervals[i][1];
            var prevEnd = result.get(result.size()-1)[1];
            if(prevEnd>=currentStart) {
                result.get(result.size()-1)[1] = Math.max(prevEnd, currentEnd);
            } else {
                result.add(intervals[i]);
            }
        } 
        return result.toArray(new int[result.size()][]);
    }
}
