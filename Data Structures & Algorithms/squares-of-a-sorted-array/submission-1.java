// Two pass O(n)
class Solution {
    public int[] sortedSquares(int[] nums) {
        var right = nums.length;
        var result = new int[nums.length];

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] >=0) {
                right = i;
                break;
            }
        }
        var left = right-1;
        var idx=0;
        while(right < nums.length && left >=0) {
            if(nums[right] * nums[right]
                <= nums[left] * nums[left]) {
                    result[idx] = nums[right] * nums[right];
                    right++;
                } else {
                    result[idx] = nums[left] * nums[left];
                    left--;
                }
                idx++;
        }

        while(right < nums.length){
            result[idx] = nums[right] * nums[right];
            idx++;
            right++;
        }
        while(left >= 0){
            result[idx] = nums[left] * nums[left];
            idx++;
            left--;
        }

        return result;

    }
}