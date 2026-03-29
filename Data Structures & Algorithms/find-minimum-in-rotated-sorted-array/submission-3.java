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
                break;
            }
        }
        // Break will always occur.
        // If left == right, means we have the minimim value.
        return nums[left];
        // It could be that array is sorted order without rotation, this condition is for that case.
        //return Math.min(nums[left], nums[(left+right)/2]);
    }
}
