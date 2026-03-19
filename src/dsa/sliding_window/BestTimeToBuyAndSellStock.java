package dsa.sliding_window;

/**
 * LeetCode 121 — Best Time to Buy and Sell Stock
 *
 * Given daily prices, find the maximum profit from one buy and one sell.
 * You must buy before you sell.
 *
 * Pattern: Single-pass min tracking
 *
 * At each day, the best profit is (today's price - lowest price seen so far).
 * Track both the running minimum and the running maximum profit.
 *
 * Time:  O(n)
 * Space: O(1)
 */
public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else {
                maxProfit = Math.max(maxProfit, price - minPrice);
            }
        }

        return maxProfit;
    }

    // -------------------------------------------------------------------------

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock solution = new BestTimeToBuyAndSellStock();

        System.out.println(solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4})); // 5  (buy at 1, sell at 6)
        System.out.println(solution.maxProfit(new int[]{7, 6, 4, 3, 1}));    // 0  (prices only decrease)
    }
}
