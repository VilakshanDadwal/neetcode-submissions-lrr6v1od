class Solution {
    public int shipWithinDays(int[] weights, int days) {
        var minPossibleCapacity = Arrays.stream(weights).max().orElse(0);
        var maxPossibleCapacity = Arrays.stream(weights).sum();
        for (int capacity = minPossibleCapacity; capacity <= maxPossibleCapacity; capacity++) {
            var weightSum = 0;
            var daysNeeded = 1;
            for (int weight : weights) {
                weightSum += weight;
                if (weightSum > capacity) {
                    daysNeeded++;
                    weightSum = weight;
                }
            }
            if (daysNeeded <= days) {
                return capacity;
            }
        }

        return -1;
    }
}