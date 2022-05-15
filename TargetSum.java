/*

https://leetcode.com/problems/target-sum/

You are given an integer array nums and an integer target.
You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.

For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
Return the number of different expressions that you can build, which evaluates to target.

Constraints:
1. 1 <= nums.length <= 20
2. 0 <= nums[i] <= 1000
3. 0 <= sum(nums[i]) <= 1000
4. -1000 <= target <= 1000

Input: nums = [1,1,1,1,1], target = 3
Output: 5
    Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
    -1 + 1 + 1 + 1 + 1 = 3
    +1 - 1 + 1 + 1 + 1 = 3
    +1 + 1 - 1 + 1 + 1 = 3
    +1 + 1 + 1 - 1 + 1 = 3
    +1 + 1 + 1 + 1 - 1 = 3

Input: nums = [1], target = 1
Output: 1

*/

public class TargetSum {
    public static void main(String[] args) {
        TargetSum lc = new TargetSum();

        System.out.println(lc.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
        System.out.println(lc.findTargetSumWays(new int[]{1}, 1));
    }

    /*
        Explanation:
            0/1 Knapsack problem
    */
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;

        int sum = 0;
        for (int x : nums) {
            sum += x;
        }

        if (Math.abs(target) > sum)
            return 0;

        if ((target + sum) % 2 != 0)
            return 0;

        int S = (sum + target) / 2;

        int[][] dp = new int[n + 1][S + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < S + 1; j++) {
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][S];
    }

    public int findTargetSumWaysBackTrack(int[] nums, int target) {
        return findCount(nums, target, 0, 0);
    }

    private int findCount(int[] nums, int target, int idx, int currSum) {
        int n = nums.length;

        if (idx == n) {
            return currSum == target ? 1 : 0;
        }

        return findCount(nums, target, idx + 1, currSum - nums[idx]) + findCount(nums, target, idx + 1, currSum + nums[idx]);
    }
}
