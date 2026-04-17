class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        var intervals = new int[startTime.length][3];
        for(int i=0; i<startTime.length; i++) {
            intervals[i][0] = startTime[i];
            intervals[i][1] = endTime[i];
            intervals[i][2] = profit[i];
        }

        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

        return maxProfit(intervals, 0, Integer.MIN_VALUE);
    }
    private int maxProfit(int[][] intervals, int idx, int prevEndTime) {
        if(idx == intervals.length) return 0;
        var maxProfit = 0;
        for(int i=idx; i<intervals.length; i++) {
            if(prevEndTime <= intervals[i][0]) {
                maxProfit = Math.max(maxProfit, intervals[i][2] + maxProfit(intervals, i+1, intervals[i][1]));
            }
        }
        return maxProfit;
    }
}