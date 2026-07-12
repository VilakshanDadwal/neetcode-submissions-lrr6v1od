class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // Early exit if we don't need to plant any flowers
        if (n <= 0) return true; 

        for (int i = 0; i < flowerbed.length; i++) {
            // Only check if the current spot is empty
            if (flowerbed[i] == 0) {

                if ((i == 0 || flowerbed[i - 1] == 0) 
                        && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                    flowerbed[i] = 1; // Plant the flower
                    n--;
                    // Early exit if we've planted enough
                    if (n <= 0) return true; 
                }
            }
        }
        
        return n <= 0;
    }
}