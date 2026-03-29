class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        var matched = new boolean[3];
        for(int[] triplet: triplets) {
            // Any triplet with value greater than target at any index, cannot be considered.
            if(triplet[0]>target[0] || triplet[1]>target[1] || triplet[2]>target[2]) 
                continue;
            // If any index value is same as target, then target value can be created
            for(int i=0; i < triplet.length; i++) {
                if(triplet[i] == target[i]) 
                    matched[i] = true;
            }
        }
        // If all true, return true else false
        return matched[0] && matched[1] && matched[2];
    }
}
