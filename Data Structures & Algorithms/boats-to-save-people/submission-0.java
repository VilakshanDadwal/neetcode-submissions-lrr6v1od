class Solution {
    public int numRescueBoats(int[] people, int limit) {
        var boatsNeeded = 0;
        var left =0;
        var right = people.length-1;
        Arrays.sort(people);
        while(left < right) {
            if(people[left] + people[right] <= limit) {
                left++;
                right--;
            } else {
                right--;
            }
            boatsNeeded++;
        }
        if(left == right) boatsNeeded++;
        return boatsNeeded;
    }
}