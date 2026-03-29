class Solution {
    public List<List<Integer>> permute(int[] nums) {
        var result = new ArrayList<List<Integer>>();
        List<Integer> numList = new ArrayList<Integer>();
        for(int num:nums)
            numList.add(num);
        permutate(numList, new ArrayList<Integer>(), result);
        return result;
    }
    void permutate(List<Integer> nums, List<Integer> current, List<List<Integer>> result) {

        if(nums.isEmpty()) {
            result.add(current);
            return;
        }

        for(int i=0; i<nums.size(); i++) {
            var newCurrent = new ArrayList<Integer>(current);
            var newNums = new ArrayList<Integer>(nums);
            newCurrent.add(newNums.remove(i));
            permutate(newNums, newCurrent, result);
        }
    }
}
