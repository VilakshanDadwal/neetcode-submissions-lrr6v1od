// Revision
class Solution {
    public int maxArea(int[] heights) {
        var left =0;
        var right = heights.length-1;
        var maxArea = Integer.MIN_VALUE;
        while(left < right) {
            var currentArea = (right - left) * Math.min(heights[left], heights[right]);
            maxArea = Math.max(maxArea, currentArea);
            if(heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
