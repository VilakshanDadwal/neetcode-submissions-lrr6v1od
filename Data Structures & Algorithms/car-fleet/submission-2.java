class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] posnSpeed = new int[position.length][2];
        for(int i=0; i<posnSpeed.length; i++) {
            posnSpeed[i][0] = position[i];
            posnSpeed[i][1] = speed[i];
        }
        // Sorted in reverse order.
        Arrays.sort(posnSpeed, (a,b) -> Integer.compare(b[0],a[0]));
        int fleets = 1;
        double prevTime = (double)(target-posnSpeed[0][0])/posnSpeed[0][1];
        for(int i=1; i<posnSpeed.length; i++) {
            double timeTaken = (double)(target-posnSpeed[i][0])/posnSpeed[i][1];
            if(timeTaken > prevTime) {
                // If car behind slower than car ahead, they will reach individually as a separate fleet.
                fleets++;
                prevTime= timeTaken;
            }
            // if time faster than prevCar, then skip that car, its merged with previous car fleet.
        }
        return fleets;
    }
}
