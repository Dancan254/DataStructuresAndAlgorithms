package dsa.dynamic_programming;

import java.util.Arrays;

/**
 * LeetCode 322 — Coin Change
 *
 * Find the minimum number of coins to make the target amount.
 * Return -1 if it is not possible.
 *
 * Pattern: Unbounded knapsack (bottom-up DP)
 *
 * dp[i] = minimum coins to make amount i
 * dp[0] = 0 (base case: 0 coins to make amount 0)
 * dp[i] = min over all coins c where c <= i: dp[i - c] + 1
 *
 * Initialise dp with a sentinel value (amount + 1) larger than any valid answer.
 * If dp[amount] > amount after filling, no solution exists.
 *
 * Time:  O(amount * n) where n = number of coins
 * Space: O(amount)
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1); // sentinel: no valid answer yet
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    // -------------------------------------------------------------------------

    public static void main(String[] args) {
        CoinChange solution = new CoinChange();

        System.out.println(solution.coinChange(new int[]{1, 5, 6, 9}, 11)); // 2 (5+6)
        System.out.println(solution.coinChange(new int[]{2}, 3));            // -1
        System.out.println(solution.coinChange(new int[]{1}, 0));            // 0
    }
}
