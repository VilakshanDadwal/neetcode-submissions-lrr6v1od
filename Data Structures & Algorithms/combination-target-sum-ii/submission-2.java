class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        var result = new ArrayList<List<Integer>>();
        var current = new ArrayList<Integer>();
        backtrack(0, candidates, target, current, result);
        return result;
    }

    private void backtrack(int idx, int[] nums, int target, List<Integer> current, List<List<Integer>> result) {
        if(target == 0) {
            result.add(new ArrayList<Integer>(current));
            return;
        }

        if(target < 0 || idx == nums.length) return;

        for(int i=idx; i < nums.length; i++) {
            // Check notes to understand need of i>idx.  
            if(i > idx && nums[i] == nums[i-1]) {
                continue;
            }
            current.add(nums[i]);
            backtrack(i+1, nums, target - nums[i], current, result);
            current.remove(current.size()-1);
        }
    }
}
