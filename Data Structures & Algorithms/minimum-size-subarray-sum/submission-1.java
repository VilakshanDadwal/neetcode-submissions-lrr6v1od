class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        var minLength = Integer.MAX_VALUE;
        var left = 0;
        var sum =0;
        for(int right=0; right<nums.length; right++) {
            sum+=nums[right];
            while(sum>=target) {
                minLength = Math.min(minLength, right - left +1);
                sum-=nums[left];
                left++;
            }
        }
        return minLength == Integer.MAX_VALUE? 0 : minLength;
    }
}