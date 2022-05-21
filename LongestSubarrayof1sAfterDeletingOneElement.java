/*

https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/

Given a binary array nums, you should delete one element from it.
Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.

Constraints:
1. 1 <= nums.length <= 105
2. nums[i] is either 0 or 1.

Input: nums = [1,1,0,1]
Output: 3
    Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.

Input: nums = [0,1,1,1,0,1,1,0,1]
Output: 5
    Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,1,1,1,1].

Input: nums = [1,1,1]
Output: 2
    Explanation: You must delete one element.

*/

import java.util.ArrayList;

public class LongestSubarrayof1sAfterDeletingOneElement {
    public static void main(String[] args) {
        LongestSubarrayof1sAfterDeletingOneElement lc = new LongestSubarrayof1sAfterDeletingOneElement();

        System.out.println(lc.longestSubarray(new int[]{1, 1, 0, 1}));
        System.out.println(lc.longestSubarray(new int[]{0, 1, 1, 1, 0, 1, 1, 0, 1}));
        System.out.println(lc.longestSubarray(new int[]{1, 1, 1}));
    }

    /*
        Explanation:
            We continuously maintain a count of 1's, if we encounter 0, we store the count.
            Then we add prev and curr and max of this is the result.
    */
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> res = new ArrayList<>();

        int count = 0, max = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                res.add(count);
                count = 0;
            }

            if (nums[i] == 1) {
                count++;

                if (i == n - 1) {
                    res.add(count);
                }
            }
        }

        if (res.get(0) == n)
            return n - 1;

        for (int i = 1; i < res.size(); i++) {
            int prev = res.get(i - 1);
            int curr = res.get(i);

            max = Math.max(max, prev + curr);
        }

        return max;
    }
}
