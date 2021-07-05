/*

https://leetcode.com/problems/search-in-rotated-sorted-array-ii/

There is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).
Before being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,2,4,4].
Given the array nums after the rotation and an integer target, return true if target is in nums, or false if it is not in nums.
You must decrease the overall operation steps as much as possible.

Constraints:
1. 1 <= nums.length <= 5000
2. -104 <= nums[i] <= 104
3. nums is guaranteed to be rotated at some pivot.
4. -104 <= target <= 104

Follow up: This problem is similar to Search in Rotated Sorted Array, but nums may contain duplicates. Would this affect the runtime complexity? How and why?

Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true

Input: nums = [2,5,6,0,0,1,2], target = 3
Output: false

*/

public class SearchinRotatedSortedArrayII {
    public static void main(String[] args) {
        SearchinRotatedSortedArrayII lc = new SearchinRotatedSortedArrayII();

        System.out.println(lc.search(new int[]{2, 5, 6, 0, 0, 1, 2}, 0));
        System.out.println(lc.search(new int[]{2, 5, 6, 0, 0, 1, 2}, 3));
        System.out.println(lc.search(new int[]{1, 0, 1, 1, 1}, 0));
    }

    public boolean search(int[] nums, int target) {
        return bsRecursive(nums, 0, nums.length - 1, target);
    }

    private boolean bsRecursive(int[] nums, int lo, int hi, int target) {
        if (lo > hi)
            return false;

        int mid = (lo + hi) / 2;

        if (nums[mid] == target)
            return true;

        if (nums[lo] < nums[mid]) {
            if (nums[lo] <= target && target <= nums[mid])
                return bsRecursive(nums, lo, mid - 1, target);
            else
                return bsRecursive(nums, mid + 1, hi, target);
        } else if (nums[mid] < nums[hi]) {
            if (nums[mid] <= target && target <= nums[hi])
                return bsRecursive(nums, mid + 1, hi, target);
            else
                return bsRecursive(nums, lo, mid - 1, target);
        } else
            return bsRecursive(nums, lo, mid - 1, target) || bsRecursive(nums, mid + 1, hi, target);
    }
}
