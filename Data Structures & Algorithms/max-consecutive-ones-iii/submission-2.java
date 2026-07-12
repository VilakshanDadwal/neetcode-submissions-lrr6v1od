class Solution {
    public int longestOnes(int[] nums, int k) {
        var left = 0;
        var longest=0;
        var zeroCount =0;
        for(int right=0; right<nums.length; right++) {
            if(nums[right] == 0) {
                zeroCount++;
                while(zeroCount > k) {
                    if(nums[left] == 0) {
                        zeroCount--;
                    }
                    left++;
                }
            }
            longest = Math.max(longest, right-left+1);
        }
        return longest;
    }
}