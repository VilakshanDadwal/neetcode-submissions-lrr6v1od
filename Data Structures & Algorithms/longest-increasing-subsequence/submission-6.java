// Memoization - Storing LIST starting at an index
class Solution {
    public int lengthOfLIS(int[] nums) {
        var longest = Integer.MIN_VALUE;
        var cache = new int[nums.length];
        Arrays.fill(cache, -1);
        for(int i=0; i<nums.length; i++) {
            longest = Math.max(longest, lis(i, nums, cache) );
        }
        return longest;
    }
    private int lis(int idx, int[] nums, int[] cache) {
        if(cache[idx]!=-1) return cache[idx];
        cache[idx] = 1;
        for(int i=idx+1; i<nums.length; i++) {
            if(nums[i] > nums[idx]) {
                cache[idx] = Math.max(cache[idx], 1 + lis(i, nums, cache));
            }
        }
        return cache[idx];
    }
}
