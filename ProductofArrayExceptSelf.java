/*

https://leetcode.com/problems/product-of-array-except-self/

Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
You must write an algorithm that runs in O(n) time and without using the division operation.

Constraints:
1. 2 <= nums.length <= 105
2. -30 <= nums[i] <= 30
3. The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)

Input: nums = [1,2,3,4]
Output: [24,12,8,6]

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]

*/

import java.util.Arrays;

public class ProductofArrayExceptSelf {
    public static void main(String[] args) {
        ProductofArrayExceptSelf lc = new ProductofArrayExceptSelf();

        System.out.println(Arrays.toString(lc.productExceptSelf(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(lc.productExceptSelf(new int[]{-1, 1, 0, -3, 3})));
    }

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] res = new int[n];
        res[0] = 1;
        res[n - 1] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        int rightPro = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            res[i] = res[i] * rightPro;
            rightPro *= nums[i];
        }

        return res;
    }

    public int[] productExceptSelfDiv(int[] nums) {
        int n = nums.length;

        int[] res = new int[n];
        int product = 1, zeros = 0;
        for (int num : nums) {
            if (num == 0) {
                zeros++;
                continue;
            }

            product *= num;
        }

        if (zeros > 1)
            return res;

        for (int i = 0; i < n; i++) {
            if (zeros == 0)
                res[i] = product / nums[i];
            else if (nums[i] == 0) {
                res[i] = product;
                break;
            }
        }

        return res;
    }
}
