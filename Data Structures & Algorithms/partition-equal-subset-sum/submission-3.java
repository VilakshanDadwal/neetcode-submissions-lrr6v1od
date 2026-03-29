// Revision - Space Optimized 2 array
class Solution {
    public boolean canPartition(int[] nums) {
        int total = Arrays.stream(nums).sum();
        if(total%2!=0) return false;
        int target = total/2;

        var current = new boolean[target+1];
        var prev = new boolean[target+1];
        prev[0] = true;
        // No need to consider the case of picking no element when using only one array.
        // Thus i<nums.length
        for(int i=0; i<nums.length; i++) {
            for (int j=1; j<=target; j++) {
                if(nums[i] <=j) {
                    current[j] = prev[j] || prev[j-nums[i]];
                } else {
                    current[j] = prev[j];
                }
            }
            var temp = prev;
            prev = current; 
            current = temp;
        }
        return prev[target];
    }
}