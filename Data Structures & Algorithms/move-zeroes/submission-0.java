class Solution {
    public void moveZeroes(int[] nums) {
        var current =0;
        for(int i=0; i<nums.length;i++) {
            if(nums[i]!=0) {
                var temp = nums[i];
                nums[i] = nums[current];
                nums[current] = temp;
                current++;
            }
        }
    }
}