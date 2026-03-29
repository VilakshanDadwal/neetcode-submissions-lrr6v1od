// Bottom Up solution in the way subset 
//sum equal to target question would be written. 
// It goes through all targets and tries to find number of ways for it.
// Instead only using previous row value and filling +num and -num of previous row available sums.
class Solution {
    
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;

        int total = 0;
        for (int x : nums) total += x;

        if (Math.abs(target) > total) return 0;

        int offset = total;
        int width = 2 * total + 1;

        int[][] dp = new int[n + 1][width];

        // Base case , not picking any number, Sum =0. Represented by offset column.
        dp[0][offset] = 1;  

        for (int i = 1; i <= n; i++) {
            int num = nums[i - 1];
            for (int j = 0; j < width; j++) {
                int ways = 0;
                // Case 1: Chosing +num number, and checking ways (j-num) sum can be made using previous numbers. 
                if (j - num >= 0) {
                    ways += dp[i - 1][j - num];
                }
                // Case 2: Chosing -num and checking ways j+num can be made using previous numbers. 
                if (j + num < width) {
                    ways += dp[i - 1][j + num];
                }

                dp[i][j] = ways;
            }
        }

        return dp[n][offset + target];
    }
}
