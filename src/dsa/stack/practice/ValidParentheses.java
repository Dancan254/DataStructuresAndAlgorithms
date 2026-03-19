package dsa.stack.practice;

/**
 * LeetCode 20 — Valid Parentheses
 * https://leetcode.com/problems/valid-parentheses/
 *
 * Given a string containing only '(', ')', '{', '}', '[', ']',
 * determine if the input string is valid.
 *
 * A string is valid when:
 *   1. Open brackets are closed by the same type of bracket.
 *   2. Open brackets are closed in the correct order.
 *   3. Every close bracket has a corresponding open bracket.
 *
 * Example 1:
 *   Input:  "()"
 *   Output: true
 *
 * Example 2:
 *   Input:  "()[]{}"
 *   Output: true
 *
 * Example 3:
 *   Input:  "(]"
 *   Output: false
 *
 * Constraints:
 *   - 1 <= s.length <= 10^4
 *   - s consists of parentheses characters only
 *
 * Hint: Push opening brackets onto a stack.
 *       When you encounter a closing bracket, check the stack top.
 *       What should the final state of the stack be for a valid string?
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        // TODO: implement your solution
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // -------------------------------------------------------------------------

    public static void main(String[] args) {
        ValidParentheses solution = new ValidParentheses();

        System.out.println(solution.isValid("()"));        // true
        System.out.println(solution.isValid("()[]{}"));    // true
        System.out.println(solution.isValid("(]"));        // false
        System.out.println(solution.isValid("([])"));      // true
        System.out.println(solution.isValid("{[]}"));      // true
        System.out.println(solution.isValid("((("));       // false
        System.out.println(solution.isValid("]"));         // false
    }
}
