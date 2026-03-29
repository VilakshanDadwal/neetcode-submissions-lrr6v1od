// Revision
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        var result = new ArrayList<List<Integer>>();
        for(int i=0; i<=nums.length-3; i++) {
            if(i!=0 && nums[i]==nums[i-1]) continue;
            var target = -nums[i];
            var left = i+1;
            var right = nums.length-1;
            while(left<right) {
                var sum = nums[left] + nums[right];
                if(sum < target) {
                    left++;
                } else if(sum > target) {
                    right--;
                } else {
                    result.add(Arrays.asList(-target, nums[left], nums[right]));
                    // Answer found, but still need to consider some other combinations remaining
                    left++;
                    right--;
                    // Important condition.
                    while(left < right && nums[left] == nums[left-1]) left++;
                }
            }
        }
        return result;
    }
}
