/*

https://leetcode.com/problems/rotting-oranges/

You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

Constraints:
1. m == grid.length
2. n == grid[i].length
3. 1 <= m, n <= 10
4. grid[i][j] is 0, 1, or 2.

Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4

Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
    Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.

Input: grid = [[0,2]]
Output: 0

*/

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

class PairG<T1, T2> {
    public T1 x;
    public T2 y;

    public PairG(T1 x, T2 y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        PairG<T1, T2> pair = (PairG<T1, T2>) o;
        return x.equals(pair.x) && y.equals(pair.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Pair{x=" + x + ", y=" + y + "}";
    }
}

public class RottingOranges {
    public static void main(String[] args) {
        RottingOranges lc = new RottingOranges();

        System.out.println(lc.orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}));
        System.out.println(lc.orangesRotting(new int[][]{{2, 1, 1}, {0, 1, 1}, {1, 0, 1}}));
        System.out.println(lc.orangesRotting(new int[][]{{0, 2}}));
    }

    public int orangesRotting(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, -1, 1, 0};
        int time = 0;

        Queue<PairG<Integer, PairG<Integer, Integer>>> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2)
                    q.add(new PairG(0, new PairG(i, j)));
            }
        }

        while (!q.isEmpty()) {
            PairG<Integer, PairG<Integer, Integer>> tmp = q.poll();

            for (int i = 0; i < 4; i++) {
                int t = tmp.x;
                PairG<Integer, Integer> coord = tmp.y;
                int x = coord.x + dx[i];
                int y = coord.y + dy[i];

                if (isValidCell(n, m, x, y) && grid[x][y] == 1) {
                    q.add(new PairG(t + 1, new PairG(x, y)));
                    grid[x][y] = 2;
                    time = t + 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1)
                    return -1;
            }
        }

        return time;
    }

    public boolean isValidCell(int n, int m, int x, int y) {
        if (x < 0 || y < 0 || x >= n || y >= m)
            return false;
        return true;
    }
}
