class Solution {
    public List<List<Integer>> permute(int[] nums) {
        var result = new ArrayList<List<Integer>>();
        permutate(0, nums, result);
        return result;
    }
    void permutate(int idx, int[] nums, List<List<Integer>> result) {
        if(idx == nums.length) {
            var permutation = new ArrayList<Integer>();
            for(int num: nums) {
                permutation.add(num);
            }
            result.add(permutation);
        }

        for(int i=idx; i<nums.length; i++) {
            swap(nums, idx, i);
            permutate(idx+1, nums, result);
            swap(nums, idx, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
