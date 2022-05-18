/*

https://leetcode.com/problems/combination-sum-iii/

Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
1. Only numbers 1 through 9 are used.
2. Each number is used at most once.
Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.

Constraints:
1. 2 <= k <= 9
2. 1 <= n <= 60

Input: k = 3, n = 7
Output: [[1,2,4]]
    Explanation:
    1 + 2 + 4 = 7
    There are no other valid combinations.

Input: k = 3, n = 9
Output: [[1,2,6],[1,3,5],[2,3,4]]
    Explanation:
    1 + 2 + 6 = 9
    1 + 3 + 5 = 9
    2 + 3 + 4 = 9
    There are no other valid combinations.

Input: k = 4, n = 1
Output: []
    Explanation: There are no valid combinations.
    Using 4 different numbers in the range [1,9], the smallest sum we can get is 1+2+3+4 = 10 and since 10 > 1, there are no valid combination.

Input: k = 3, n = 2
Output: []
    Explanation: There are no valid combinations.

Input: k = 9, n = 45
Output: [[1,2,3,4,5,6,7,8,9]]
    Explanation:
    1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 = 45
    There are no other valid combinations.

*/

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    public static void main(String[] args) {
        CombinationSumIII lc = new CombinationSumIII();

        System.out.println(lc.combinationSum3(3, 7));
        System.out.println(lc.combinationSum3(3, 9));
        System.out.println(lc.combinationSum3(4, 1));
        System.out.println(lc.combinationSum3(3, 2));
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        combinations(1, n, k, new ArrayList<>(), res);
        return res;
    }

    private void combinations(int idx, int targetSum, int k, List<Integer> curComb, List<List<Integer>> res) {
        if (curComb.size() == k) {
            if (targetSum == 0)
                res.add(new ArrayList<>(curComb));
            return;
        }

        for (int i = idx; i <= 9; i++) {
            if (i > targetSum)
                continue;

            curComb.add(i);
            combinations(i + 1, targetSum - i, k, curComb, res);
            curComb.remove(Integer.valueOf(i));
        }
    }
}
