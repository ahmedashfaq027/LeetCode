/*

https://leetcode.com/problems/n-queens/

The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

Constraints:
1. 1 <= n <= 9

Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
    Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above

    . Q . .
    . . . Q
    Q . . .
    . . Q .

    . . Q .
    Q . . .
    . . . Q
    . Q . .

Input: n = 1
Output: [["Q"]]

*/

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        NQueens lc = new NQueens();

        System.out.println(lc.solveNQueens(4));
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();

        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        dfs(board, n, 0, res);

        return res;
    }

    private void dfs(char[][] board, int n, int row, List<List<String>> res) {
        if (row == n) {
            List<String> tmp = new ArrayList<>();
            for (char[] i : board) {
                tmp.add(String.valueOf(i));
            }
            res.add(tmp);

            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 'Q';
                printBoard(board);
                dfs(board, n, row + 1, res);
                board[row][col] = '.';
            }
        }
    }

    private boolean isSafe(char[][] board, int row, int col, int n) {
        for (int r = 0; r < n; r++) {
            if (board[r][col] == 'Q')
                return false;
        }

        for (int r = row - 1, c = col - 1; r >= 0 && c >= 0; r--, c--) {
            if (board[r][c] == 'Q')
                return false;
        }

        for (int r = row - 1, c = col + 1; r >= 0 && c < n; r--, c++) {
            if (board[r][c] == 'Q')
                return false;
        }

        return true;
    }

    private void printBoard(char[][] board) {
        int n = board.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
