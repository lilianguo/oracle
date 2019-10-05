/*
56. Merge Intervals
https://leetcode.com/problems/merge-intervals/submissions/
Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
*/
class MergeInterval {
    // time: nlogn
    // space: O(n)
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return intervals;
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> tmp = new ArrayList<>();
        tmp.add(intervals[0]);
        for (int i = 1; i <intervals.length; i++) {
            if (intervals[i][0] <= tmp.get(tmp.size() - 1)[1]) {
                tmp.get(tmp.size() - 1)[1] = Math.max(tmp.get(tmp.size() - 1)[1], intervals[i][1]);
            } else {
                tmp.add(intervals[i]);
            }
        }

        int[][] res = new int[tmp.size()][2];
        for (int i = 0; i < res.length; i++) {
            res[i][0] = tmp.get(i)[0];
            res[i][1] = tmp.get(i)[1];
        }
        return res;
    }
}