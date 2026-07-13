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
// Revision
class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        var minHeap = new PriorityQueue<Interval>((a,b) -> Integer.compare(a.end, b.end));
        Collections.sort(intervals, (a,b) -> Integer.compare(a.start, b.start));
        var minRooms = 0;
        for(Interval interval: intervals) {
            while(!minHeap.isEmpty() && interval.start >= minHeap.peek().end)
                minHeap.poll();
            minHeap.add(interval);
            minRooms = Math.max(minRooms, minHeap.size());
        }
        return minRooms;
    }
}
