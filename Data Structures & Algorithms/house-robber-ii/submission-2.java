class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0], nums[1]);

        var dpStart = new int[nums.length-1];
        var dpEnd = new int[nums.length];

        // Robbing starting from 1st house, excluding last.
        dpStart[0] = nums[0];
        dpStart[1] = Math.max(nums[0], nums[1]);

        for(int i=2; i<nums.length-1; i++) {
            dpStart[i] = Math.max(dpStart[i-1], nums[i] + dpStart[i-2]);
        }

        // Robbing starting from 2nd house, including last.
        dpEnd[1] = nums[1];
        dpEnd[2] = Math.max(nums[1], nums[2]);

        for(int i=3; i<nums.length; i++) {
            dpEnd[i] = Math.max(dpEnd[i-1], nums[i] + dpEnd[i-2]);
        }

        return Math.max(dpStart[dpStart.length-1], dpEnd[dpEnd.length-1]);
    }
}