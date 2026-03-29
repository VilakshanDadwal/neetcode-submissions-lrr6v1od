
// Revision - Take not take approach
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        var result = new ArrayList<List<Integer>>();
        var subset = new ArrayList<Integer>();
        subsets(0, nums, subset, result);
        return result;
    }

    void subsets(int idx, int[] nums, List<Integer> subset, List<List<Integer>> result) {
        if(idx ==nums.length) {
            result.add(new ArrayList<Integer>(subset));
            return;
        }
        subset.add(nums[idx]);
        subsets(idx+1, nums, subset, result);
        subset.remove(subset.size()-1);
        subsets(idx+1, nums, subset, result);
    }
}
