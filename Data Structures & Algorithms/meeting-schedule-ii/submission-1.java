// Testing - BRUTE FORCE solution
class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int minRooms = 0;
        Collections.sort(intervals, Comparator.comparingInt(interval -> interval.start));
        var activeMeetings = new ArrayList<Interval>();
        for(Interval interval : intervals) {
            int count =1;
            for(Interval meeting: activeMeetings) {
                if(interval.start < meeting.end) count++;
            }
            minRooms = Math.max(minRooms, count);
            activeMeetings.add(interval);
        }
        return minRooms;
    }
}
