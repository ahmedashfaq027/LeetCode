/*

https://leetcode.com/problems/01-matrix/

Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
The distance between two adjacent cells is 1.

Constraints:
1. m == mat.length
2. n == mat[i].length
3. 1 <= m, n <= 104
4. 1 <= m * n <= 104
5. mat[i][j] is either 0 or 1.
6. There is at least one 0 in mat.

Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
Output: [[0,0,0],[0,1,0],[0,0,0]]

Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
Output: [[0,0,0],[0,1,0],[1,2,1]]

*/

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

class Pair {
    public int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Pair pair = (Pair) o;
        return x == pair.x && y == pair.y;
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

public class Matrix01 {
    public static void main(String[] args) {
        Matrix01 lc = new Matrix01();

        int[][] t1 = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}};
        for (int[] i : lc.updateMatrix(t1))
            System.out.println(Arrays.toString(i));
        System.out.println();

        int[][] t2 = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}};
        for (int[] i : lc.updateMatrix(t2))
            System.out.println(Arrays.toString(i));
        System.out.println();
    }

    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int[][] dir = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        Queue<Pair> q = new LinkedList<>();
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    q.add(new Pair(i, j));
                    dp[i][j] = 0;
                }
            }
        }

        while (!q.isEmpty()) {
            Pair tmp = q.peek();
            q.poll();

            for (int[] i : dir) {
                int x = tmp.x + i[0];
                int y = tmp.y + i[1];

                if (isValid(x, y, n, m) && dp[x][y] == -1) {
                    q.add(new Pair(x, y));
                    dp[x][y] = dp[tmp.x][tmp.y] + 1;
                }
            }
        }


        return dp;
    }

    private boolean isValid(int i, int j, int n, int m) {
        if (i < 0 || i >= n || j < 0 || j >= m)
            return false;
        return true;
    }
}
