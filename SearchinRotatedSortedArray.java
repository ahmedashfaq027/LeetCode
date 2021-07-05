/*

https://leetcode.com/problems/search-in-rotated-sorted-array/

There is an integer array nums sorted in ascending order (with distinct values).
Prior to being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
Given the array nums after the rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.

Constraints:
1. 1 <= nums.length <= 5000
2. -104 <= nums[i] <= 104
3. All values of nums are unique.
4. nums is guaranteed to be rotated at some pivot.
5. -104 <= target <= 104

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1

Input: nums = [1], target = 0
Output: -1

*/

public class SearchinRotatedSortedArray {
    public static void main(String[] args) {
        SearchinRotatedSortedArray lc = new SearchinRotatedSortedArray();

        System.out.println(lc.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(lc.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        System.out.println(lc.search(new int[]{3, 1}, 1));
    }

    public int search(int[] nums, int target) {
        int n = nums.length;

        int res = -1;
        int lo = 0, hi = n - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (nums[mid] == target)
                return mid;

            if (nums[lo] <= nums[mid]) {
                if (nums[lo] <= target && target <= nums[mid])
                    hi = mid - 1;
                else
                    lo = mid + 1;
            } else {
                if (nums[mid] <= target && target <= nums[hi])
                    lo = mid + 1;
                else
                    hi = mid - 1;
            }
        }

        return res;
    }
}
