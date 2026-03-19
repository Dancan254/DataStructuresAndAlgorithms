package dsa.intervals.practice;

import java.util.Arrays;

/**
 * LeetCode 57 — Insert Interval
 * https://leetcode.com/problems/insert-interval/
 *
 * Given a list of non-overlapping intervals sorted by start time, and a new
 * interval, insert it and merge any overlapping intervals. Return the result.
 *
 * Example 1:
 *   Input:  intervals = [[1,3],[6,9]], newInterval = [2,5]
 *   Output: [[1,5],[6,9]]
 *
 * Example 2:
 *   Input:  intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 *   Output: [[1,2],[3,10],[12,16]]
 *
 * Constraints:
 *   - intervals is sorted by start time
 *   - intervals contains no overlapping intervals
 *
 * Hint: Three phases:
 *   1. Add all intervals that END before newInterval starts (no overlap).
 *      Condition: intervals[i][1] < newInterval[0]
 *   2. Merge all intervals that OVERLAP with newInterval.
 *      Condition: intervals[i][0] <= newInterval[1]
 *      Expand: newInterval[0] = min(...), newInterval[1] = max(...)
 *   3. Add newInterval, then add all remaining intervals.
 */
public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        // TODO: implement your solution
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // -------------------------------------------------------------------------

    public static void main(String[] args) {
        InsertInterval solution = new InsertInterval();

        int[][] r1 = solution.insert(new int[][]{{1,3},{6,9}}, new int[]{2,5});
        System.out.println(Arrays.deepToString(r1)); // [[1,5],[6,9]]

        int[][] r2 = solution.insert(
            new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}}, new int[]{4,8}
        );
        System.out.println(Arrays.deepToString(r2)); // [[1,2],[3,10],[12,16]]

        int[][] r3 = solution.insert(new int[][]{}, new int[]{5,7});
        System.out.println(Arrays.deepToString(r3)); // [[5,7]]
    }
}
