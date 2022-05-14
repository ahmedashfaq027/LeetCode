/*

https://leetcode.com/problems/subarray-product-less-than-k/

Given an array of integers nums and an integer k, return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than k.

Constraints:
1. 1 <= nums.length <= 3 * 104
2. 1 <= nums[i] <= 1000
3. 0 <= k <= 106

Input: nums = [10,5,2,6], k = 100
Output: 8
    Explanation: The 8 subarrays that have product less than 100 are:
    [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
    Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.

Input: nums = [1,2,3], k = 0
Output: 0

*/

public class SubarrayProductLessThanK {
    public static void main(String[] args) {
        SubarrayProductLessThanK lc = new SubarrayProductLessThanK();

        System.out.println(lc.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
        System.out.println(lc.numSubarrayProductLessThanK(new int[]{1, 2, 3}, 0));
        System.out.println(lc.numSubarrayProductLessThanK(new int[]{10, 9, 10, 4, 3, 8, 3, 3, 6, 2, 10, 10, 9, 3}, 19));
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;

        int res = 0;
        for (int i = 0; i < n; i++) {
            int tmp = 1;
            for (int j = i; j < n; j++) {
                tmp *= nums[j];

                if (tmp < k)
                    res++;
                else
                    break;
            }
        }

        return res;
    }
}
