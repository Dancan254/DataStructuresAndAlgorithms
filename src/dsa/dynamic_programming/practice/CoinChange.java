package dsa.dynamic_programming.practice;

/**
 * LeetCode 322 — Coin Change
 * https://leetcode.com/problems/coin-change/
 *
 * Given an array of coin denominations and a target amount, return the minimum
 * number of coins needed to make the amount. Return -1 if it is not possible.
 * You have an unlimited supply of each denomination.
 *
 * Example 1:
 *   Input:  coins = [1,5,6,9], amount = 11
 *   Output: 2   (5+6)
 *
 * Example 2:
 *   Input:  coins = [2], amount = 3
 *   Output: -1
 *
 * Example 3:
 *   Input:  coins = [1], amount = 0
 *   Output: 0
 *
 * Constraints:
 *   - 1 <= coins.length <= 12
 *   - 1 <= coins[i] <= 2^31 - 1
 *   - 0 <= amount <= 10^4
 *
 * Hint: Build a dp array where dp[i] = minimum coins to make amount i.
 *       dp[0] = 0 (base case).
 *       For each amount i, try every coin: dp[i] = min(dp[i], dp[i - coin] + 1).
 *       Initialise dp with a sentinel larger than any valid answer (amount + 1).
 *       After filling, if dp[amount] > amount, return -1.
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        // TODO: implement your solution
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // -------------------------------------------------------------------------

    public static void main(String[] args) {
        CoinChange solution = new CoinChange();

        System.out.println(solution.coinChange(new int[]{1, 5, 6, 9}, 11)); // 2
        System.out.println(solution.coinChange(new int[]{2}, 3));            // -1
        System.out.println(solution.coinChange(new int[]{1}, 0));            // 0
        System.out.println(solution.coinChange(new int[]{1, 2, 5}, 11));     // 3  (5+5+1)
    }
}
