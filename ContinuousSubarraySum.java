/*

https://leetcode.com/problems/continuous-subarray-sum/

Given an integer array nums and an integer k, return true if nums has a continuous subarray of size at least two whose elements sum up to a multiple of k, or false otherwise.
An integer x is a multiple of k if there exists an integer n such that x = n * k. 0 is always a multiple of k.

Constraints:
1. 1 <= nums.length <= 105
2. 0 <= nums[i] <= 109
3. 0 <= sum(nums[i]) <= 231 - 1
4. 1 <= k <= 231 - 1

Input: nums = [23,2,4,6,7], k = 6
Output: true
    Explanation: [2, 4] is a continuous subarray of size 2 whose elements sum up to 6.

Input: nums = [23,2,6,4,7], k = 6
Output: true
    Explanation: [23, 2, 6, 4, 7] is an continuous subarray of size 5 whose elements sum up to 42.
    42 is a multiple of 6 because 42 = 7 * 6 and 7 is an integer.

Input: nums = [23,2,6,4,7], k = 13
Output: false

*/

import java.util.HashMap;

public class ContinuousSubarraySum {
    public static void main(String[] args) {
        ContinuousSubarraySum lc = new ContinuousSubarraySum();

        System.out.println(lc.checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 6));
        System.out.println(lc.checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 6));
        System.out.println(lc.checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 13));
        System.out.println(lc.checkSubarraySum(new int[]{23, 2, 4, 6, 6}, 7));
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;

        HashMap<Integer, Integer> visited = new HashMap<>();
        int currSum = 0, prev = 0;

        for (int i = 0; i < n; i++) {
            currSum += nums[i];

            if (i != 0 && currSum % k == 0)
                return true;

            if (visited.containsKey(currSum % k)) {
                if ((i - visited.get(currSum % k)) > 1)
                    return true;
            } else {
                visited.put(currSum % k, i);
            }
        }

        return false;
    }
}
