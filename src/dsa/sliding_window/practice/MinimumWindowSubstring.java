package dsa.sliding_window.practice;

/**
 * LeetCode 76 — Minimum Window Substring
 * https://leetcode.com/problems/minimum-window-substring/
 *
 * Find the smallest substring of s that contains all characters of t.
 * Return "" if no such substring exists.
 *
 * Example 1:
 *   Input:  s = "ADOBECODEBANC", t = "ABC"
 *   Output: "BANC"
 *
 * Example 2:
 *   Input:  s = "a", t = "a"
 *   Output: "a"
 *
 * Example 3:
 *   Input:  s = "a", t = "aa"
 *   Output: ""
 *
 * Constraints:
 *   - 1 <= s.length <= 10^5
 *   - 1 <= t.length <= 10^4
 *   - s and t consist of uppercase and lowercase English letters
 *
 * Hint: Use a need[] array (indexed by ASCII) for required character counts.
 *       Track `formed` = how many required characters are currently satisfied.
 *       Expand hi until formed == t.length(), then contract lo to minimise.
 *       A character contributes to `formed` only when need[c] goes from 1 to 0.
 */
public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        // TODO: implement your solution
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // -------------------------------------------------------------------------

    public static void main(String[] args) {
        MinimumWindowSubstring solution = new MinimumWindowSubstring();

        System.out.println(solution.minWindow("ADOBECODEBANC", "ABC")); // "BANC"
        System.out.println(solution.minWindow("a", "a"));               // "a"
        System.out.println(solution.minWindow("a", "aa"));              // ""
        System.out.println(solution.minWindow("aa", "aa"));             // "aa"
    }
}
