class Solution {
    public int maxSubArray(int[] nums) {
        var maxSum = Integer.MIN_VALUE;
        var subArraySum = 0;
        for(int num : nums) {
            subArraySum += num;
            if(subArraySum < num) {
                subArraySum = num;
            }
            maxSum = Math.max(maxSum, subArraySum);
        }
        return maxSum;
    }
}
