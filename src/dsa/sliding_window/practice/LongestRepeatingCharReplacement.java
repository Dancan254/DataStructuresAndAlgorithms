package dsa.sliding_window.practice;

/**
 * LeetCode 424 — Longest Repeating Character Replacement
 * https://leetcode.com/problems/longest-repeating-character-replacement/
 *
 * Given a string of uppercase letters and integer k, you may replace at most k
 * characters with any letter. Return the length of the longest substring that
 * contains only one repeated letter after the replacements.
 *
 * Example 1:
 *   Input:  s = "ABAB", k = 2
 *   Output: 4   (replace both A's or both B's)
 *
 * Example 2:
 *   Input:  s = "AABABBA", k = 1
 *   Output: 4
 *
 * Constraints:
 *   - 1 <= s.length <= 10^5
 *   - s consists of uppercase English letters
 *   - 0 <= k <= s.length
 *
 * Hint: A window [lo, hi] is valid when (window size - count of most frequent char) <= k.
 *       The characters that are NOT the most frequent one are what you replace.
 *       Key insight: maxFreq never needs to decrease — can you explain why?
 */
public class LongestRepeatingCharReplacement {

    public int characterReplacement(String s, int k) {
        // TODO: implement your solution
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // -------------------------------------------------------------------------

    public static void main(String[] args) {
        LongestRepeatingCharReplacement solution = new LongestRepeatingCharReplacement();

        System.out.println(solution.characterReplacement("ABAB", 2));    // 4
        System.out.println(solution.characterReplacement("AABABBA", 1)); // 4
        System.out.println(solution.characterReplacement("AAAA", 0));    // 4
        System.out.println(solution.characterReplacement("ABCD", 0));    // 1
    }
}
