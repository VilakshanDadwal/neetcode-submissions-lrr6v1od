// Revision - Bottom Up
class Solution {
    public int uniquePaths(int m, int n) {
        var current = new int[n];
        var prev = new int[n];
        Arrays.fill(prev, 1);

        for(int i=m-2; i>=0; i--) {
            current[n-1] = 1;
            for(int j=n-2; j>=0; j--) {
                current[j] = prev[j] + current[j+1];
            }
            var temp = prev;
            prev = current;
            current = prev;
        } 
        return prev[0];
    }
}
