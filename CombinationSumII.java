/*

https://leetcode.com/problems/combination-sum-ii/

Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.

Constraints:
1. 1 <= candidates.length <= 100
2. 1 <= candidates[i] <= 50
3. 1 <= target <= 30

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output:
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]

Input: candidates = [2,5,2,1,2], target = 5
Output:
[
[1,2,2],
[5]
]

*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public static void main(String[] args) {
        CombinationSumII lc = new CombinationSumII();

        System.out.println(lc.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
        System.out.println(lc.combinationSum2(new int[]{2, 5, 2, 1, 2}, 5));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(candidates);
        combinations(0, candidates, target, new ArrayList<>(), res);

        return res;
    }

    private void combinations(int idx, int[] candidates, int target, List<Integer> curComb, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(curComb));
            return;
        }

        int n = candidates.length;
        for (int i = idx; i < n; i++) {
            if (candidates[i] > target || (idx != i && candidates[i] == candidates[i - 1]))
                continue;

            curComb.add(candidates[i]);
            combinations(i + 1, candidates, target - candidates[i], curComb, res);
            curComb.remove(Integer.valueOf(candidates[i]));
        }
    }
}
