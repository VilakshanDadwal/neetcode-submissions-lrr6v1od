class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if(sum%2 !=0) return false;

        Boolean[][] cache = new Boolean[nums.length][sum/2+1];
        return backtrack(nums, 0, sum/2, cache);
    }

    boolean backtrack(int[] nums, int idx, int target, Boolean[][] cache) {
        if(target ==0) return true;
        if(target<0) return false;

        if(cache[idx][target] != null) return cache[idx][target];
        
        for(int i=idx+1; i<nums.length; i++) {
            if(backtrack(nums, i, target-nums[i], cache))
                return true;
        }
        cache[idx][target] = false;
        return false;
    }
}
