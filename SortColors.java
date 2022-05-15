/*

https://leetcode.com/problems/sort-colors/

Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
You must solve this problem without using the library's sort function.

Constraints:
1. n == nums.length
2. 1 <= n <= 300
3. nums[i] is either 0, 1, or 2.

Follow up: Could you come up with a one-pass algorithm using only constant extra space?

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]

Input: nums = [2,0,1]
Output: [0,1,2]

*/

import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        SortColors lc = new SortColors();

        int[] n = new int[]{2, 0, 2, 1, 1, 0};
        lc.sortColors(n);
        System.out.println(Arrays.toString(n));

        n = new int[]{2, 0, 1};
        lc.sortColors(n);
        System.out.println(Arrays.toString(n));
    }

    public void sortColors(int[] nums) {
        int n = nums.length;
        int lo = 0, mid = lo, hi = n - 1;

        while (mid <= hi) {
            if (nums[mid] == 0) {
                nums[lo] = nums[lo] ^ nums[mid] ^ (nums[mid] = nums[lo]);
                lo++;
                mid++;
            } else if (nums[mid] == 1)
                mid++;
            else if (nums[mid] == 2) {
                nums[mid] = nums[mid] ^ nums[hi] ^ (nums[hi] = nums[mid]);
                hi--;
            }
        }
    }
}
