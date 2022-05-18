/*

https://leetcode.com/problems/permutations/

Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

Constraints:
1. 1 <= nums.length <= 6
2. -10 <= nums[i] <= 10
3. All the integers of nums are unique.

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

Input: nums = [0,1]
Output: [[0,1],[1,0]]

Input: nums = [1]
Output: [[1]]

*/

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        Permutations lc = new Permutations();

        System.out.println(lc.permute(new int[]{1, 2, 3}));
        System.out.println(lc.permute(new int[]{0, 1}));
        System.out.println(lc.permute(new int[]{1}));
    }

    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;

        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, new ArrayList<>(), res, new boolean[n]);

        return res;
    }

    private void dfs(int[] nums, List<Integer> currPerm, List<List<Integer>> res, boolean[] visited) {
        if (currPerm.size() == nums.length) {
            res.add(new ArrayList<>(currPerm));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i])
                continue;

            currPerm.add(nums[i]);
            visited[i] = true;

            dfs(nums, currPerm, res, visited);

            currPerm.remove(Integer.valueOf(nums[i]));
            visited[i] = false;
        }
    }
}
