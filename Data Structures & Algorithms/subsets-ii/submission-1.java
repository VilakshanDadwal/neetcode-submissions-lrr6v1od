class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        var result = new ArrayList<List<Integer>>();
        var current = new ArrayList<Integer>();
        result.add(current);
        backtrack(0, nums, current, result);
        return result;
    }

    void backtrack(int idx, int[] nums, List<Integer> current, List<List<Integer>> result) {
        if(idx == nums.length) {
            return;
        }

        for(int i=idx; i <nums.length; i++) {
            if(i>idx && nums[i] == nums[i-1]) continue;
            current.add(nums[i]);
            result.add(new ArrayList<Integer>(current));
            backtrack(i+1, nums, current, result);
            current.remove(current.size()-1);
        }
    }
}
