class Solution {
    public int search(int[] nums, int target) {
        var left = 0;
        var right = nums.length-1;

        while(left <=right) {
            var mid = left + (right-left)/2;
            if(nums[mid] == target)
                return mid;

            if(nums[left] <= nums[mid]) {
                // Left half is sorted. no equal to (=) for nums[mid] because that is handled at the top already.
                if(target >= nums[left] && target < nums[mid]) {
                    right = mid-1;
                } else {
                    left = mid+1;
                }
            } else if(nums[mid] <= nums[right]) {
                // Right half is sorted. no equal to (=) for nums[mid] because that is handled at the top already.
                if(target > nums[mid] && target <= nums[right]) {
                    left = mid+1;
                } else {
                    right = mid-1;
                }
            }
        }
        return -1;
    }
}
