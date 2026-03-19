package dsa.dynamic_programming.practice;

/**
 * LeetCode 70 — Climbing Stairs
 * https://leetcode.com/problems/climbing-stairs/
 *
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can climb 1 or 2 steps. How many distinct ways can you climb?
 *
 * Example 1:
 *   Input:  n = 2
 *   Output: 2   (1+1, or 2)
 *
 * Example 2:
 *   Input:  n = 3
 *   Output: 3   (1+1+1, 1+2, 2+1)
 *
 * Constraints:
 *   - 1 <= n <= 45
 *
 * Hint: To reach step n, you must have come from step n-1 or step n-2.
 *       So ways(n) = ways(n-1) + ways(n-2).
 *       Base cases: ways(1) = 1, ways(2) = 2.
 *       You only need the previous two values — O(1) space is achievable.
 */
public class ClimbingStairs {

    public int climbStairs(int n) {
        // TODO: implement your solution
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // -------------------------------------------------------------------------

    public static void main(String[] args) {
        ClimbingStairs solution = new ClimbingStairs();

        System.out.println(solution.climbStairs(1));  // 1
        System.out.println(solution.climbStairs(2));  // 2
        System.out.println(solution.climbStairs(3));  // 3
        System.out.println(solution.climbStairs(5));  // 8
        System.out.println(solution.climbStairs(10)); // 89
    }
}
