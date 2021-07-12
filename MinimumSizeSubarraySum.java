/*

https://leetcode.com/problems/minimum-size-subarray-sum/

Given an array of positive integers nums and a positive integer target, return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target. If there is no such subarray, return 0 instead.

Constraints:
1. 1 <= target <= 109
2. 1 <= nums.length <= 105
3. 1 <= nums[i] <= 105

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
    Explanation: The subarray [4,3] has the minimal length under the problem constraint.

Input: target = 4, nums = [1,4,4]
Output: 1

Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0

Follow up: If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log(n)).

*/

import java.util.Arrays;
import java.util.Collections;

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        MinimumSizeSubarraySum lc = new MinimumSizeSubarraySum();

        System.out.println(lc.minSubArrayLenOptimised(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(lc.minSubArrayLenOptimised(4, new int[]{1, 4, 4}));
        System.out.println(lc.minSubArrayLenOptimised(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}));
        System.out.println(lc.minSubArrayLenOptimised(11, new int[]{1, 2, 3, 4, 5}));
        System.out.println(lc.minSubArrayLenOptimised(15, new int[]{1, 2, 3, 4, 5}));
    }

    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left = 0, ans = n + 1;

        int currSum = 0;
        for (int i = 0; i < n; i++) {
            currSum += nums[i];

            while (currSum >= target) {
                ans = Math.min(ans, i - left + 1);
                currSum -= nums[left++];
            }
        }


        return (ans == n + 1) ? 0 : ans;
    }

    public int minSubArrayLenOptimised(int target, int[] nums) {
        int n = nums.length;

        for (int num : nums) {
            if (num > target)
                return 1;
        }

        int[] cs = new int[n + 1];
        cs[0] = 0;
        int ans = n + 1, currSum = 0;
        for (int i = 0; i < n; i++) {
            currSum += nums[i];

            if (currSum >= target) {
                int q = currSum - target;
                int left = binarySearchFloor(cs, 0, i, q);

                if (left != -1) {
                    ans = Math.min(ans, i - left + 1);
                }
            }

            cs[i + 1] = currSum;
        }

        return (ans == n + 1) ? 0 : ans;
    }

    private int binarySearchFloor(int[] ar, int lo, int hi, int key) {
        int ans = -1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (ar[mid] == key)
                return mid;

            if (ar[mid] < key) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return ans;
    }
}
