// REvision - memoization
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return ways(nums, 0, target);
    }
    private int ways(int[] nums, int i, int target) {
        if(i==nums.length && target==0)
            return 1;
        if(i==nums.length) return 0;
        return ways(nums, i+1, target-nums[i])
                + ways(nums, i+1, target+nums[i]);
    }
}
