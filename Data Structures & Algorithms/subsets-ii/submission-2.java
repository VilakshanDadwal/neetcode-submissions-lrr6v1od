// Revision - Take/NotTake approach
// In this case the skipping is done when before not taking the first occurence of duplicate.
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        var result = new ArrayList<List<Integer>>();
        backtrack(0, nums, new ArrayList<Integer>(), result);
        return result;
    }

    private void backtrack(int idx, int[] nums, List<Integer> current, List<List<Integer>> result) {
        if(idx == nums.length) {
            result.add(new ArrayList<Integer>(current));
            return;
        }
        
        current.add(nums[idx]);
        
        backtrack(idx+1, nums, current, result);

        current.remove(current.size()-1);
        while(idx < nums.length-1 && nums[idx] == nums[idx+1]) 
            idx++;
        backtrack(idx+1, nums, current, result);
    }
}
