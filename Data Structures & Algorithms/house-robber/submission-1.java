// Alternate Solution - Interesting to understand this.
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        var dp = new int[n];
        Arrays.fill(dp, -1);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, robFrom(i, nums, dp));
        }
        return ans;
    }

    private int robFrom(int i, int[] nums, int[] dp) {
        if (dp[i] != -1) return dp[i];

        int best = nums[i];

        for (int j = i + 2; j < nums.length; j++) {
            best = Math.max(best, nums[i] + robFrom(j, nums, dp));
        }

        dp[i] = best;
        return best;
    }
}