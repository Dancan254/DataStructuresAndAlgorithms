package dsa.arrays_hashing;

import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode 128 — Longest Consecutive Sequence
 *
 * Given an unsorted array, find the length of the longest sequence of
 * consecutive integers. Must run in O(n).
 *
 * Pattern: Set-Based Lookups
 *
 * Key insight: only start counting from the beginning of a sequence.
 * A number n is the start of a sequence if (n - 1) is NOT in the set.
 * This ensures each element is visited at most twice across all iterations.
 *
 * Time:  O(n)
 * Space: O(n)
 */
public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int n : nums) numSet.add(n);

        int longest = 0;

        for (int n : numSet) {
            // Skip if n is not the start of a sequence
            if (numSet.contains(n - 1)) continue;

            int length = 1;
            while (numSet.contains(n + length)) length++;

            longest = Math.max(longest, length);
        }

        return longest;
    }

    // -------------------------------------------------------------------------

    public static void main(String[] args) {
        LongestConsecutiveSequence solution = new LongestConsecutiveSequence();

        System.out.println(solution.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2})); // 4  (1,2,3,4)
        System.out.println(solution.longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1})); // 9
    }
}
