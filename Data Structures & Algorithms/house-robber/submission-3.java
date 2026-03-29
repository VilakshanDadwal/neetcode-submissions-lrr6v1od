// Revision - Space optimized
class Solution {
    public int rob(int[] nums) {
        if (nums.length==1) return nums[0];
        var nonAdjacentMax = nums[0];
        var adjacentMax = Math.max(nums[0], nums[1]);

        for(int i=2; i<nums.length; i++) {
            var currentMax = Math.max(adjacentMax, nums[i] + nonAdjacentMax);
            nonAdjacentMax = adjacentMax;
            adjacentMax = currentMax;
        }
        return adjacentMax;
    }
}
