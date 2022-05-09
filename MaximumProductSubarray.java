/*

https://leetcode.com/problems/maximum-product-subarray/

Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.
The test cases are generated so that the answer will fit in a 32-bit integer.
A subarray is a contiguous subsequence of the array.

Constraints:
1. 1 <= nums.length <= 2 * 104
2. -10 <= nums[i] <= 10
3. The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

Input: nums = [2,3,-2,4]
Output: 6
    Explanation: [2,3] has the largest product 6.

Input: nums = [-2,0,-1]
Output: 0
    Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

*/

import java.util.Arrays;

public class MaximumProductSubarray {
    public static void main(String[] args) {
        MaximumProductSubarray lc = new MaximumProductSubarray();

        System.out.println(lc.maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(lc.maxProduct(new int[]{-2, 0, -1}));
        System.out.println(lc.maxProduct(new int[]{-2, 3, -4}));
        System.out.println(lc.maxProduct(new int[]{-2, -3, -4}));
        System.out.println(lc.maxProduct(new int[]{-1, -2, -9, -6}));
    }

    public int maxProduct(int[] nums) {
        int n = nums.length;

        // max, min, ans
        int[] res = new int[3];
        Arrays.fill(res, nums[0]);
        for (int i = 1; i < n; i++) {
            int tmp = res[0];

            res[0] = max3(res[0] * nums[i], res[1] * nums[i], nums[i]);
            res[1] = min3(tmp * nums[i], res[1] * nums[i], nums[i]);

            res[2] = Math.max(res[2], res[0]);
        }

        return res[2];
    }

    private int max3(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    private int min3(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
