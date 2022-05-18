/*

https://leetcode.com/problems/combination-sum-iv/

Given an array of distinct integers nums and a target integer target, return the number of possible combinations that add up to target.
The answer is guaranteed to fit in a 32-bit integer.

Constraints:
1. 1 <= nums.length <= 200
2. 1 <= nums[i] <= 1000
3. All the elements of nums are unique.
4. 1 <= target <= 1000

Follow up: What if negative numbers are allowed in the given array? How does it change the problem? What limitation we need to add to the question to allow negative numbers?

Input: nums = [1,2,3], target = 4
Output: 7
    Explanation:
    The possible combination ways are:
    (1, 1, 1, 1)
    (1, 1, 2)
    (1, 2, 1)
    (1, 3)
    (2, 1, 1)
    (2, 2)
    (3, 1)
    Note that different sequences are counted as different combinations.

Input: nums = [9], target = 3
Output: 0

*/

import java.util.Arrays;

public class CombinationSumIV {
    public static void main(String[] args) {
        CombinationSumIV lc = new CombinationSumIV();

        System.out.println(lc.combinationSum4(new int[]{1, 2, 3}, 4));
        System.out.println(lc.combinationSum4(new int[]{9}, 3));
    }

    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[target + 1];

        dp[0] = 1;
        for (int j = 1; j < target + 1; j++) {
            for (int num : nums) {
                if (j >= num) {
                    dp[j] += dp[j - num];
                }
            }
        }

        return dp[target];
    }

    public int combinationSum4Backtrack(int[] nums, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        return dfs(nums, target, dp);
    }

    private int dfs(int[] nums, int target, int[] dp) {
        if (target == 0) {
            return 1;
        } else if (target < 0) {
            return 0;
        }

        if (dp[target] != -1) {
            return dp[target];
        }

        int n = nums.length;
        dp[target] = 0;
        for (int num : nums) {
            dp[target] += dfs(nums, target - num, dp);
        }

        return dp[target];
    }
}
