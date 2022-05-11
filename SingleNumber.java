/*

https://leetcode.com/problems/single-number/

Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
You must implement a solution with a linear runtime complexity and use only constant extra space.

Constraints:
1. 1 <= nums.length <= 3 * 104
2. -3 * 104 <= nums[i] <= 3 * 104
3. Each element in the array appears twice except for one element which appears only once.

Input: nums = [2,2,1]
Output: 1

Input: nums = [4,1,2,1,2]
Output: 4

Input: nums = [1]
Output: 1

*/

import java.util.HashSet;

public class SingleNumber {
    public static void main(String[] args) {
        SingleNumber lc = new SingleNumber();

        System.out.println(lc.singleNumber(new int[]{2, 2, 1}));
        System.out.println(lc.singleNumber(new int[]{4, 1, 2, 1, 2}));
        System.out.println(lc.singleNumber(new int[]{1}));
    }

    /*
        Explanation:
            sum1 = sum(nums array)
            sum2 = sum(unique elements of array)

            so (sum2 * 2) includes that one missing number that didn't appear twice
    */
    public int singleNumber(int[] nums) {
        int n = nums.length;

        int sum1 = 0, sum2 = 0;
        HashSet<Integer> uniq = new HashSet<>();
        for (int num : nums) {
            uniq.add(num);
            sum1 += num;
        }

        for (Integer i : uniq) {
            sum2 += i;
        }

        return 2 * sum2 - sum1;
    }

    public int singleNumberXOR(int[] nums) {
        int n = nums.length;

        int res = 0;
        for (int num : nums) {
            res ^= num;
        }

        return res;
    }
}
