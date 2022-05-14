/*

https://leetcode.com/problems/squares-of-a-sorted-array/

Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

Constraints:
1. 1 <= nums.length <= 104
2. -104 <= nums[i] <= 104
3. nums is sorted in non-decreasing order.

Follow up: Squaring each element and sorting the new array is very trivial, could you find an O(n) solution using a different approach?

Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
    Explanation: After squaring, the array becomes [16,1,0,9,100].
    After sorting, it becomes [0,1,9,16,100].

Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]

*/

import java.util.Arrays;

public class SquaresofaSortedArray {
    public static void main(String[] args) {
        SquaresofaSortedArray lc = new SquaresofaSortedArray();

        System.out.println(Arrays.toString(lc.sortedSquares(new int[]{-4, -1, 0, 3, 10})));
        System.out.println(Arrays.toString(lc.sortedSquares(new int[]{-7, -3, 2, 3, 11})));
    }

    public int[] sortedSquares(int[] nums) {
        int n = nums.length;

        int[] res = new int[n];
        int lo = 0, hi = n - 1;
        while (lo <= hi) {
            if (Math.abs(nums[lo]) < Math.abs(nums[hi])) {
                res[hi - lo] = nums[hi] * nums[hi];
                hi = hi - 1;
            } else {
                res[hi - lo] = nums[lo] * nums[lo];
                lo = lo + 1;
            }
        }

        return res;
    }
}
