
class Solution {
    public int climbStairs(int n) {
        int prev = 1; int current = 1;
        for(int i=0; i<n-1; i++) {
            int temp = current;
            current = temp + prev;
            prev = temp;
        }
        return current;
    }
}
