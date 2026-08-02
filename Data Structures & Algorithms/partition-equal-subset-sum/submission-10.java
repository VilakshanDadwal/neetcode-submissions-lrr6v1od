// Approach like target sum , where based on prev row state, current row two states are created.
class Solution {
    public boolean canPartition(int[] nums) {
         var sum = Arrays.stream(nums).sum();
        if(sum%2!=0) return false;
        var target = sum/2;
        // Standard positive-only Subset Sum using PUSH logic in 2D
        boolean[][] dp = new boolean[nums.length + 1][target + 1];
        dp[0][0] = true;

        for (int i = 1; i <= nums.length; i++) {
            int txn = nums[i - 1];

            for (int s = 0; s <= target; s++) {
                // PUSH OPTIMIZATION: Only act on reachable states
                if (dp[i - 1][s]) {
                    // 1. Exclude: push forward
                    dp[i][s] = true;

                    // 2. Include: push forward (with bounds check)
                    if (s + txn <= target) {
                        dp[i][s + txn] = true;
                    }
                }
            }
        }
        return dp[nums.length][target];
    }
}
