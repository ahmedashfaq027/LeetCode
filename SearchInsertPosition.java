/*

https://leetcode.com/problems/search-insert-position/

Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
You must write an algorithm with O(log n) runtime complexity.

Constraints:
1. 1 <= nums.length <= 104
2. -104 <= nums[i] <= 104
3. nums contains distinct values sorted in ascending order.
4. -104 <= target <= 104

Input: nums = [1,3,5,6], target = 5
Output: 2

Input: nums = [1,3,5,6], target = 2
Output: 1

Input: nums = [1,3,5,6], target = 7
Output: 4

Input: nums = [1,3,5,6], target = 0
Output: 0

Input: nums = [1], target = 0
Output: 0

*/

public class SearchInsertPosition {
    public static void main(String[] args) {
        SearchInsertPosition lc = new SearchInsertPosition();

        System.out.println(lc.searchInsert(new int[]{1, 3, 5, 6}, 5));
        System.out.println(lc.searchInsert(new int[]{1, 3, 5, 6}, 2));
        System.out.println(lc.searchInsert(new int[]{1, 3, 5, 6}, 7));
        System.out.println(lc.searchInsert(new int[]{1, 3, 5, 6}, 0));
        System.out.println(lc.searchInsert(new int[]{1}, 0));
    }

    public int searchInsert(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;

        int ans = 0;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] < target) {
                ans = mid + 1;
                lo = mid + 1;
            } else {

                hi = mid - 1;
            }
        }

        return ans;
    }
}
