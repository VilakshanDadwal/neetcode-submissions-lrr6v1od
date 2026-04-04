// Revision - memoization
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        var allNumSum = 0;
        for(int num: nums) allNumSum += num;

        var cache = new int[nums.length][2*allNumSum + 1];
        for(int i=0; i<nums.length; i++) {
            for(int j=0; j<2*allNumSum +1; j++) {
                cache[i][j] = Integer.MIN_VALUE;
            }
        }
        return ways(nums, 0, target, cache, allNumSum);
    }

    private int ways(int[] nums, int i, int target, int[][] cache, int allNumSum) {
        if(i==nums.length && target==0)
            return 1;
        if(i==nums.length) return 0;

        var col = target + allNumSum;
        if(col < 0 || col > 2*allNumSum) return 0;

        if(cache[i][col] != Integer.MIN_VALUE) return cache[i][col];

        cache[i][col] = ways(nums, i+1, target-nums[i], cache, allNumSum)
                + ways(nums, i+1, target+nums[i], cache, allNumSum);
                
        return cache[i][col];
    }
}
