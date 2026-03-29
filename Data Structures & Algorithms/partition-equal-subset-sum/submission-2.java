class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if(sum%2 !=0) return false;

        boolean[][] cache = new boolean[nums.length+1][sum/2+1];

        for(int i=0; i<=nums.length; i++)
            cache[i][0] = true;

        for(int i=1; i<=nums.length; i++) {
            int num = nums[i-1]; // Because the idx of array corresponding to cache is i-1(1 idx behind).
            for(int j=0; j<=sum/2;j++) {
                if(num <= j) {
                    cache[i][j] = cache[i-1][j] || cache[i-1][j-num];
                } else {
                    cache[i][j] = cache[i-1][j];
                }
            }
        }
        return cache[cache.length-1][cache[0].length-1];
    }
}
