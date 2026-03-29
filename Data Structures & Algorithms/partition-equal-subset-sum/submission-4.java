// Revision - Space Optimized 1 array
class Solution {
    public boolean canPartition(int[] nums) {
        int total = Arrays.stream(nums).sum();
        if(total%2!=0) return false;
        int target = total/2;

        var current = new boolean[target+1];
        current[0] = true;
        for(int i=0; i<nums.length; i++) {
            for (int j=target; j>=0; j--) {
                if(nums[i] <=j) {
                    current[j] = current[j] || current[j-nums[i]];
                }
                // No need of else block because current[j]= prev[j] is represented by current[j]
            }
        }
        return current[target];
    }
}