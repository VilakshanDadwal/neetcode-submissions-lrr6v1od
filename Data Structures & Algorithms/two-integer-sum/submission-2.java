// Revision
class Solution {
    public int[] twoSum(int[] nums, int target) {
        var map = new HashMap<Integer, Integer>();
        var result = new int[2];
        for(int i=0; i<nums.length; i++) {
            var current = nums[i];
            var diff = target-current;
            if(map.containsKey(diff)) {
                result[0] = Math.min(i, map.get(diff));
                result[1] = Math.max(i, map.get(diff)); 
            } 
            map.put(current, i);
        }
        return result;
    }
}
