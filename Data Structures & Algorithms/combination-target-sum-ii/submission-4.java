class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        var result = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        combSum2(0, new ArrayList<Integer>(), candidates, target, result);
        return result;
    }

    private void combSum2(int idx, List<Integer> current, int[] nums, int target, List<List<Integer>> result) {
        
        if(target == 0) {
            result.add(new ArrayList<Integer>(current));
            return;
        }
        // This has to be after the target ==0 check, becasue if after adding last number , 
        // recursive call is made with idx==num.length , we want it to be added to the result.
        // If this was before target==0 check, function would return and valid combination wont be added to result.
        if(target < 0 || idx == nums.length) return;

        for(int i = idx; i<nums.length; i++) {
            // Using i!=idx and trying
            if(i!=idx && nums[i-1] == nums[i]) continue;
            current.add(nums[i]);
            combSum2(i+1, current, nums, target-nums[i], result);
            current.remove(current.size()-1);
        }
    }
}
