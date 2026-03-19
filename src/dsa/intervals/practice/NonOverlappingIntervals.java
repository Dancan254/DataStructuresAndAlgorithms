package dsa.intervals.practice;

/**
 * LeetCode 435 — Non-overlapping Intervals
 * https://leetcode.com/problems/non-overlapping-intervals/
 *
 * Given an array of intervals, return the minimum number of intervals you need
 * to remove to make the rest non-overlapping.
 *
 * Example 1:
 *   Input:  [[1,2],[2,3],[3,4],[1,3]]
 *   Output: 1   (remove [1,3])
 *
 * Example 2:
 *   Input:  [[1,2],[1,2],[1,2]]
 *   Output: 2   (remove two of the three identical intervals)
 *
 * Example 3:
 *   Input:  [[1,2],[2,3]]
 *   Output: 0   (already non-overlapping)
 *
 * Constraints:
 *   - 1 <= intervals.length <= 10^5
 *   - -5 * 10^4 <= start < end <= 5 * 10^4
 *
 * Hint: This is equivalent to: find the MAXIMUM number of non-overlapping intervals to KEEP.
 *       Greedy: sort by end time. Always keep the interval that ends earliest —
 *       it leaves the most room for future intervals.
 *       When two intervals overlap (curr.start < prevEnd), remove the one with
 *       the later end (which is always curr, since you sorted by end).
 *       Answer = total - kept.
 */
public class NonOverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        // TODO: implement your solution
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // -------------------------------------------------------------------------

    public static void main(String[] args) {
        NonOverlappingIntervals solution = new NonOverlappingIntervals();

        System.out.println(solution.eraseOverlapIntervals(new int[][]{{1,2},{2,3},{3,4},{1,3}})); // 1
        System.out.println(solution.eraseOverlapIntervals(new int[][]{{1,2},{1,2},{1,2}}));       // 2
        System.out.println(solution.eraseOverlapIntervals(new int[][]{{1,2},{2,3}}));             // 0
        System.out.println(solution.eraseOverlapIntervals(new int[][]{{-52,31},{-73,-26},{82,97},{-65,-11},{-62,-49},{95,99},{58,95}})); // 1
    }
}
