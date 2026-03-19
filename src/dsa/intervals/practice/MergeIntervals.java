package dsa.intervals.practice;

import java.util.Arrays;

/**
 * LeetCode 56 — Merge Intervals
 * https://leetcode.com/problems/merge-intervals/
 *
 * Given an array of intervals, merge all overlapping intervals and return
 * the result as an array of non-overlapping intervals.
 *
 * Example 1:
 *   Input:  [[1,3],[2,6],[8,10],[15,18]]
 *   Output: [[1,6],[8,10],[15,18]]
 *
 * Example 2:
 *   Input:  [[1,4],[4,5]]
 *   Output: [[1,5]]   (touching intervals count as overlapping)
 *
 * Constraints:
 *   - 1 <= intervals.length <= 10^4
 *   - intervals[i].length == 2
 *   - 0 <= start <= end <= 10^4
 *
 * Hint: Sort intervals by start time.
 *       Iterate through the sorted list. For each interval:
 *         - If it overlaps with the last interval in your result list
 *           (curr.start <= last.end), extend last.end = max(last.end, curr.end).
 *         - Otherwise, add it as a new interval.
 *       Two intervals overlap when curr[0] <= last[1].
 */
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        // TODO: implement your solution
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // -------------------------------------------------------------------------

    public static void main(String[] args) {
        MergeIntervals solution = new MergeIntervals();

        System.out.println(Arrays.deepToString(
            solution.merge(new int[][]{{1,3},{2,6},{8,10},{15,18}})
        )); // [[1,6],[8,10],[15,18]]

        System.out.println(Arrays.deepToString(
            solution.merge(new int[][]{{1,4},{4,5}})
        )); // [[1,5]]

        System.out.println(Arrays.deepToString(
            solution.merge(new int[][]{{1,4},{0,4}})
        )); // [[0,4]]
    }
}
