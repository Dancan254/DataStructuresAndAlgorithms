package dsa.sliding_window.practice;

/**
 * LeetCode 3 — Longest Substring Without Repeating Characters
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * Given a string, find the length of the longest substring with no repeated characters.
 *
 * Example 1:
 *   Input:  "abcabcbb"
 *   Output: 3   ("abc")
 *
 * Example 2:
 *   Input:  "bbbbb"
 *   Output: 1   ("b")
 *
 * Example 3:
 *   Input:  "pwwkew"
 *   Output: 3   ("wke")
 *
 * Constraints:
 *   - 0 <= s.length <= 5 * 10^4
 *   - s consists of English letters, digits, symbols and spaces
 *
 * Hint: Use a sliding window [lo, hi]. Expand hi every step.
 *       When a duplicate character enters the window, contract lo until it is gone.
 *       Track character frequencies with an int[128] array (ASCII).
 */
public class LongestSubstringWithoutRepeating {

    public int lengthOfLongestSubstring(String s) {
        // TODO: implement your solution
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // -------------------------------------------------------------------------

    public static void main(String[] args) {
        LongestSubstringWithoutRepeating solution = new LongestSubstringWithoutRepeating();

        System.out.println(solution.lengthOfLongestSubstring("abcabcbb")); // 3
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));    // 1
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));   // 3
        System.out.println(solution.lengthOfLongestSubstring(""));         // 0
        System.out.println(solution.lengthOfLongestSubstring(" "));        // 1
    }
}
