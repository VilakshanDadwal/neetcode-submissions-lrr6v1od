class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);

        int[] includeFirst = new int[nums.length];
        int[] includeLast = new int[nums.length];
        includeFirst[0]= nums[0];
        includeFirst[1]=Math.max(nums[0], nums[1]);
        includeLast[0] = 0;
        includeLast[1] = nums[1];

        for(int i=2; i<nums.length;i++) {
            if(i!=1)
            includeFirst[i] = Math.max(includeFirst[i-2] + nums[i], includeFirst[i-1]);
            includeLast[i] = Math.max(includeLast[i-2] + nums[i], includeLast[i-1]);
        }
        return Math.max(includeFirst[nums.length-2], includeLast[nums.length-1]);
    }
}
