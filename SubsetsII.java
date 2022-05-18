/*

https://leetcode.com/problems/subsets-ii/

Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
The solution set must not contain duplicate subsets. Return the solution in any order.

Constraints:
1. 1 <= nums.length <= 10
2. -10 <= nums[i] <= 10

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]

Input: nums = [0]
Output: [[],[0]]

*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class SubsetsII {
    public static void main(String[] args) {
        SubsetsII lc = new SubsetsII();

        System.out.println(lc.subsetsWithDup(new int[]{1, 2, 2}));
        System.out.println(lc.subsetsWithDup(new int[]{0}));
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        HashSet<List<Integer>> res = new HashSet<>();

        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<>(), res);

        return new ArrayList<>(res);
    }

    private void dfs(int[] nums, int idx, List<Integer> currPerms, HashSet<List<Integer>> res) {
        if (idx == nums.length) {
            res.add(new ArrayList<>(currPerms));
            return;
        }

        currPerms.add(nums[idx]);
        dfs(nums, idx + 1, currPerms, res);

        currPerms.remove(Integer.valueOf(nums[idx]));
        dfs(nums, idx + 1, currPerms, res);
    }
}
