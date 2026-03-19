package dsa.arrays_hashing.practice;

/**
 * LeetCode 242 — Valid Anagram
 * https://leetcode.com/problems/valid-anagram/
 *
 * Given two strings s and t, return true if t is an anagram of s.
 * An anagram uses the same characters with the same frequencies.
 *
 * Example 1:
 *   Input:  s = "anagram", t = "nagaram"
 *   Output: true
 *
 * Example 2:
 *   Input:  s = "rat", t = "car"
 *   Output: false
 *
 * Constraints:
 *   - 1 <= s.length, t.length <= 5 * 10^4
 *   - s and t consist of lowercase English letters
 *
 * Hint: If two strings are anagrams, what must be true about their character
 *       frequencies? A fixed-size int[26] array is faster than a HashMap here.
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        // TODO: implement your solution
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // -------------------------------------------------------------------------

    public static void main(String[] args) {
        ValidAnagram solution = new ValidAnagram();

        System.out.println(solution.isAnagram("anagram", "nagaram")); // true
        System.out.println(solution.isAnagram("rat", "car"));         // false
        System.out.println(solution.isAnagram("a", "a"));             // true
        System.out.println(solution.isAnagram("ab", "a"));            // false
    }
}
