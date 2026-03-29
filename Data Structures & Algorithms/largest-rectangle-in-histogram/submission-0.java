// Single pass solution
class Solution {
    public int largestRectangleArea(int[] heights) {
        var stack = new Stack<int[]>();
        var maxArea = 0;
        for(int i=0; i < heights.length; i++) {
            var current = heights[i];
            if(stack.isEmpty() || current >= stack.peek()[1]) {
                stack.push(new int[]{i, current});
                continue;
            }
            
            var startIdxForCurrent = i;
            // When a smaller bar found, it will be the right edge of bars on stack.
            // Also find the left edge of current bar by popping bars off the stack.
            // Calculate area of the bars popped, because they already have their left edge.
            // Left edge of current bar will be the bar whose size is smaller than current.
            // TO set the left edge, use the left edge of the last popped off bar thats greater than current bar.
            while(!stack.isEmpty() && current < stack.peek()[1]) {
                var prevBarInfo = stack.pop();
                var prevBarLeftEdge = prevBarInfo[0];
                var prevBarRightEdge = i-1;
                var prevBarArea = prevBarInfo[1] * (prevBarRightEdge - prevBarLeftEdge + 1);
                maxArea = Math.max(maxArea, prevBarArea);
                startIdxForCurrent = prevBarLeftEdge;
            }
            stack.push(new int[]{startIdxForCurrent, current});
        }

        // Process bars remaining in the stack.
        // These can extend till end of array i.e they dont have a bar as right edge.
        while(!stack.isEmpty()) {
            var prevBarInfo = stack.pop();
            var prevBarLeftEdge = prevBarInfo[0];
            var prevBarRightEdge = heights.length - 1;
            var prevBarArea = prevBarInfo[1] * (prevBarRightEdge - prevBarLeftEdge + 1);
            maxArea = Math.max(maxArea, prevBarArea);
        }
        return maxArea;
    }
}
