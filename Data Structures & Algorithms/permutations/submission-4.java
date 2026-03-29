// Revision - Optimal tracking picked elements solution
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        var result = new ArrayList<List<Integer>>();
        var current = new ArrayList<Integer>();

        permutate(current, nums, result, new boolean[nums.length]);
        return result;
    }

    // No need for index as param , because all indexes in the current numList are traversed in a for loop.
    // this is not a take/not take scenario.
    private void permutate(List<Integer> current, int[] nums, List<List<Integer>> result, boolean[] picked) {
        if(current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i=0; i<nums.length; i++) {
            if(picked[i]) continue;
            
            picked[i] = true;
            current.add(nums[i]);

            permutate(current, nums, result, picked);

            current.remove(current.size()-1);
            picked[i] = false;
        }
    }
}
