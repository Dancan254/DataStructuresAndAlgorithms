package dsa.dynamic_programming.practice;

/**
 * LeetCode 198 — House Robber
 * https://leetcode.com/problems/house-robber/
 *
 * You are a robber. Adjacent houses have a security system — robbing two
 * adjacent houses triggers an alarm. Given house values, return the maximum
 * amount you can rob without triggering the alarm.
 *
 * Example 1:
 *   Input:  [1, 2, 3, 1]
 *   Output: 4   (rob house 0 and house 2: 1+3)
 *
 * Example 2:
 *   Input:  [2, 7, 9, 3, 1]
 *   Output: 12  (rob house 0, 2, and 4: 2+9+1)
 *
 * Constraints:
 *   - 1 <= nums.length <= 100
 *   - 0 <= nums[i] <= 400
 *
 * Hint: At each house you have two choices:
 *   - Skip it: best amount is whatever you had at the previous house.
 *   - Rob it:  best amount is nums[i] + whatever you had two houses ago.
 *   dp[i] = max(dp[i-1], dp[i-2] + nums[i])
 *   You only need the previous two dp values, so you can use O(1) space.
 */
public class HouseRobber {

    // LeetCode 198 — linear arrangement
    public int rob(int[] nums) {
        // TODO: implement your solution
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // LeetCode 213 — circular arrangement (first and last house are adjacent)
    // Hint: Run rob() on nums[0..n-2] and nums[1..n-1]. Take the maximum.
    public int robCircular(int[] nums) {
        // TODO: implement your solution
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // -------------------------------------------------------------------------

    public static void main(String[] args) {
        HouseRobber solution = new HouseRobber();

        // House Robber I
        System.out.println(solution.rob(new int[]{1, 2, 3, 1}));    // 4
        System.out.println(solution.rob(new int[]{2, 7, 9, 3, 1})); // 12

        // House Robber II
        System.out.println(solution.robCircular(new int[]{2, 3, 2}));     // 3
        System.out.println(solution.robCircular(new int[]{1, 2, 3, 1}));  // 4
        System.out.println(solution.robCircular(new int[]{1, 2, 3}));     // 3
    }
}
