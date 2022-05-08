/*

https://leetcode.com/problems/pascals-triangle-ii/

Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

Constraints:
1. 0 <= rowIndex <= 33

Follow up: Could you optimize your algorithm to use only O(rowIndex) extra space?

Input: rowIndex = 3
Output: [1,3,3,1]

Input: rowIndex = 0
Output: [1]

Input: rowIndex = 1
Output: [1,1]

*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PascalsTriangleII {
    public static void main(String[] args) {
        PascalsTriangleII lc = new PascalsTriangleII();

        System.out.println(lc.getRow(3));
        System.out.println(lc.getRow(0));
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>(Collections.nCopies(rowIndex + 1, 0));
        res.set(0, 1);

        for (int i = 0; i < rowIndex + 1; i++) {
            for (int j = i; j > 0; j--) {
                res.set(j, res.get(j) + res.get(j - 1));
            }
        }

        return res;
    }
}
