/*

https://leetcode.com/problems/3sum/

Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets.

Constraints:
1. 0 <= nums.length <= 3000
2. -105 <= nums[i] <= 105

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]

Input: nums = []
Output: []

Input: nums = [0]
Output: []

*/

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        ThreeSum lc = new ThreeSum();

        List<List<Integer>> res = lc.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        for (List<Integer> i : res) {
            System.out.println(Arrays.toString(i.toArray()));
        }
    }

    public List<List<Integer>> threeSumSet(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        Set<List<Integer>> ans = new HashSet<>();
        for (int i = 0; i < n - 2; i++) {
            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0)
                    ans.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
                else if (sum < 0)
                    j++;
                else
                    k--;
            }
        }

        return new ArrayList<>(ans);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1])
                continue;

            int j = i + 1, k = n - 1;

            while (j < k) {
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    j++;
                    continue;
                }

                if (k != n - 1 && nums[k] == nums[k + 1]) {
                    k--;
                    continue;
                }

                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0)
                    ans.add(Arrays.asList(nums[i], nums[j++], nums[k]));
                else if (sum < 0)
                    j++;
                else
                    k--;
            }
        }

        return ans;
    }
}
