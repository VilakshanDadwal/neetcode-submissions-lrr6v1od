class Solution {
    public int longestConsecutive(int[] nums) {
        var numbers = new HashSet<Integer>();
        for(int num: nums) {
            numbers.add(num);
        }
        var lcs = 0;
        for(int num: numbers) {
            if(!numbers.contains(num-1)){
                var currentLength = 1;
                while(numbers.contains(++num)) {
                    currentLength++;
                }
                lcs = Math.max(lcs, currentLength);
            }
        }
        return lcs;
    }
}
