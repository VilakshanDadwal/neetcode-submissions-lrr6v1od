
// Revision - Consider remaining elements one by one (Using for loop)
// This is different from "take/not take" approach
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        var result = new ArrayList<List<Integer>>();
        var subset = new ArrayList<Integer>();
        result.add(subset);
        subsets(0, nums, subset, result);
        return result;
    }

    void subsets(int idx, int[] nums, List<Integer> subset, List<List<Integer>> result) {
        if(idx == nums.length) return;
        for(int i=idx; i<nums.length; i++) {
            subset.add(nums[i]);
            result.add(new ArrayList<Integer>(subset));
            subsets(i+1, nums, subset, result);
            subset.remove(subset.size()-1);
        }
    }
}
