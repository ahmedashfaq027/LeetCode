/*

https://leetcode.com/problems/largest-rectangle-in-histogram/

Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

Constraints:
1. 1 <= heights.length <= 105
2. 0 <= heights[i] <= 104

Input: heights = [2,1,5,6,2,3]
Output: 10
    Explanation: The above is a histogram where width of each bar is 1.
    The largest rectangle is shown in the red area, which has an area = 10 units.

Input: heights = [2,4]
Output: 4

*/

import java.util.Stack;

public class LargestRectangleinHistogram {
    public static void main(String[] args) {
        LargestRectangleinHistogram lc = new LargestRectangleinHistogram();

        System.out.println(lc.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        System.out.println(lc.largestRectangleArea(new int[]{2, 4}));
    }

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        int maxArea = 0;
        Stack<Integer> st = new Stack<>();
        st.push(-1);

        for (int i = 0; i < n; i++) {
            while (st.peek() != -1 && heights[st.peek()] >= heights[i]) {
                int val = heights[st.pop()];
                maxArea = Math.max(maxArea, val * (i - st.peek() - 1));
            }

            st.push(i);
        }

        while (st.peek() != -1) {
            int val = heights[st.pop()];
            maxArea = Math.max(maxArea, val * (n - st.peek() - 1));
        }

        return maxArea;
    }
}
