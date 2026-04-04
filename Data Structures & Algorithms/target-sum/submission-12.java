// Bottom Up - Pick Notpick solution
// We try out all numbers.
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        var allNumSum = 0;
        for(int num: nums) allNumSum += num;
        if (Math.abs(target) > allNumSum) return 0;
        var dp = new int[nums.length+1][2*allNumSum + 1];
        // By choosing no number 1 way to create target of 0.
        // 0 target corresponds to allNumSum index.
        dp[0][allNumSum] = 1;

        for(int i=1; i<=nums.length; i++) {
            var currentNum = nums[i-1];
            for(int j=0; j<=2*allNumSum; j++) {
                // Chose +num , check if current target - currentNum valid 
                // use it if exists in previous row
                if(j-currentNum >= 0) {
                    dp[i][j] = dp[i-1][j-currentNum];
                } 
                // Chose -num , check if current target + currentNum valid
                // use it if exists in previous row
                if(j+currentNum <= 2*allNumSum) {
                    dp[i][j] += dp[i-1][j+currentNum];
                }
            }
        }
        return dp[nums.length][target+allNumSum];
    }
}
