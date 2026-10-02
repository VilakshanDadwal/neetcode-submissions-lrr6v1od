/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        Collections.sort(intervals, (a,b) -> Integer.compare(a.start, b.start));
        var minRooms = 0;
        var minHeap = new PriorityQueue<Integer>((a,b) -> Integer.compare(a,b));

        for(Interval interval : intervals) {
            while(!minHeap.isEmpty() && interval.start >= minHeap.peek()) {
                minHeap.poll();
            }
            minHeap.add(interval.end);
            minRooms = Math.max(minRooms, minHeap.size());
        }
        return minRooms;
    }
}
