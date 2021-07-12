/*

https://leetcode.com/problems/path-with-minimum-effort/

You are a hiker preparing for an upcoming hike. You are given heights, a 2D array of size rows x columns, where heights[row][col] represents the height of cell (row, col). You are situated in the top-left cell, (0, 0), and you hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed). You can move up, down, left, or right, and you wish to find a route that requires the minimum effort.
A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.
Return the minimum effort required to travel from the top-left cell to the bottom-right cell.

Constraints:
1. rows == heights.length
2. columns == heights[i].length
3. 1 <= rows, columns <= 100
4. 1 <= heights[i][j] <= 106

Input: heights = [[1,2,2],[3,8,2],[5,3,5]]
Output: 2
    Explanation: The route of [1,3,5,3,5] has a maximum absolute difference of 2 in consecutive cells.
    This is better than the route of [1,2,2,2,5], where the maximum absolute difference is 3.

Input: heights = [[1,2,3],[3,8,4],[5,3,5]]
Output: 1
    Explanation: The route of [1,2,3,4,5] has a maximum absolute difference of 1 in consecutive cells, which is better than route [1,3,5,3,5].

Input: heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
Output: 0
    Explanation: This route does not require any effort.

*/

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PathWithMinimumEffort {
    public static void main(String[] args) {
        PathWithMinimumEffort lc = new PathWithMinimumEffort();

        System.out.println(lc.minimumEffortPath(new int[][]{
                {1, 2, 2},
                {3, 8, 2},
                {5, 3, 5}}));

        System.out.println(lc.minimumEffortPath(new int[][]{
                {1, 2, 3},
                {3, 8, 4},
                {5, 3, 5}}));

        System.out.println(lc.minimumEffortPath(new int[][]{
                {1, 2, 1, 1, 1},
                {1, 2, 1, 2, 1},
                {1, 2, 1, 2, 1},
                {1, 2, 1, 2, 1},
                {1, 1, 1, 2, 1}}));
    }

    public int minimumEffortPath(int[][] heights) {
        int n = heights.length, m = heights[0].length;
        int[][] dir = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        boolean[][] vis = new boolean[n][m];
        Queue<Integer[]> q = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));

        q.add(new Integer[]{0, 0, 0});
        while (!q.isEmpty()) {
            Integer[] tmp = q.poll();

            if (tmp[0] == n - 1 && tmp[1] == m - 1)
                return tmp[2];

            if (vis[tmp[0]][tmp[1]])
                continue;

            vis[tmp[0]][tmp[1]] = true;
            for (int[] i : dir) {
                int x = tmp[0] + i[0];
                int y = tmp[1] + i[1];

                if (isValid(x, y, n, m, vis)) {
                    int effort = Math.max(tmp[2], Math.abs(heights[tmp[0]][tmp[1]] - heights[x][y]));
                    q.add(new Integer[]{x, y, effort});
                }
            }
        }

        return 0;
    }

    private boolean isValid(int i, int j, int n, int m, boolean[][] vis) {
        if (i < 0 || i >= n || j < 0 || j >= m || vis[i][j])
            return false;
        return true;
    }
}
