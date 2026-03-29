// Revision
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        var result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        var current = new ArrayList<Integer>();
        result.add(current);
        subsets(0, nums, current, result);
        return result;
    }

    private void subsets(int idx, int[] nums, List<Integer> current, List<List<Integer>> result) {
        if(idx == nums.length) return;
        for(int i=idx; i<nums.length; i++) {
            if(i!=idx && nums[i] == nums[i-1]) continue;
            current.add(nums[i]);
            result.add(new ArrayList<Integer>(current));
            subsets(i+1, nums, current, result);
            current.remove(current.size()-1);
        }
    }
}
