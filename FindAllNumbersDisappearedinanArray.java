/*

https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.

Constraints:
1. n == nums.length
2. 1 <= n <= 105
3. 1 <= nums[i] <= n

Follow up: Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

Input: nums = [4,3,2,7,8,2,3,1]
Output: [5,6]

Input: nums = [1,1]
Output: [2]

*/

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedinanArray {
    public static void main(String[] args) {
        FindAllNumbersDisappearedinanArray lc = new FindAllNumbersDisappearedinanArray();

        System.out.println(lc.findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
        System.out.println(lc.findDisappearedNumbers(new int[]{1, 1}));
    }

    /*
        Explanation:
            To do it without extra space & Linear time, We mark the position of current element as negative which indicates it is already visited.
            Which ever indexes are not visited (positive number), that is in our required answer.
    */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int pos = Math.abs(nums[i]) - 1;

            if (nums[pos] > 0) {
                nums[pos] = -nums[pos];
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }

        return res;
    }
}
