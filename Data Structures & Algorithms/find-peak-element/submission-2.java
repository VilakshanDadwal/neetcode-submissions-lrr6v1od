class Solution {
    public int findPeakElement(int[] nums) {
        var left =0; var right =nums.length-1;
        while(left <= right) {
            var mid = left +(right-left)/2;
            if((mid-1 <0 || nums[mid] > nums[mid-1]) 
                && (mid+1 >=nums.length || nums[mid] > nums[mid+1])) {
                    return mid;
                } else if(mid-1 >=0 && nums[mid-1] > nums[mid]) {
                    right = mid-1;
                } else {
                    left = mid+1;
                }
        }
        return -1;
    }
}