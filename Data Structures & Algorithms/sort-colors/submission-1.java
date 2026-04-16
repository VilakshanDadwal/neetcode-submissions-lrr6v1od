class Solution {
    public void sortColors(int[] nums) {
        var current =0;
        var left =0;
        var right = nums.length-1;

        while(current<=right) {
            if(nums[current] == 0) {
                swap(nums, left, current);
                left++;
                current++;
            } else if(nums[current]==2) {
                swap(nums, current, right);
                right--;
            } else {
                current++;
            }
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}