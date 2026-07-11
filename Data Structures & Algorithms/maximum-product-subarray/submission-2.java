class Solution {
    public int maxProduct(int[] nums) {
        var max = Integer.MIN_VALUE;
        var currentMax = 1;
        var currentMin = 1;
        for(int num: nums) {
            var prevMax = currentMax;
            currentMax = Math.max(currentMax * num, Math.max(num * currentMin, num));
            currentMin = Math.min(currentMin*num, Math.min(num*prevMax, num));
            max = Math.max(max, currentMax);
        }
        return max;
    }
}
