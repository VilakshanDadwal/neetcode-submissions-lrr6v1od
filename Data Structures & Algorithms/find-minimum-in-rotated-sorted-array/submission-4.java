// Trying nums right in the end
class Solution {
    public int findMin(int[] nums) {
        var left = 0;
        var right = nums.length-1;

        while(left<right) {
            var mid = (left+right)/2;
            // If right side unsorted, min value will be in right.
            // Example [1,2,3,0] [7,6,5,4] - Left can be sorted or unsorted. 
            // In first case left side sorted, in second case its unsorted.
            if(nums[mid] > nums[right]) { 
                left = mid+1;
            }

            // If right side is sorted, min value will be in left.
            // Example [6,0,1,2,3] [4,5,6,7] - Left can be sorted or unsorted. 
            // In first case left side unsorted, in second case its sorted.
            else if(nums[mid] < nums[right]) {
                right = mid;
            }

            // if(nums[left] < nums[mid] && nums[mid] < nums[right]) {
            //     return nums[left];
            // }

            // if(nums[left] > nums[mid] && nums[mid] > nums[right]) {
            //     return nums[right];
            // } 
        }
        // Returning Left here , becasue while loop will exit when there is only one element left in the array i.e left ==right
        // Imagine in the end two numbers left in the array. 
        return nums[right];
    }
}
