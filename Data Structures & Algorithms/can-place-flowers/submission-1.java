class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        var flowersPlaced = 0;
        var openPositions = flowerbed[0] == 0 ? 1: 0; // If staring with 0 to get correct count , intialise with 1.
        // For [0,0,1] , 1 flower can be placed. 1 flower can be placed, but our formula will give (2-1)/2 = 0. 
        // For start and end answer will be 1 more than formula
        for(int i=0; i<flowerbed.length; i++) {
            var isPlaced = flowerbed[i];
            if(isPlaced == 1) {
                flowersPlaced += (openPositions-1)/2;
                openPositions = 0;
            } else if(isPlaced == 0) {
                openPositions++;
            }
        }
        // handle trailing zeros at the end
        flowersPlaced += openPositions / 2;

        return flowersPlaced >= n;
    }
}