class Solution {
    public boolean hasDuplicate(int[] nums) {
        var helperNums = new HashSet<Integer>();
        for(int num : nums) {
            if(helperNums.contains(num)) {
                return true;
            }
            helperNums.add(num);
        }
        return false;
    }
}