package dsa.dynamic_programming.practice;

/**
 * LeetCode 300 — Longest Increasing Subsequence
 * https://leetcode.com/problems/longest-increasing-subsequence/
 *
 * Given an integer array, return the length of the longest strictly increasing
 * subsequence (elements do not need to be contiguous).
 *
 * Example 1:
 *   Input:  [10, 9, 2, 5, 3, 7, 101, 18]
 *   Output: 4   (2, 3, 7, 101 or 2, 5, 7, 101)
 *
 * Example 2:
 *   Input:  [0, 1, 0, 3, 2, 3]
 *   Output: 4
 *
 * Example 3:
 *   Input:  [7, 7, 7, 7, 7]
 *   Output: 1
 *
 * Constraints:
 *   - 1 <= nums.length <= 2500
 *   - -10^4 <= nums[i] <= 10^4
 *
 * Hint (O(n²) approach):
 *   dp[i] = length of LIS ending at index i.
 *   For each i, check all j < i: if nums[j] < nums[i], then dp[i] = max(dp[i], dp[j]+1).
 *   Initialise all dp[i] = 1 (every single element is a valid LIS of length 1).
 *   Return the maximum value in dp.
 */
public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        // TODO: implement your solution
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // -------------------------------------------------------------------------

    public static void main(String[] args) {
        LongestIncreasingSubsequence solution = new LongestIncreasingSubsequence();

        System.out.println(solution.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18})); // 4
        System.out.println(solution.lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));           // 4
        System.out.println(solution.lengthOfLIS(new int[]{7, 7, 7, 7, 7}));              // 1
        System.out.println(solution.lengthOfLIS(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6}));// 6
    }
}
