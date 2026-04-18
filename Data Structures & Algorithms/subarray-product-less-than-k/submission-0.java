class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        var left = 0;
        var count =0;
        var subArrayProduct = 1;
        for(int right=0; right<nums.length; right++) {
            subArrayProduct = subArrayProduct * nums[right];

            while(left <=right &&  subArrayProduct >= k) {
                subArrayProduct = subArrayProduct/nums[left];
                left++;
            }
            // Add number of sub arrays ending at right in the current window.
            // these are sub arrays starting at all positions in the current window and ending at right.
            // so whenever window increases , we are adding the number of new sub arrays that are valid, with addition of a new element.
            count += right - left + 1;
        }
        
        return count;
    }
}