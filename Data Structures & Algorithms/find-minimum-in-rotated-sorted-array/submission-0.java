class Solution {
    public int findMin(int[] nums) {
        var left = 0;
        var right = nums.length-1;

        while(left <= right) {
            var mid = left +(right-left)/2;
            if(nums[left] > nums[mid]) {
                right = mid;
            } else if(nums[mid] > nums[right]) {
                left = mid+1;
            } else {
                break;
            }
        }
        if(left==right) return nums[left];
        return Math.min(nums[left], nums[(left+right)/2]);
    }
}
