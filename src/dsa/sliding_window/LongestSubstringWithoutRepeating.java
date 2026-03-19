package dsa.sliding_window;

/**
 * LeetCode 3 — Longest Substring Without Repeating Characters
 *
 * Find the length of the longest substring with all unique characters.
 *
 * Pattern: Variable-size window with character frequency tracking
 *
 * Expand hi every step. When a duplicate enters, contract lo until it is gone.
 *
 * Time:  O(n)
 * Space: O(1) — frequency array bounded by ASCII size
 */
public class LongestSubstringWithoutRepeating {

    public int lengthOfLongestSubstring(String s) {
        int[] count = new int[128]; // frequency of each ASCII character in window
        int lo = 0, maxLen = 0;

        for (int hi = 0; hi < s.length(); hi++) {
            char c = s.charAt(hi);
            count[c]++;

            // Shrink from left until the character at hi appears only once
            while (count[c] > 1) {
                count[s.charAt(lo)]--;
                lo++;
            }

            maxLen = Math.max(maxLen, hi - lo + 1);
        }

        return maxLen;
    }

    // -------------------------------------------------------------------------

    public static void main(String[] args) {
        LongestSubstringWithoutRepeating solution = new LongestSubstringWithoutRepeating();

        System.out.println(solution.lengthOfLongestSubstring("abcabcbb")); // 3 ("abc")
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));    // 1 ("b")
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));   // 3 ("wke")
        System.out.println(solution.lengthOfLongestSubstring(""));         // 0
    }
}
