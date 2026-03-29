class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        var leftSpeedPerHour = 1;
        var rightSpeedPerHour = Arrays.stream(piles)
                            .max()
                            .getAsInt();

        var minEatingSpeed = leftSpeedPerHour;
        while(leftSpeedPerHour <= rightSpeedPerHour) {
            var midSpeedPerHour = (leftSpeedPerHour+rightSpeedPerHour)/2;
            // Needs to be a long becasue Math.ceil returns double. so to autocast it to long and not int.
            long timeTaken = 0;
            for(int i=0; i<piles.length; i++) {
                timeTaken += Math.ceil((double)piles[i]/midSpeedPerHour);
            }

            if(timeTaken > h) {
                leftSpeedPerHour = midSpeedPerHour + 1;
            } else {
                minEatingSpeed = midSpeedPerHour;
                // Need to find minmum so cannot return immediately.
                rightSpeedPerHour = midSpeedPerHour - 1;
            }
        }
        return minEatingSpeed;
    }
}
