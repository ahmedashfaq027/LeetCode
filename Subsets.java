/*

https://leetcode.com/problems/subsets/

Given an integer array nums of unique elements, return all possible subsets (the power set).
The solution set must not contain duplicate subsets. Return the solution in any order.

Constraints:
1. 1 <= nums.length <= 10
2. -10 <= nums[i] <= 10
3. All the numbers of nums are unique.

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

Input: nums = [0]
Output: [[],[0]]

*/

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        Subsets lc = new Subsets();

        System.out.println(lc.subsets(new int[]{1, 2, 3}));
        System.out.println(lc.subsets(new int[]{0}));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int[] nums, int idx, List<Integer> currPerms, List<List<Integer>> res) {
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
