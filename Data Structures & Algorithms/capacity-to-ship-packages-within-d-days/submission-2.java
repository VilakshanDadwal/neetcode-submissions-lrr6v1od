class Solution {
    public int shipWithinDays(int[] weights, int days) {
        var minPossibleCapacity = Arrays.stream(weights).max().orElse(0);
        var maxPossibleCapacity = Arrays.stream(weights).sum();
        var result = minPossibleCapacity;
        while(minPossibleCapacity <=maxPossibleCapacity) {
            var capacity = (minPossibleCapacity + maxPossibleCapacity)/2;
            if(canShip(weights, days, capacity)) {
                result = capacity;
                maxPossibleCapacity = capacity - 1;
            } else {
                minPossibleCapacity = capacity + 1;
            }
        }
        return result;
    }
    private boolean canShip(int[] weights, int days, int capacity) {
        var weightSum = 0;
        var daysNeeded = 1;
        for (int weight : weights) {
            weightSum += weight;
            if (weightSum > capacity) {
                daysNeeded++;
                weightSum = weight;
            }
            if(daysNeeded > days) return false;
        }
        return true;
    }  
}