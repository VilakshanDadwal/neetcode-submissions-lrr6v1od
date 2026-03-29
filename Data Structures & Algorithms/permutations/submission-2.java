class Solution {
    public List<List<Integer>> permute(int[] nums) {
        var result = new ArrayList<List<Integer>>();
        var visited = new boolean[nums.length]; 
        permutate(nums, visited, new ArrayList<Integer>(), result);
        return result;
    }
    void permutate(int[] nums, boolean[] visited, List<Integer> current, List<List<Integer>> result) {
        if(current.size() == nums.length) {
            result.add(new ArrayList(current));
            return;
        }

        for(int i=0; i<nums.length; i++) {
            if(visited[i]) continue;
            current.add(nums[i]);
            visited[i] = true;
            permutate(nums, visited, current, result);
            current.remove(current.size()-1);
            visited[i] = false;
        }
    }
}
