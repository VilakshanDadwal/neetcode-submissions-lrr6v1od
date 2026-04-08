// Brute Force
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        var result = new int[k];
        var freq = new HashMap<Integer, Integer>();
        var minHeap = new PriorityQueue<int[]>((a,b) -> Integer.compare(a[1], b[1]));
        for(int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        for(Map.Entry<Integer, Integer> entry: freq.entrySet()) {
            minHeap.add(new int[]{entry.getKey(), entry.getValue()});
            if(minHeap.size()>k) {
                minHeap.poll();
            }
        }
        for(int i=0; i<k; i++) {
            result[i] = minHeap.poll()[0];
        }
        return result;
    }
}
