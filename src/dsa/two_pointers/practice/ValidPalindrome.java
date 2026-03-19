package dsa.two_pointers.practice;

/**
 * LeetCode 125 — Valid Palindrome
 * https://leetcode.com/problems/valid-palindrome/
 *
 * A phrase is a palindrome if, after converting all uppercase letters to
 * lowercase and removing all non-alphanumeric characters, it reads the same
 * forward and backward.
 *
 * Example 1:
 *   Input:  "A man, a plan, a canal: Panama"
 *   Output: true   ("amanaplanacanalpanama")
 *
 * Example 2:
 *   Input:  "race a car"
 *   Output: false  ("raceacar")
 *
 * Example 3:
 *   Input:  " "
 *   Output: true   (empty after filtering)
 *
 * Constraints:
 *   - 1 <= s.length <= 2 * 10^5
 *   - s consists of printable ASCII characters
 *
 * Hint: Place one pointer at the start and one at the end.
 *       Skip non-alphanumeric characters on both sides.
 *       Use Character.isLetterOrDigit() and Character.toLowerCase().
 */
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        // TODO: implement your solution
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // -------------------------------------------------------------------------

    public static void main(String[] args) {
        ValidPalindrome solution = new ValidPalindrome();

        System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama")); // true
        System.out.println(solution.isPalindrome("race a car"));                      // false
        System.out.println(solution.isPalindrome(" "));                               // true
        System.out.println(solution.isPalindrome("0P"));                              // false
    }
}
