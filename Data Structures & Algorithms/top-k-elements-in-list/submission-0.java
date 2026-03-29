// Brute Force
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        var result = new int[k];
        var freq = new HashMap<Integer, Integer>();
        for(int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> freqEntryList = new ArrayList(freq.entrySet());
        freqEntryList.sort((a, b) -> Integer.compare(b.getValue(), a.getValue()));
        for(int i=0; i<k; i++) {
            var entry = freqEntryList.get(i);
            result[i] = entry.getKey();
        }
        return result;
    }
}
