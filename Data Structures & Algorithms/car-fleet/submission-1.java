class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] posnSpeed = new int[position.length][2];
        for(int i=0; i<posnSpeed.length; i++) {
            posnSpeed[i][0] = position[i];
            posnSpeed[i][1] = speed[i];
        }
        Arrays.sort(posnSpeed, (a,b) -> Integer.compare(b[0],a[0]));
        int fleets = position.length;
        double prevTime = (double)(target-posnSpeed[0][0])/posnSpeed[0][1];
        for(int i=1; i<posnSpeed.length; i++) {
            double timeTaken = (double)(target-posnSpeed[i][0])/posnSpeed[i][1];
            if(timeTaken <= prevTime) {
                fleets--;
                // prevTime not updated because slower car is previousTime already.
            } else {
                prevTime=timeTaken;
            }
        }
        return fleets;
    }
}
