class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length-1;
        int maxArea = 0;
        while(left < right) {
            int lesserHeight = Math.min(heights[left], heights[right]);
            int currentArea = (right-left) * lesserHeight;
            if(heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
            maxArea = Math.max(currentArea, maxArea);
        }
        return maxArea;
    }
}
