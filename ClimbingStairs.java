/*

https://leetcode.com/problems/climbing-stairs/

You are climbing a staircase. It takes n steps to reach the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Constraints:
1. 1 <= n <= 45

Input: n = 2
Output: 2
    Explanation: There are two ways to climb to the top.
    1. 1 step + 1 step
    2. 2 steps

Input: n = 3
Output: 3
    Explanation: There are three ways to climb to the top.
    1. 1 step + 1 step + 1 step
    2. 1 step + 2 steps
    3. 2 steps + 1 step

*/

public class ClimbingStairs {
    public static void main(String[] args) {
        ClimbingStairs lc = new ClimbingStairs();

        System.out.println(lc.climbStairs(2));
        System.out.println(lc.climbStairs(3));
    }

    /*
        Explanation:
            DP Equation: dp[i] = dp[i-1] + dp[i-2]
            Base cases: dp[0] = 1, dp[1] = 1
    */
    public int climbStairs(int n) {
        int[] dp = new int[n + 1 + 1]; // +1 to be Null Safe
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
