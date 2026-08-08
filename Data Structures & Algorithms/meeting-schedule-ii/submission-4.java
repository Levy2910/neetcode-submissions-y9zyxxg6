class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals.isEmpty()) return 0;

        Collections.sort(intervals, (a, b) -> a.start - b.start);

        PriorityQueue<Interval> pq =
                new PriorityQueue<>((a, b) -> a.end - b.end);

        int rooms = 0;

        for (Interval interval : intervals) {
            while (!pq.isEmpty() && pq.peek().end <= interval.start) {
                pq.poll();
            }

            pq.offer(interval);
            rooms = Math.max(rooms, pq.size());
        }

        return rooms;
    }
}