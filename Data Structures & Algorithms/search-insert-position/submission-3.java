class Solution {
    public int searchInsert(int[] nums, int target) {
        var left = 0;
        var right = nums.length-1;
        var result = nums.length; // For the scenario when target > all elements.
        
        while(left<=right) {
            var mid = left +(right-left)/2;
            if(target < nums[mid]) {
                right = mid-1;
                // We are lookign for the first number greater than target.
                // When target < mid value, mid can be greater than target. so including it as result.
                result = mid;
            } else if(target > nums[mid]) {
                left = mid+1;
            } else {
                result = mid;
                break;
            }
        }
        return result;
    }
}