package dsa.sliding_window;

/**
 * LeetCode 76 — Minimum Window Substring
 *
 * Find the smallest substring of s that contains all characters of t.
 * Return "" if no such window exists.
 *
 * Pattern: Minimum covering window
 *
 * Use a need[] array to track how many of each character are still required.
 * Track `formed` = how many characters from t are currently satisfied.
 * Expand hi until all are satisfied, then contract lo to minimise the window.
 *
 * Time:  O(n + m) where n = |s|, m = |t|
 * Space: O(1) — arrays bounded by ASCII size
 */
public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        int[] need = new int[128];
        for (char c : t.toCharArray()) need[c]++;

        int lo = 0;
        int required = t.length(); // total characters still needed
        int formed = 0;            // characters currently satisfied
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;

        for (int hi = 0; hi < s.length(); hi++) {
            char c = s.charAt(hi);
            // Only counts toward coverage when we still need this character
            if (need[c] > 0) formed++;
            need[c]--;

            // All required characters covered — try to shrink the window
            while (formed == required) {
                if (hi - lo + 1 < minLen) {
                    minLen = hi - lo + 1;
                    minStart = lo;
                }
                char left = s.charAt(lo);
                need[left]++;
                // Removing this character breaks coverage
                if (need[left] > 0) formed--;
                lo++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }

    // -------------------------------------------------------------------------

    public static void main(String[] args) {
        MinimumWindowSubstring solution = new MinimumWindowSubstring();

        System.out.println(solution.minWindow("ADOBECODEBANC", "ABC")); // "BANC"
        System.out.println(solution.minWindow("a", "a"));               // "a"
        System.out.println(solution.minWindow("a", "aa"));              // ""
    }
}
