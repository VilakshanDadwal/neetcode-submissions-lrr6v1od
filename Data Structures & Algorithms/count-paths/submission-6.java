// Revision - Bottom Up - single array
class Solution {
    public int uniquePaths(int m, int n) {
        var current = new int[n];
        Arrays.fill(current, 1);

        for(int i=m-2; i>=0; i--) {
            for(int j=n-2; j>=0; j--) {
                current[j] = current[j] + current[j+1];
            }
        } 
        return current[0];
    }
}
