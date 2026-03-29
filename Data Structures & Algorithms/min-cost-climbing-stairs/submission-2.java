// Revision - Memoization
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        var cache = new int[cost.length];
        Arrays.fill(cache, -1);
        minCost(0, cost, cache);
        return Math.min(cache[0], cache[1]);
    }

    int minCost(int idx, int[] cost, int[] cache) {
        if(idx >= cost.length) return 0;
        if(cache[idx] !=-1) return cache[idx];
        return cache[idx] = cost[idx]
             + Math.min(minCost(idx+1, cost, cache),
                minCost(idx+2, cost, cache)); 
    }
}
