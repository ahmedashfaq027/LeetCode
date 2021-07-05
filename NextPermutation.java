/*

https://leetcode.com/problems/next-permutation/

Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).
The replacement must be in place and use only constant extra memory.

Constraints:
1. 1 <= nums.length <= 100
2. 0 <= nums[i] <= 100

Input: nums = [1,2,3]
Output: [1,3,2]

Input: nums = [3,2,1]
Output: [1,2,3]

Input: nums = [1,1,5]
Output: [1,5,1]

Input: nums = [1]
Output: [1]

*/

import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        NextPermutation lc = new NextPermutation();

        lc.nextPermutation(new int[]{1, 2, 3});
        lc.nextPermutation(new int[]{3, 2, 1});
        lc.nextPermutation(new int[]{1, 3, 2});
        lc.nextPermutation(new int[]{1, 1, 5});
        lc.nextPermutation(new int[]{1});

    }

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i;
        for (i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1])
                break;
        }

        if (i >= 0) {
            int j;
            for (j = n - 1; j > i; j--) {
                if (nums[j] > nums[i])
                    break;
            }
            nums[j] = nums[j] ^ nums[i] ^ (nums[i] = nums[j]);
        }
        reverseArray(nums, i + 1, n - 1);
        System.out.println(Arrays.toString(nums));
    }

    private void reverseArray(int[] ar, int lo, int hi) {
        while (lo < hi) {
            ar[lo] = ar[lo] ^ ar[hi] ^ (ar[hi] = ar[lo]);
            lo++;
            hi--;
        }
    }
}
