class Solution {
    public int maxProduct(int[] nums) {
        var currentMaxProduct = nums[0];
        var currentMinProduct = nums[0];
        var maxProduct = nums[0];
        for(int i=1; i < nums.length; i++) {
            // This is needed because this currentMaxProduct value will be replaced
            // and its needed in calculation of currentMinProduct.
            var tmpMax = currentMaxProduct*nums[i];
            currentMaxProduct = Math.max(nums[i],
                Math.max(tmpMax, currentMinProduct * nums[i]));
            currentMinProduct = Math.min(nums[i],
                Math.min(tmpMax, currentMinProduct * nums[i]));
            // only currentMaxProduct is compared because we are looking for maxProduct.
            maxProduct = Math.max(maxProduct, currentMaxProduct);
        }
        return maxProduct;
    }
}
