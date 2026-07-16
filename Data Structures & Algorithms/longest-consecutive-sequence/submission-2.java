// Revision
class Solution {
    public int longestConsecutive(int[] nums) {
        var set = new HashSet<Integer>();
        for(int num: nums) {
            set.add(num);
        }

        var longest = 0;

        for(int i=0; i<nums.length; i++) {
            var current = nums[i];
            while(set.contains(current)) {
                current--;
            }
            var start = ++current;
            while(set.contains(current)) {
                set.remove(current);
                current++;
            }
            
            longest =Math.max(longest, current-start);
        }
        return longest;
    }
}
