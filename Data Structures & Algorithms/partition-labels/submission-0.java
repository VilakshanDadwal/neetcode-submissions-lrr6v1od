class Solution {
    public List<Integer> partitionLabels(String s) {
        var lastOccurrence = new HashMap<Character, Integer>();
        for(int i=0; i<s.length(); i++) {
            lastOccurrence.put(s.charAt(i), i);
        }

        var result = new ArrayList<Integer>();
        var size = 0;
        var end = 0;
        for(int i=0; i<s.length(); i++) {
            size++;
            end = Math.max(end, lastOccurrence.get(s.charAt(i)));
            if(i==end) {
                result.add(size);
                size=0;
            }
        }
        return result;
    }
}
