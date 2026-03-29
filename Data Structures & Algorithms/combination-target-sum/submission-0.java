class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        var result = new ArrayList<List<Integer>>();
        combinations(0, nums, target, 0, new ArrayList<Integer>(), result);
        return result;
    }

    void combinations(int i, int[] nums, int target, int sum, List<Integer> current, List<List<Integer>> result) {
        if(sum > target) return;
        if(i==nums.length) {
            if(sum==target) {
                result.add(current);
            }
            return;
        }
        var newCurrent = new ArrayList<Integer>(current);
        
        newCurrent.add(nums[i]);
        sum += nums[i];
        combinations(i, nums, target, sum, newCurrent, result);
        
        newCurrent.remove(newCurrent.size()-1);
        sum-= nums[i];
        combinations(i+1, nums, target, sum, newCurrent, result);
    }
}
