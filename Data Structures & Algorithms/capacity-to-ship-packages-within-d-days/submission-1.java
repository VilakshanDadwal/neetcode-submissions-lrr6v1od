class Solution {
    public int shipWithinDays(int[] weights, int days) {
        var minPossibleCapacity = 0;
        var maxPossibleCapacity = 0;
        for(int weight: weights) {
            minPossibleCapacity = Math.max(weight, minPossibleCapacity);
            maxPossibleCapacity += weight;
        }
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
                if(daysNeeded > days) return false;
                weightSum = weight;
            }
        }
        return true;
    }  
}