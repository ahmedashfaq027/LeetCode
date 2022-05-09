/*

https://leetcode.com/problems/maximum-product-of-three-numbers/

Given an integer array nums, find three numbers whose product is maximum and return the maximum product.

Constraints:
1. 3 <= nums.length <= 104
2. -1000 <= nums[i] <= 1000

Input: nums = [1,2,3]
Output: 6

Input: nums = [1,2,3,4]
Output: 24

Input: nums = [-1,-2,-3]
Output: -6

*/

import java.util.Arrays;

public class MaximumProductofThreeNumbers {
    public static void main(String[] args) {
        MaximumProductofThreeNumbers lc = new MaximumProductofThreeNumbers();

        System.out.println(lc.maximumProduct(new int[]{1, 2, 3}));
        System.out.println(lc.maximumProduct(new int[]{1, 2, 3, 4}));
        System.out.println(lc.maximumProduct(new int[]{-1, -2, -3}));
        System.out.println(lc.maximumProduct(new int[]{-100, -98, -1, 2, 3, 4}));
    }

    public int maximumProduct(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);
        int left = nums[0] * nums[1] * nums[n - 1];
        int right = nums[n - 1] * nums[n - 2] * nums[n - 3];

        return Math.max(left, right);
    }
}
