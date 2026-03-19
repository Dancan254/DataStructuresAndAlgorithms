package dsa.arrays.practice;

public class BuySellStocks {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int profit = maxProfit(prices);
        System.out.println("Max profit is: " + profit);
    }

    public static int maxProfit(int[] prices) {
        // 7, 1, 5, 3, 6, 4
        int minPrice = prices[0];
        int profit = 0;
        int length = prices.length;
        for (int i = 1; i < length; i++) {
            if (prices[i] < minPrice){
                minPrice = prices[i];
            }
            int resultProfit = prices[i] - minPrice;
            profit = Math.max(profit, resultProfit);
        }
        return profit;
    }
}
