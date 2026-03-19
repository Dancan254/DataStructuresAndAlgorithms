package dsa.arrays_hashing.practice;

/**
 * LeetCode 128 — Longest Consecutive Sequence
 * https://leetcode.com/problems/longest-consecutive-sequence/
 *
 * Given an unsorted array of integers, return the length of the longest
 * sequence of consecutive integers. Must run in O(n).
 *
 * Example 1:
 *   Input:  [100, 4, 200, 1, 3, 2]
 *   Output: 4   (the sequence 1, 2, 3, 4)
 *
 * Example 2:
 *   Input:  [0, 3, 7, 2, 5, 8, 4, 6, 0, 1]
 *   Output: 9
 *
 * Constraints:
 *   - 0 <= nums.length <= 10^5
 *   - -10^9 <= nums[i] <= 10^9
 *
 * Hint: Put all numbers in a HashSet. Then for each number n, only start
 *       counting a sequence if (n - 1) is NOT in the set — this means n is
 *       the beginning of a sequence. Count upward from there.
 *       Why does this guarantee O(n) overall?
 */
public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        // TODO: implement your solution
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // -------------------------------------------------------------------------

    public static void main(String[] args) {
        LongestConsecutiveSequence solution = new LongestConsecutiveSequence();

        System.out.println(solution.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));        // 4
        System.out.println(solution.longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1})); // 9
        System.out.println(solution.longestConsecutive(new int[]{}));                              // 0
    }
}
