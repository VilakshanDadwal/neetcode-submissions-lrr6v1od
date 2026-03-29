class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        var result = new ArrayList<List<Integer>>();
        
        for(int i=0; i<nums.length; i++) {
            // To avoid duplicates combination.
            if(i>0 && nums[i] == nums[i-1]) continue;
            
            // i+1 because combination of numbers to the left have already been checked as i.
            int left = i+1; 
            int right = nums.length-1;

            while(left<right) {
                int twoSum = nums[left] + nums[right];

                if(twoSum + nums[i] == 0) {
                    result.add(Arrays.asList(nums[left], nums[right], nums[i]));
                    left++;
                    right--;
                    // To avoid duplicate combinations.
                    // Need to do only left because i is unique and left is unique. 
                    // so the 3 number combination will be unique.
                    while(left < right && nums[left] == nums[left-1]) {
                        left++;
                    }
                } else if(twoSum + nums[i] > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }
}
