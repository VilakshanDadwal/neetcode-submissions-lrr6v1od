// Revision - Trying all numbers at a position approach.
class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        var result = new ArrayList<List<Integer>>();
        combSum(0, nums, new ArrayList<Integer>(), target, result);
        return result;
    }

    private void combSum(int idx, int[] nums, List<Integer> current, int target, List<List<Integer>> result) {
        if(target<0) return;
        if(target == 0) {
            result.add(new ArrayList<Integer>(current));
            return;
        }
        for(int i=idx; i<nums.length; i++) {
            current.add(nums[i]);
            combSum(i, nums, current, target-nums[i], result);
            current.remove(current.size()-1);
        }
    }
}
