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

        current.add(candidates[i]);
        backtrack(i+1, candidates, target-candidates[i], current, result);

        current.remove(current.size() - 1);
        while(i+1 < candidates.length && candidates[i] == candidates[i+1]) {
            i++;
        }
        backtrack(i+1, candidates, target, current, result);
    }
}
