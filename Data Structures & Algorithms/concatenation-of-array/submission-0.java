class Solution {
    public int[] getConcatenation(int[] nums) {
        var result = new int[2*nums.length];

        for(int i=0; i<2*nums.length; i++) {
            var k = i % nums.length;
            result[i] = nums[k];
        }
        return result;
    }
}