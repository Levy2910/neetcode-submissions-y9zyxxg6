class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        int res = 0;
        PriorityQueue<Interval> queue = new PriorityQueue<>((a, b) -> a.end - b.end);
        for (Interval interval : intervals){
            if (!queue.isEmpty()){
                Interval peek = queue.peek();
                if (peek.end <= interval.start){
                    queue.poll();
                }
            }
            queue.add(interval);
        }
        return queue.size();
    }
}