// Bottom Up - Pick Notpick solution
// We try out all numbers.
// Space Optimised
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        var allNumSum = 0;
        for(int num: nums) allNumSum += num;
        if (Math.abs(target) > allNumSum) return 0;
        var current = new int[2*allNumSum + 1];
        var prev = new int[2*allNumSum + 1];
        // By choosing no number 1 way to create target of 0.
        // 0 target corresponds to allNumSum index.
        prev[allNumSum] = 1;

        for(int i=1; i<=nums.length; i++) {
            var currentNum = nums[i-1];
            for(int j=0; j<=2*allNumSum; j++) {
                // Chose +num , check if current target - currentNum valid 
                // use it if exists in previous row
                if(j-currentNum >= 0) {
                    current[j] = prev[j-currentNum];
                } 
                // Chose -num , check if current target + currentNum valid
                // use it if exists in previous row
                if(j+currentNum <= 2*allNumSum) {
                    current[j] += prev[j+currentNum];
                }
            }
            var temp = prev;
            prev = current;
            current = temp;
        }
        return prev[target+allNumSum];
    }
}
