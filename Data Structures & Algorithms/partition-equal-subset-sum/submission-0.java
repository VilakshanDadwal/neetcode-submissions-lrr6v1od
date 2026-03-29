class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if(sum%2 !=0) return false;

        return backtrack(nums, 0, sum/2);
    }

    boolean backtrack(int[] nums, int idx, int target) {
        if(target ==0) return true;
        if(target<0) return false;

        for(int i=idx+1; i<nums.length; i++) {
            if(backtrack(nums, i, target-nums[i]))
                return true;
        }
        return false;
    }
}
