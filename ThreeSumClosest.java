/*

https://leetcode.com/problems/3sum-closest/

Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target.
Return the sum of the three integers. You may assume that each input would have exactly one solution.

Constraints:
1. 3 <= nums.length <= 10^3
2. -10^3 <= nums[i] <= 10^3
3. -10^4 <= target <= 10^4

Input: nums = [-1,2,1,-4], target = 1
Output: 2
    Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

*/

import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        ThreeSumClosest lc = new ThreeSumClosest();

        System.out.println(lc.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }

    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);

        int minDiff = Integer.MAX_VALUE, res = -1;
        for (int i = 0; i < n - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1])
                continue;

            int j = i + 1, k = n - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                int diff = Math.abs(sum - target);

                if (diff < minDiff) {
                    minDiff = diff;
                    res = sum;
                }

                if (sum < target)
                    j++;
                else
                    k--;
            }
        }

        return res;
    }
}
