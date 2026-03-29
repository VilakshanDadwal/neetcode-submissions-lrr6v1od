// Optimal alternative solution.
class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        var first = false; 
        var second = false;
        var third = false;
        for(int[] t: triplets) {
            // || condition used here so that if once true is encountered, it remains true and does not become false.
            first = first || (t[0] == target[0] && t[1] <= target[1] && t[2] <= target[2]);
            second = second || (t[0] <= target[0] && t[1] == target[1] && t[2] <= target[2]);
            third = third || (t[0] <= target[0] && t[1] <= target[1] && t[2] == target[2]);
            // If a matching value found for all 3 index, return true.
            if(first && second && third)
                return true;
        }
        return false;
    }
}
