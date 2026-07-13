// Revision
class Solution {
    public boolean canPartition(int[] nums) {
        var sum = Arrays.stream(nums).sum();
        if(sum%2!=0) return false;
        var target = sum/2;

        var dp = new boolean[nums.length+1][target+1];
        dp[0][0] = true;
        for(int i=1; i<=nums.length; i++) {
            for(int j=0; j<=target; j++) {
                var currentNo = nums[i-1];
                if(currentNo <= j) {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j - currentNo];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[nums.length][target];
    }
}
