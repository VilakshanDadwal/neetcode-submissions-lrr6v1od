class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] cache = new int[nums.length];
        Arrays.fill(cache, -1);
        int maxLIS = 1;
        for(int i=0; i<nums.length; i++) {
            maxLIS = Math.max(maxLIS, helper(i, nums, cache));
        }
        return maxLIS;
    }

    int helper(int idx, int[] nums, int[] cache) {
        if(cache[idx] !=-1) return cache[idx];
        if(idx == nums.length) return 0;

        int lis = 1;
        for(int i=idx+1; i<nums.length; i++) {
            if(nums[i] > nums[idx]) {
                lis = Math.max(lis, 1+helper(i, nums, cache));
            }
        }
        cache[idx] = lis;
        return lis;
    }
}
