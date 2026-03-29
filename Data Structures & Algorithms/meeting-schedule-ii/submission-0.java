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
        int minRooms = 0;
        Collections.sort(intervals, Comparator.comparingInt(interval -> interval.start));
        var minHeap = new PriorityQueue<Interval>(Comparator.comparingInt(interval -> interval.end));
        for(Interval interval : intervals) {
            while(!minHeap.isEmpty() && minHeap.peek().end <= interval.start) {
                minHeap.poll();
            }
            minHeap.add(interval);
            minRooms = Math.max(minRooms, minHeap.size());
        }
        return minRooms;
    }
}
