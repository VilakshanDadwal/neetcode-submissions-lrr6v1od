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
        int minRooms = 0;
        Collections.sort(intervals, Comparator.comparingInt(interval -> interval.start));
        var minHeap = new PriorityQueue<Interval>(Comparator.comparingInt(interval -> interval.end));
        for(Interval interval : intervals) {
            // Popping all rooms that are not clashing with current room. 
            while(!minHeap.isEmpty() && minHeap.peek().end <= interval.start) {
                minHeap.poll();
            }
            minHeap.add(interval);
            // Heap size shows rooms needed at any given time.
            // Taking max becasue there can be a case where 5 clashing at one time, and 3 clashing other time.
            minRooms = Math.max(minRooms, minHeap.size());
        }
        return minRooms;
    }
}
