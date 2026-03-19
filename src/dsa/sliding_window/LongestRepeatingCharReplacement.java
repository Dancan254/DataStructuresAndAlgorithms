package dsa.sliding_window;

/**
 * LeetCode 424 — Longest Repeating Character Replacement
 *
 * Given a string and integer k, you may replace at most k characters with any
 * letter. Return the length of the longest substring containing one repeated letter.
 *
 * Pattern: Variable-size window with frequency tracking
 *
 * A window [lo, hi] is valid when:
 *   (hi - lo + 1) - maxFreq <= k
 * where maxFreq is the count of the most frequent character in the window.
 *
 * Key insight: we never need to shrink maxFreq. If a future window can beat the
 * current best length, it needs a higher maxFreq — so we only update maxFreq upward.
 *
 * Time:  O(n)
 * Space: O(1)
 */
public class LongestRepeatingCharReplacement {

    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int lo = 0, maxFreq = 0, maxLen = 0;

        for (int hi = 0; hi < s.length(); hi++) {
            int idx = s.charAt(hi) - 'A';
            count[idx]++;
            maxFreq = Math.max(maxFreq, count[idx]);

            // Number of characters we need to replace in this window
            int replacementsNeeded = (hi - lo + 1) - maxFreq;
            if (replacementsNeeded > k) {
                // Shrink by one — we never need to shrink more since we only
                // grow the window when we can beat the current best length
                count[s.charAt(lo) - 'A']--;
                lo++;
            }

            maxLen = Math.max(maxLen, hi - lo + 1);
        }

        return maxLen;
    }

    // -------------------------------------------------------------------------

    public static void main(String[] args) {
        LongestRepeatingCharReplacement solution = new LongestRepeatingCharReplacement();

        System.out.println(solution.characterReplacement("ABAB", 2));    // 4
        System.out.println(solution.characterReplacement("AABABBA", 1)); // 4
    }
}
