// Checking if can return answer in else
class Solution {
    public int findMin(int[] nums) {
        var left = 0;
        var right = nums.length-1;

        // Not using = becasue when left = right , then single element array. so no need to iterate that array. 
        // can break out of the loop when left = right
        while(left < right) {
            var mid = left +(right-left)/2;
            // If mid > right, min element is in the right half.
            if(nums[mid] > nums[right]) {
                left = mid+1;
            } else {
                // If mid <=right, then mid -> right is sorted. Thus, min value will be in left array 
                 // because left array is the unsorted one.
                // right = mid and not mid-1 , becasue mid can be the minValue as well here.
                right = mid;
            } 
        }
        // When above conditions not satisfied , this mean array represented by left and right is sorted.
        // This can be a single element array as well. The leftmost value is the minimum value.
        return nums[left];
    }
}
