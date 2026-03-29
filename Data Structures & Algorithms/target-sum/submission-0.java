// Using Map.
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        var cache = new HashMap<String, Integer>();
        return backtrack(0, target, nums, cache);
    }

    int backtrack(int idx, int target, int[] nums, Map<String, Integer> cache) {
        if(idx == nums.length ) 
            return target==0? 1 : 0;
        
        var key = String.valueOf(idx).concat("-").concat(String.valueOf(target));
        if(cache.containsKey(key))
            return cache.get(key);

        int ways =  backtrack(idx+1, target+nums[idx], nums, cache) 
                + backtrack(idx+1, target-nums[idx], nums, cache);
        cache.put(key, ways);
        return ways;
    }
}
