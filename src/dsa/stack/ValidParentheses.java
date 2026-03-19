package dsa.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode 20 — Valid Parentheses
 *
 * Determine if a string of brackets is valid. A string is valid when:
 *   - Open brackets are closed by the same type of bracket.
 *   - Open brackets are closed in the correct order.
 *   - Every close bracket has a corresponding open bracket.
 *
 * Pattern: Matching / Validity
 *
 * Push openers. On a closer, the stack top must be the matching opener.
 * If the stack is empty at end, every opener was matched.
 *
 * Time:  O(n)
 * Space: O(n)
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if (c == ')' && top != '(') return false;
                if (c == '}' && top != '{') return false;
                if (c == ']' && top != '[') return false;
            }
        }

        return stack.isEmpty();
    }

    // -------------------------------------------------------------------------

    public static void main(String[] args) {
        ValidParentheses solution = new ValidParentheses();

        System.out.println(solution.isValid("()"));       // true
        System.out.println(solution.isValid("()[]{}"));   // true
        System.out.println(solution.isValid("(]"));       // false
        System.out.println(solution.isValid("([])"));     // true
        System.out.println(solution.isValid("{[]}"));     // true
        System.out.println(solution.isValid("((("));      // false
    }
}
