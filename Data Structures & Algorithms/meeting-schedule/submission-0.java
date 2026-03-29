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
    public boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals, Comparator.comparingInt(i-> i.start));
        for(int i=1; i < intervals.size(); i++) {
            var previous = intervals.get(i-1);
            var current = intervals.get(i);
            if(previous.end > current.start)
                return false;
        }
        return true;
    }
}
