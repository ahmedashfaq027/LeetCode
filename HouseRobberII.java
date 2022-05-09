/*

https://leetcode.com/problems/house-robber-ii/

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.
Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

Constraints:
1. 1 <= nums.length <= 100
2. 0 <= nums[i] <= 1000

Input: nums = [2,3,2]
Output: 3
    Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.

Input: nums = [1,2,3,1]
Output: 4
    Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
    Total amount you can rob = 1 + 3 = 4.

Input: nums = [1,2,3]
Output: 3

*/

public class HouseRobberII {
    public static void main(String[] args) {
        HouseRobberII lc = new HouseRobberII();

        System.out.println(lc.rob(new int[]{2, 3, 2}));
        System.out.println(lc.rob(new int[]{1, 2, 3, 1}));
        System.out.println(lc.rob(new int[]{1, 2, 3}));
    }

    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return nums[0];
        }

        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] dp1 = new int[n];
        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n - 1; i++) {
            dp1[i] = Math.max(nums[i] + dp1[i - 2], dp1[i - 1]);
        }

        int[] dp2 = new int[n];
        dp2[1] = nums[1];
        dp2[2] = Math.max(nums[1], nums[2]);
        for (int i = 3; i < n; i++) {
            dp2[i] = Math.max(nums[i] + dp2[i - 2], dp2[i - 1]);
        }

        return Math.max(dp1[n - 2], dp2[n - 1]);
    }
}
