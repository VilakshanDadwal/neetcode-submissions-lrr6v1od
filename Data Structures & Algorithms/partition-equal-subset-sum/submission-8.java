// Revision | Space optimized - 2 Arrays
class Solution {
    public boolean canPartition(int[] nums) {
        var sum = Arrays.stream(nums).sum();
        if(sum%2!=0) return false;
        var target = sum/2;

        var current = new boolean[target+1];
        var previous = new boolean[target+1];
        previous[0] = true;
        for(int i=1; i<=nums.length; i++) {
            for(int j=0; j<=target; j++) {
                var currentNo = nums[i-1];
                if(currentNo <= j) {
                    current[j] = previous[j] || previous[j - currentNo];
                } else {
                    current[j] = previous[j];
                }
            }
            var temp = previous;
            previous = current;
            current = temp;
        }
        return previous[target];
    }
}
