/*

https://leetcode.com/problems/generate-parentheses/

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

Constraints:
1. 1 <= n <= 8

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]

Input: n = 1
Output: ["()"]

*/

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GenerateParentheses {
    public static void main(String[] args) {
        GenerateParentheses lc = new GenerateParentheses();

        System.out.println(lc.generateParenthesis(3));
        System.out.println(lc.generateParenthesis(1));
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder curr = new StringBuilder();
        curr.setLength(n + n);

        permute(0, n, 0, 0, curr, res);

        return res;
    }

    private void permute(int idx, int n, int closedN, int openN, StringBuilder curr, List<String> res) {
        if (openN == closedN && openN == n) {
            res.add(curr.toString());
            return;
        }

        if (openN < n) {
            curr.setCharAt(idx, '(');
            permute(idx + 1, n, closedN, openN + 1, curr, res);
        }

        if (closedN < openN) {
            curr.setCharAt(idx, ')');
            permute(idx + 1, n, closedN + 1, openN, curr, res);
        }
    }
}
