class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        var result = new ArrayList<List<Integer>>();
        var current = new ArrayList<Integer>();
        result.add(current);
        backtrack(0, nums, current, result);
        return result;
    }

    void backtrack(int idx, int[] nums, List<Integer> current, List<List<Integer>> result) {
        if(idx==nums.length) return;
        for(int i=idx; i<nums.length; i++) {
            current.add(nums[i]);
            result.add(new ArrayList(current));
            backtrack(i+1, nums, current, result);
            current.remove(current.size()-1);
        }
    }
}
