/*

https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

You are given an array prices where prices[i] is the price of a given stock on the ith day.
You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

Constraints:
1. 1 <= prices.length <= 10^5
2. 0 <= prices[i] <= 10^4

Input: prices = [7,1,5,3,6,4]
Output: 5
    Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
    Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

Input: prices = [7,6,4,3,1]
Output: 0
    Explanation: In this case, no transactions are done and the max profit = 0.

*/

public class BestTimetoBuyandSellStock {
    public static void main(String[] args) {
        BestTimetoBuyandSellStock lc = new BestTimetoBuyandSellStock();

        System.out.println(lc.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(lc.maxProfit(new int[]{7, 6, 4, 3, 1}));
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxProfit = Integer.MIN_VALUE, lpsf = Integer.MAX_VALUE;

        for (int price : prices) {
            lpsf = Math.min(lpsf, price);
            int curProf = price - lpsf;
            maxProfit = Math.max(maxProfit, curProf);
        }

        return maxProfit;
    }
}
