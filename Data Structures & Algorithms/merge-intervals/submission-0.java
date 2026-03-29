class Solution {
    public int[][] merge(int[][] intervals) {
        var result = new ArrayList<int[]>();
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        result.add(intervals[0]);
        for(int[] interval : intervals) {
            var previous = result.get(result.size()-1);
            var currentStart = interval[0];
            if(previous[1] >= currentStart) {
                previous[1] = Math.max(interval[1], previous[1]);
            } else {
                result.add(interval);
            }
        }
        var resultArray = new int[result.size()][2];
        for(int i=0; i<result.size(); i++) {
            resultArray[i] = result.get(i);
        }
        return resultArray;
    }
}
