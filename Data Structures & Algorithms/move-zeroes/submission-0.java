class Solution {
    public void moveZeroes(int[] nums) {
        var current =0;
        for(int num : nums) {
            if(num!=0) {
                nums[current] = num;
                current++;
            }
        }
        while(current < nums.length) {
            nums[current] =0;
            current++;
        }
    }
}