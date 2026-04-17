// Optimal using binary search
class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        var intervals = new int[startTime.length][3];
        for (int i = 0; i < startTime.length; i++) {
            intervals[i][0] = startTime[i];
            intervals[i][1] = endTime[i];
            intervals[i][2] = profit[i];
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        var dp = new int[intervals.length + 1];
        dp[intervals.length-1] = intervals[intervals.length-1][2];
        for (int i = intervals.length - 2; i >= 0; i--) {
            // Setting current job profit by default, if its not compatible with any other job.
            dp[i] = intervals[i][2];
            var nexJobIdx = findNext(intervals, i+1, intervals[i][1]);
            // Find next interval that can be considered
            if (nexJobIdx != -1) {
                // Considering both cases of skip current and find best compatible , with considering curretn
                dp[i] = Math.max(dp[i], intervals[i][2] + dp[nexJobIdx]);
            }
            // Case of not considering current job
            // Dont have to check all already calculated and just checking i+1 is enough
            // because i+1 is the max profit , considering all the jobs from i+1 till end.
            // For including current job all remaining are checked because all remaining might not be 
            // compatible with current job , so need to find maxProfit calcualted only with compatible jobs.
            dp[i] = Math.max(dp[i], dp[i+1]);
        }

        return dp[0];
    }

    private int findNext(int[][] intervals, int left , int prevTimeEnd) {
        var right = intervals.length-1;
        var nextJobIdx = -1;
        while(left <=right) {
            var mid = left+(right-left)/2;
            if(prevTimeEnd <= intervals[mid][0]) {
                nextJobIdx = mid;
                // Keep searching lesser values coz startTimes can be matching
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return nextJobIdx;
    }
}