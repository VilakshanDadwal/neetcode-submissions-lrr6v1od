class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        var result = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        backtrack(0, candidates, target, new ArrayList<Integer>(), result);
        return result;
    }

    void backtrack(int i, int[] candidates, int target, List<Integer> current, List<List<Integer>> result) {
        if(target==0) {
            result.add(new ArrayList<Integer>(current));
            return;
        }

        if(target<0 || i>=candidates.length) return;

        for(int idx=i; i<candidates.length; i++) {
            // i > idx check is to to skip duplicates of element at idx, for the same position in the combination.
            // [1,1,2,2] 1 at 0th index should be considered for first position in a combination and 1 at 1st index should not be considered for the first position in a combination.
            // 1 at 1st index can be considered as the second element in combination, if 1st element is 1 at first position. 
            if(i > idx && candidates[i] == candidates[i-1]) continue;
            current.add(candidates[i]);
            backtrack(i+1, candidates, target-candidates[i], current, result);
            current.remove(current.size() - 1);
        }
    }
}
