class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;

        var frequencyMap = new HashMap<Integer, Integer>();
        for (int num : hand) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        Arrays.sort(hand);
        for(int start : hand) {
            if(frequencyMap.get(start) > 0) {
                for(int number=start; number < start+groupSize; number++) {
                    // count can be null becasue number can be a value not present in hand array.
                    var count = frequencyMap.get(number);
                    if(count == null || count == 0) 
                        return false;
                    frequencyMap.put(number, frequencyMap.get(number)-1);
                }
            }
        }
        return true;
    }
}
