class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0 || intervals[0].length == 0) {
            return 0;
        }
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(intervals.length, new IntervalComparator());
        Arrays.sort(intervals, new ArraySort());
        int count = 0;
        queue.add(intervals[0]);
        count++;
        for (int i = 1; i < intervals.length; i++) {
            int[] peek = queue.poll();
            if (intervals[i][0] < peek[1]) {
                count++;  
                queue.add(peek);
                queue.add(intervals[i]);
            } else {
                queue.add(intervals[i]);
            }
        }
        return count;
    }

    class IntervalComparator implements Comparator<int[]> {
        public int compare(int[] interval1, int[] interval2) {
            return interval1[1] - interval2[1];
        }
    }
    class ArraySort implements Comparator<int[]> {
        public int compare(int[] interval1, int[] interval2) {
            return interval1[0] - interval2[0];
        }
    }
}
