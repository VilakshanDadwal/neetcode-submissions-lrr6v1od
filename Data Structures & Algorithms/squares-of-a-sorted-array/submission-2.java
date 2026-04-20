// Singel pass O(n), comparing extremes 
// and fill result from end.
class Solution {
    public int[] sortedSquares(int[] nums) {
        var result = new int[nums.length];
        var left = 0;
        var right = nums.length-1;

        var idx=nums.length-1;
        while(left <=right) {
            if(Math.abs(nums[left]) < Math.abs(nums[right])) {
                    result[idx] = nums[right] * nums[right];
                    right--;
                } else {
                    result[idx] = nums[left] * nums[left];
                    left++;
                }
                idx--;
        }
        return result;
    }
}