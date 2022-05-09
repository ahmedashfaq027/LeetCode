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

    public int findTargetSumWays(int[] nums, int target) {
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
