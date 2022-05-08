/*

https://leetcode.com/problems/pascals-triangle/

Given an integer numRows, return the first numRows of Pascal's triangle.
In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

Constraints:
1. 1 <= numRows <= 30

Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

Input: numRows = 1
Output: [[1]]

*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args) {
        PascalsTriangle lc = new PascalsTriangle();

        System.out.println(lc.generate(5));
        System.out.println(lc.generate(1));
    }

    /*
        Explanation:
            DP Equation: dp[i] = dp[i-1][j] + dp[i-1][j-1]  for all middle digits
            Base cases: first and last element is 1
    */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>(numRows);

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>(Collections.nCopies(i + 1, 1));
            for (int j = 1; j < i; j++) {
                row.set(j, res.get(i - 1).get(j) + res.get(i - 1).get(j - 1));
            }
            res.add(row);
        }

        return res;
    }
}
