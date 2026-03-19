package dsa.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 56 — Merge Intervals
 *
 * Given a list of intervals, merge all overlapping intervals.
 *
 * Pattern: Sort by start, iterate and extend the last merged interval.
 *
 * Two intervals overlap when curr.start <= last.end.
 * When they overlap, extend last.end to the max of both ends.
 * When they don't, add the current interval as a new entry.
 *
 * Time:  O(n log n)
 * Space: O(n)
 */
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]); // sort by start time

        List<int[]> merged = new ArrayList<>();
        merged.add(intervals[0]);

        for (int[] curr : intervals) {
            int[] last = merged.get(merged.size() - 1);
            if (curr[0] <= last[1]) {
                // Overlap — extend the end of the last interval
                last[1] = Math.max(last[1], curr[1]);
            } else {
                merged.add(curr);
            }
        }

        return merged.toArray(new int[0][]);
    }

    // -------------------------------------------------------------------------

    public static void main(String[] args) {
        MergeIntervals solution = new MergeIntervals();

        int[][] result1 = solution.merge(new int[][]{{1,3},{2,6},{8,10},{15,18}});
        for (int[] r : result1) System.out.println(Arrays.toString(r));
        // [1,6], [8,10], [15,18]

        int[][] result2 = solution.merge(new int[][]{{1,4},{4,5}});
        for (int[] r : result2) System.out.println(Arrays.toString(r));
        // [1,5]
    }
}
