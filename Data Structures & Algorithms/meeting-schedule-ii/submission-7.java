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
// NeetCode soln explanation.
// This was a bit non intuitive for me. 
class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int minRooms = 0;
        Collections.sort(intervals, Comparator.comparingInt(interval -> interval.start));
        var minHeap = new PriorityQueue<Interval>(Comparator.comparingInt(interval -> interval.end));
        for(Interval interval : intervals) {
            // Pop the meeting, which has ended and the room can be used up. 
            // Hear heap represents maxRooms that were needed at any time.
            // It does not track , actual clashing meetings at any given time.
            // We just resuse an existing room if the current does not clash with earlier finishing meeting.(smallest end time)
            if(!minHeap.isEmpty() && minHeap.peek().end <= interval.start) {
                minHeap.poll();
            }
            // Add the new meeting to the heap. It will either reuse and existing room
            // Or it will use a new room. Popping signifies using an existing room.
            minHeap.add(interval);
        }
        // Heap size represents max number of rooms used.
        // We are not popping all the meetings that have ended. We are just reusing existing room for new meeting if existing room can be used.
        // So even for the case where 5 were clashing first and 3 afterwards.
        // becasue the 5 clashing are not removed, the 3 that come after it just pop the meetings of the 5 clashing meetings and add their own end time.
        /// So heap size remains 5.
        return minHeap.size();
    }
}
