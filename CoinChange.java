/*

https://leetcode.com/problems/coin-change/

You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
You may assume that you have an infinite number of each kind of coin.

Constraints:
1. 1 <= coins.length <= 12
2. 1 <= coins[i] <= 231 - 1
3. 0 <= amount <= 104

Input: coins = [1,2,5], amount = 11
Output: 3
    Explanation: 11 = 5 + 5 + 1

Input: coins = [2], amount = 3
Output: -1

Input: coins = [1], amount = 0
Output: 0

*/

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        CoinChange lc = new CoinChange();

        System.out.println(lc.coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(lc.coinChange(new int[]{2}, 3));
        System.out.println(lc.coinChange(new int[]{1}, 0));
    }

    /*
        Explanation:
            DP Equation: dp[i] = min(dp[i], 1 + dp[i - c]) for (i >= c) where c is coin value.
            Base cases: dp[0] = 0, dp[1:] = INFINITY
    */
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);

        dp[0] = 0;
        for (int c : coins) {
            for (int i = 1; i < amount + 1; i++) {
                if (i >= c)
                    dp[i] = Math.min(dp[i], 1 + dp[i - c]);
            }
        }

        return dp[amount] == Integer.MAX_VALUE - 1 ? -1 : dp[amount];
    }
}
