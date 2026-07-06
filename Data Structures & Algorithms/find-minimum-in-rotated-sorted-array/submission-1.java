class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int ans = Integer.MAX_VALUE;

        while (left <= right) {

            // If the current range is already sorted,
            // the leftmost element is the minimum in this range.
            if (nums[left] <= nums[right]) {
                ans = Math.min(ans, nums[left]);
                break;
            }

            int mid = left + (right - left) / 2;

            ans = Math.min(ans, nums[mid]);

            // Left half is sorted
            if (nums[left] <= nums[mid]) {
                ans = Math.min(ans, nums[left]);
                left = mid + 1;
            }
            // Right half is sorted
            else {
                ans = Math.min(ans, nums[mid]);
                right = mid - 1;
            }
        }

        return ans;
    }
}