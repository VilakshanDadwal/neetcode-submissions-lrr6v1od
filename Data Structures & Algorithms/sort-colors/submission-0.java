// Two pass solution.
// Counting sort is better solution.
class Solution {
    public void sortColors(int[] nums) {
        var zero =0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i]==0) {
                swap(i, zero, nums);
                zero++;
            }
        }
        var one = zero;
        for(int i=one; i<nums.length; i++) {
            if(nums[i]==1) {
                swap(i, one, nums);
                one++;
            }
        }
    }
    private void swap(int i, int j, int[] nums) {
        var temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
 }