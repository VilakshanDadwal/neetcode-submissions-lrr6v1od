class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int costLength = cost.length;
        int[] minCost = new int[costLength];
        minCost[costLength-1] = cost[costLength-1];
        minCost[costLength-2] = cost[costLength-2];
        if(costLength==2)
         return Math.min(cost[costLength-1], cost[costLength-2]);

        for(int i=costLength-3; i>=0; i--) {
            minCost[i] = cost[i] + Math.min(minCost[i+1], minCost[i+2]);
        }
        return Math.min(minCost[0], minCost[1]) ;
    }
}
