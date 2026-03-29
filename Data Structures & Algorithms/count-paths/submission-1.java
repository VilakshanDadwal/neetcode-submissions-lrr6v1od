class Solution {
    public int uniquePaths(int m, int n) {
        var prev = new int[n];
        Arrays.fill(prev, 1);
        for(int i=m-2; i>=0; i--) {
            int[] curr = new int[n];
            for(int j=n-1; j>=0; j--) {
                if(j==n-1) {
                    curr[j]=1;
                 continue;
                }
                curr[j] = prev[j] + curr[j+1];
            }
            prev = curr;   
        }
        return prev[0];
    }
}
