/*

https://leetcode.com/problems/combinations/

Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].
You may return the answer in any order.

Constraints:
1. 1 <= n <= 20
2. 1 <= k <= n

Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

Input: n = 1, k = 1
Output: [[1]]

*/

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static void main(String[] args) {
        Combinations lc = new Combinations();

        System.out.println(lc.combine(4, 2));
        System.out.println(lc.combine(1, 1));
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();

        if (k > n)
            return res;

        combinations(1, n, k, new ArrayList<>(), res);
        return res;
    }

    private void combinations(int idx, int n, int k, List<Integer> curComb, List<List<Integer>> res) {
        if (k == 0) {
            res.add(new ArrayList<>(curComb));
            return;
        }

        for (int i = idx; i <= n; i++) {
            curComb.add(i);
            combinations(i + 1, n, k - 1, curComb, res);
            curComb.remove(Integer.valueOf(i));
        }
    }
}
