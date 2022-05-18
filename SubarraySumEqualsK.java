/*

https://leetcode.com/problems/subarray-sum-equals-k/

Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

Constraints:
1. 1 <= nums.length <= 2 * 104
2. -1000 <= nums[i] <= 1000
3. -107 <= k <= 107

Input: nums = [1,1,1], k = 2
Output: 2

Input: nums = [1,2,3], k = 3
Output: 2

*/

import java.util.HashMap;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        SubarraySumEqualsK lc = new SubarraySumEqualsK();

        System.out.println(lc.subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println(lc.subarraySum(new int[]{1, 2, 3}, 3));
    }

    public int subarraySum(int[] nums, int k) {
        int n = nums.length;

        HashMap<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);

        int currSum = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            currSum += nums[i];

            if (preSum.containsKey(currSum - k)) {
                count += preSum.get(currSum - k);
            }

            preSum.put(currSum, preSum.getOrDefault(currSum, 0) + 1);
        }

        return count;
    }
}
