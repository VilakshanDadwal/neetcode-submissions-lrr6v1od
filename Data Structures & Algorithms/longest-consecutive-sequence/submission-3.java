// Revision
class Solution {
    public int longestConsecutive(int[] nums) {
        var set = new HashSet<Integer>();
        for(int num: nums) {
            set.add(num);
        }

        var longest = 0;
        for(int i=0; i<nums.length; i++) {
            if(set.contains(nums[i]-1))
                continue;
            var count = 0;
            var current = nums[i];
            while(set.contains(current)) {
                current++;
                count++;
            }
            longest =Math.max(longest, count);
        }
        return longest;
    }
}
