// Bottom Up - HashMap
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        var dp = new ArrayList<Map<Integer, Integer>>();
        for(int i=0; i< nums.length; i++) {
            dp.add(new HashMap<Integer, Integer>());
        }
        

        // Base case, if first element is 0, there can be 2 ways in which 0 sum can be creatd.
        // Thats why need to get value and do
        dp.get(0).put(nums[0], dp.get(0).getOrDefault(nums[0], 0) + 1);
        dp.get(0).put(-nums[0], dp.get(0).getOrDefault(-nums[0], 0) + 1);

        for(int i=1; i<nums.length; i++) {
            var previousMap = dp.get(i-1);
            for(Map.Entry<Integer, Integer> entry : previousMap.entrySet()) {
                var previousSum = entry.getKey();
                var previousWays = entry.getValue();
                var currentMap = dp.get(i);
                var currentMapSumWaysPostAddition = getExistingValuForSum(dp,previousSum + nums[i], i);
                currentMap.put(previousSum + nums[i], currentMapSumWaysPostAddition + previousWays);
                var currentMapSumWaysPostSubtract = getExistingValuForSum(dp,previousSum - nums[i], i);
                currentMap.put(previousSum - nums[i], currentMapSumWaysPostSubtract + previousWays);
            }
        }
        return dp.get(nums.length-1).getOrDefault(target, 0);
    }
    int getExistingValuForSum(List<Map<Integer, Integer>> dp, int sum, int i) {
        return dp.get(i).getOrDefault(sum, 0);
    }
}
