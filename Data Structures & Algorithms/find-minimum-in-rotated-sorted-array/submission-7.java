// Checking if can return answer in else block.
class Solution {
    public int findMin(int[] nums) {
        var left = 0;
        var right = nums.length-1;

        while(left <= right) {
            var mid = left +(right-left)/2;
            // If left is bigger than mid, then the minimum value can be the mid, hence right = mid.
            if(nums[left] > nums[mid]) {
                right = mid;
            } else if(nums[mid] > nums[right]) {
            // Because smaller value will be to the right , and right is still included after moving left, this is fine.
                left = mid+1;
            } else {
                // array is sorted, no need to break further.
                return nums[left];
            }
        }
       
        // Break condition in if elese will always be satisfied, becasue there is always a min value.
        // break occurs when array is sorted and cannot be broken further. min value is the left value. hence returning left.
        return -1;
    }
}
