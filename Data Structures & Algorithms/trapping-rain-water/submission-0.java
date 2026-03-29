class Solution {
    public int trap(int[] height) {
        var leftMax = new int[height.length];
        var rightMax = new int[height.length];

        // There can be no water stored at 0 index
        // Also, there is no element on left. 
        // but storing leftMax[0] = height[0] for next indices leftMax calculation.
        leftMax[0] = height[0];
        for(int i=1; i<height.length; i++) {
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }

        // There can be no water stored at last index.
        // Also, there is no element to right. 
        // but storing right[n-1] = height[n-1] for next indices rightMax calculation.
        rightMax[height.length-1] = height[height.length-1];
        for(int i=height.length-2; i>=0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }

        int waterArea = 0;
        for(int i=0; i<height.length; i++) {
            waterArea += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return waterArea;
    }
}
