package dsa.sliding_window.practice;

/**
 * LeetCode 121 — Best Time to Buy and Sell Stock
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 *
 * Given an array of daily prices, return the maximum profit from a single
 * buy and sell. You must buy before you sell. Return 0 if no profit is possible.
 *
 * Example 1:
 *   Input:  [7, 1, 5, 3, 6, 4]
 *   Output: 5   (buy at 1, sell at 6)
 *
 * Example 2:
 *   Input:  [7, 6, 4, 3, 1]
 *   Output: 0   (prices only decrease)
 *
 * Constraints:
 *   - 1 <= prices.length <= 10^5
 *   - 0 <= prices[i] <= 10^4
 *
 * Hint: As you scan left to right, track the minimum price seen so far.
 *       At each day, the best profit if you sell today is (today - min so far).
 *       Track both the running minimum and the running maximum profit.
 */
public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        // TODO: implement your solution
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // -------------------------------------------------------------------------

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock solution = new BestTimeToBuyAndSellStock();

        System.out.println(solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4})); // 5
        System.out.println(solution.maxProfit(new int[]{7, 6, 4, 3, 1}));    // 0
        System.out.println(solution.maxProfit(new int[]{1, 2}));              // 1
        System.out.println(solution.maxProfit(new int[]{2, 1, 2, 1, 0, 1, 2})); // 2
    }
}
