class Solution {
    public int uniquePaths(int m, int n) {
        var curr = new int[n];
        Arrays.fill(curr, 1);
        for(int i=m-2; i>=0; i--) {
            for(int j=n-2; j>=0; j--) {
                curr[j] = curr[j] + curr[j+1];
            }
        }
        return curr[0];
    }
}
