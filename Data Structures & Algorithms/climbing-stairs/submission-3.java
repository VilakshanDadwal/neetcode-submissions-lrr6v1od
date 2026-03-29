class Solution {
    public int climbStairs(int n) {
        var cache = new int[n+1];
        Arrays.fill(cache, -1);
        return climbStairs(n, cache);
    }
    int climbStairs(int target, int[] cache) {
        if(target==0) return 1;
        if(target<0) return 0;
        if(cache[target] != -1) return cache[target];
        return cache[target] = climbStairs(target-1) + climbStairs(target-2);
    }
}