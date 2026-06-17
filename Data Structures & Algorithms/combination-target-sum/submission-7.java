class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        var result = new ArrayList<List<Integer>>();
        backtrack(0, nums, target, new ArrayList<Integer>(), result);
        return result;
    }

    private void backtrack(int idx, int[] nums, int target, List<Integer> current, List<List<Integer>> result) {
        if(target == 0) {
            result.add(new ArrayList<Integer>(current));
            return;
        }
        if(target < 0) return;

        for(int i=idx; i<nums.length; i++) {
            current.add(nums[i]);
            backtrack(i, nums, target-nums[i], current, result);
            current.remove(current.size()-1);
        }
    }
}
