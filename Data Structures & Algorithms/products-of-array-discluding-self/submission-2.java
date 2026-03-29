// Revision
class Solution {
    public int[] productExceptSelf(int[] nums) {
        var result = new int[nums.length];
        result[0] = 1;
        for(int i=1; i < nums.length; i++) {
            result[i] = result[i-1] *  nums[i-1];
        }
        var rightProduct = 1;
        for(int i=nums.length-1; i >= 0; i--) {
            // Current result after filling left product , is product of all nums to left.
            // so need to use result[i] and not [i-1] or [i+1]
            result[i] = result[i] * rightProduct;
            rightProduct *= nums[i];
        }
        return result;
    }
}  
