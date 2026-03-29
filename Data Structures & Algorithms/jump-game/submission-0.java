class Solution {
    public boolean canJump(int[] nums) {
        var indexToReach = nums.length-1;
        for(int i=nums.length-2; i>=0; i--) {
            if(nums[i]+i >=indexToReach) {
                indexToReach = i;
            }
        }
        return indexToReach == 0;
    }
}
