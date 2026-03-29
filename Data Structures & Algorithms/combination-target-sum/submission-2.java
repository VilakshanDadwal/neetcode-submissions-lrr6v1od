class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        var result = new ArrayList<List<Integer>>();
        combinations(0, nums, target, new ArrayList<Integer>(), result);
        return result;
    }

    void combinations(int i, int[] nums, int target, List<Integer> current, List<List<Integer>> result) {
        if(target == 0) {
            result.add(new ArrayList(current));
            return;
        }  
        if(target<0 || i>=nums.length) return;

        current.add(nums[i]);
        combinations(i, nums, target-nums[i], current, result);
        
        current.remove(current.size()-1);
        combinations(i+1, nums, target, current, result);
    }
}
