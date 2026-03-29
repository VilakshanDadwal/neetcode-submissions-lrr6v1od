class Solution {
    public int[] twoSum(int[] nums, int target) {
        var  map = new HashMap<Integer, Integer>();
        map.put(nums[0], 0);
        for(int i=1; i<nums.length; i++) {
            if(map.containsKey(target-nums[i])){
                int idx = map.get(target-nums[i]);
                return new int[] {idx, i};
            }

            map.put(nums[i], i);
        }
        return new int[0];
    }
}
