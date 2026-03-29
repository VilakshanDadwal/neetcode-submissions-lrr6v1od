class Solution {
    public int jump(int[] nums) {
        var left =0;
        var right = 0;
        var minJumps =0;

        // Using less than nums.length-1 because if right reaches last index then one extra jump will be counted from last index.
        // Its safe to assume that if right is second last index. Then in the last iteration, the jump to last index will be counted.
        while(right < nums.length-1) {
            var farthestReachableIndex = 0;
            for(int i=left; i<=right; i++) {
                farthestReachableIndex = Math.max(i+nums[i], farthestReachableIndex);
            }
            left = right+1;
            right = farthestReachableIndex;
            minJumps++;
        }
        return minJumps;
    }
}
 