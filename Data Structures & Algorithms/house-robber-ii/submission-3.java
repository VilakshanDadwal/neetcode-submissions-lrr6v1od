class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0], nums[1]);

        // Robbing starting from 1st house, excluding last.
        var nonAdjacentMax = nums[0];
        var adjacentMax = Math.max(nums[0], nums[1]);

        for(int i=2; i<nums.length-1; i++) {
            var currentMax = Math.max(adjacentMax, nums[i] + nonAdjacentMax);
            nonAdjacentMax = adjacentMax;
            adjacentMax = currentMax;
        }

        // Robbing starting from 2nd house, including last.
        var nonAdjacentMaxWithEnd = nums[1];
        var adjacentMaxWithEnd = Math.max(nums[1], nums[2]);

        for(int i=3; i<nums.length; i++) {
            var currentMax = Math.max(adjacentMaxWithEnd, nums[i] + nonAdjacentMaxWithEnd);
            nonAdjacentMaxWithEnd = adjacentMaxWithEnd;
            adjacentMaxWithEnd = currentMax;
        }

        return Math.max(adjacentMax, adjacentMaxWithEnd);
    }
}