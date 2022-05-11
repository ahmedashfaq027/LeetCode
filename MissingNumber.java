/*

https://leetcode.com/problems/missing-number/

Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.

Constraints:
1. n == nums.length
2. 1 <= n <= 104
3. 0 <= nums[i] <= n
4. All the numbers of nums are unique.

Input: nums = [3,0,1]
Output: 2
    Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.

Input: nums = [0,1]
Output: 2
    Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.

Input: nums = [9,6,4,2,3,5,7,0,1]
Output: 8
    Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.

*/

public class MissingNumber {
    public static void main(String[] args) {
        MissingNumber lc = new MissingNumber();

        System.out.println(lc.missingNumber(new int[]{3, 0, 1}));
        System.out.println(lc.missingNumber(new int[]{0, 1}));
        System.out.println(lc.missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
    }

    public int missingNumber(int[] nums) {
        int n = nums.length;

        int actualSum = n * (n + 1) / 2;
        int computedSum = 0;

        for (int num : nums) {
            computedSum += num;
        }

        return actualSum - computedSum;
    }

    public int missingNumberXOR(int[] nums) {
        int n = nums.length;

        int actualXOR = 0, computedXOR = 0;
        for (int i = 0; i < n; i++) {
            actualXOR ^= i;
            computedXOR ^= nums[i];
        }

        actualXOR ^= n;

        return (computedXOR ^ actualXOR);
    }
}
