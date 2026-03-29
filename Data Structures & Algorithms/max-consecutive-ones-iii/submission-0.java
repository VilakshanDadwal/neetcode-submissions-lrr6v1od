class Solution {
    public int longestOnes(int[] nums, int k) {
        var left = 0;
        var result = 0;
        var zerosCount = 0;
        for(int right=0; right < nums.length; right++) {
            var current = nums[right];
            if(current == 0) zerosCount++;
            while(zerosCount > k) {
                // Move left if left is a zero and decrement no of zeros.
                if(nums[left]==0) zerosCount--;
                // If left is a 1, then also left needs to be moved,
                // because  need to find a zero on the left size to remove from the window and have only k zeros in the window.
                left++;
            }
            result = Math.max(result, right-left+1);
        }
        return result;
    }
}