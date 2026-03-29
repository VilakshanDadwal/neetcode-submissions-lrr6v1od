// Revision - Consider each element using for loop approach.
class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        var result = new ArrayList<List<Integer>>();
        var current = new ArrayList<Integer>();
        backtrack(0, nums, target, current, result);
        return result;
    }

    private void backtrack(int idx, int[] nums, int target, List<Integer> current, List<List<Integer>> result) {
        if(target ==0) {
            result.add(new ArrayList<Integer>(current));
            return;
        }
        if(target < 0) return;

        for(int i=idx; i<nums.length; i++) {
            current.add(nums[i]);
            backtrack(i, nums, target-nums[i], current, result);
            // This is done for backtracking, so that before next number is considered.
            // state of the current list becomes same as it was when the recursive function was called.
            current.remove(current.size()-1);
        }
    }
}
