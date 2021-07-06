/*

https://leetcode.com/problems/combination-sum/

Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.
It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

Constraints:
1. 1 <= candidates.length <= 30
2. 1 <= candidates[i] <= 200
3. All elements of candidates are distinct.
4. 1 <= target <= 500

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
    Explanation:
    2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
    7 is a candidate, and 7 = 7.
    These are the only two combinations.

Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]

Input: candidates = [2], target = 1
Output: []

Input: candidates = [1], target = 1
Output: [[1]]

Input: candidates = [1], target = 2
Output: [[1,1]]

*/

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        CombinationSum lc = new CombinationSum();

        System.out.println(lc.combinationSum(new int[]{2, 3, 6, 7}, 7));
        System.out.println(lc.combinationSum(new int[]{2, 3, 5}, 8));
        System.out.println(lc.combinationSum(new int[]{2}, 1));
        System.out.println(lc.combinationSum(new int[]{1}, 1));
        System.out.println(lc.combinationSum(new int[]{1}, 2));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        combinations(0, candidates, target, new ArrayList<>(), res);
        return res;
    }

    private void combinations(int i, int[] candidates, int target, List<Integer> curComb, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(curComb));
            return;
        }

        int n = candidates.length;
        for (int x = i; x < n; x++) {
            if (candidates[x] > target)
                continue;

            curComb.add(candidates[x]);
            combinations(x, candidates, target - candidates[x], curComb, res);
            curComb.remove(curComb.size() - 1);
        }
    }
}
