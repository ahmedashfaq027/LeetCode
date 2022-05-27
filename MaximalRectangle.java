/*

https://leetcode.com/problems/maximal-rectangle/

Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

Constraints:
1. rows == matrix.length
2. cols == matrix[i].length
3. 1 <= row, cols <= 200
4. matrix[i][j] is '0' or '1'.

Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 6
    Explanation: The maximal rectangle is shown in the above picture.

Input: matrix = [["0"]]
Output: 0

Input: matrix = [["1"]]
Output: 1

*/

import java.util.Stack;

public class MaximalRectangle {
    public static void main(String[] args) {
        MaximalRectangle lc = new MaximalRectangle();

        System.out.println(lc.maximalRectangle(new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}}));
        System.out.println(lc.maximalRectangle(new char[][]{{'0'}}));
        System.out.println(lc.maximalRectangle(new char[][]{{'1'}}));
    }

    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length, m = matrix[0].length;

        int[] heights = new int[m];
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1')
                    heights[i]++;
                else
                    heights[i] = 0;
            }

            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }

        return maxArea;
    }

    private int largestRectangleArea(int[] heights) {
        int n = heights.length;

        Stack<Integer> st = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i <= n; i++) {
            while (!st.empty() && (i == n || heights[st.peek()] >= heights[i])) {
                int height = heights[st.pop()];
                int width;

                if (st.isEmpty())
                    width = i;
                else
                    width = i - st.peek() - 1;

                maxArea = Math.max(maxArea, width * height);
            }

            st.push(i);
        }

        return maxArea;
    }
}
