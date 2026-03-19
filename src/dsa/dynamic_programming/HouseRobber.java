package dsa.dynamic_programming;

/**
 * LeetCode 198 — House Robber
 * LeetCode 213 — House Robber II (circular arrangement)
 *
 * Rob the maximum amount without robbing two adjacent houses.
 *
 * Pattern: Linear DP — "include or skip" decision at each element
 *
 * Recurrence: dp[i] = max(dp[i-1], dp[i-2] + nums[i])
 *   - skip house i: best up to i-1 is dp[i-1]
 *   - rob house i:  best up to i-2, plus nums[i]
 *
 * Space-optimised: only the last two dp values are needed.
 *
 * House Robber II: first and last house are adjacent.
 * Solution: run robRange on [0..n-2] and [1..n-1], return the max.
 *
 * Time:  O(n)
 * Space: O(1)
 */
public class HouseRobber {

    // LeetCode 198
    public int rob(int[] nums) {
        return robRange(nums, 0, nums.length - 1);
    }

    // LeetCode 213 — circular
    public int robCircular(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(
            robRange(nums, 0, nums.length - 2),
            robRange(nums, 1, nums.length - 1)
        );
    }

    private int robRange(int[] nums, int start, int end) {
        int prev2 = 0, prev1 = 0;
        for (int i = start; i <= end; i++) {
            int curr = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }

    // -------------------------------------------------------------------------

    public static void main(String[] args) {
        HouseRobber solution = new HouseRobber();

        System.out.println(solution.rob(new int[]{1, 2, 3, 1}));          // 4
        System.out.println(solution.rob(new int[]{2, 7, 9, 3, 1}));       // 12
        System.out.println(solution.robCircular(new int[]{2, 3, 2}));     // 3
        System.out.println(solution.robCircular(new int[]{1, 2, 3, 1}));  // 4
    }
}
