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
            for (int j = i + 1; j < intervals.length; j++) {
                if (intervals[i][1] <= intervals[j][0]) {
                    // Case of considering the current job
                    dp[i] = Math.max(dp[i], intervals[i][2] + dp[j]);
                }
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
}