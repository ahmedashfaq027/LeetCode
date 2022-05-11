/*

https://leetcode.com/problems/find-the-duplicate-number/

Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
There is only one repeated number in nums, return this repeated number.
You must solve the problem without modifying the array nums and uses only constant extra space.

Constraints:
1. 1 <= n <= 105
2. nums.length == n + 1
3. 1 <= nums[i] <= n
4. All the integers in nums appear only once except for precisely one integer which appears two or more times.

Follow up:
1. How can we prove that at least one duplicate number must exist in nums?
2. Can you solve the problem in linear runtime complexity?

Input: nums = [1,3,4,2,2]
Output: 2

Input: nums = [3,1,3,4,2]
Output: 3

*/

public class FindtheDuplicateNumber {
    public static void main(String[] args) {
        FindtheDuplicateNumber lc = new FindtheDuplicateNumber();

        System.out.println(lc.findDuplicate(new int[]{1, 3, 4, 2, 2}));
        System.out.println(lc.findDuplicate(new int[]{3, 1, 3, 4, 2}));
        System.out.println(lc.findDuplicate(new int[]{8, 7, 1, 10, 17, 15, 18, 11, 16, 9, 19, 12, 5, 14, 3, 4, 2, 13, 18, 18}));
    }

    public int findDuplicate(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; ) {
            if (nums[i] == i + 1) {
                i++;
            } else if (nums[nums[i] - 1] == nums[i]) {
                return nums[i];
            } else {
                nums[i] = nums[i] ^ nums[nums[i] - 1] ^ (nums[nums[i] - 1] = nums[i]);
            }
        }

        return n;
    }

    public int findDuplicateCountSort(int[] nums) {
        int n = nums.length;

        int[] count = new int[n];
        for (int i = 0; i < n; i++) {
            count[nums[i]]++;
            if (count[nums[i]] == 2)
                return nums[i];
        }

        return n;
    }
}
