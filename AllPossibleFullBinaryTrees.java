/*

https://leetcode.com/problems/all-possible-full-binary-trees/

Given an integer n, return a list of all possible full binary trees with n nodes. Each node of each tree in the answer must have Node.val == 0.
Each element of the answer is the root node of one possible tree. You may return the final list of trees in any order.

A full binary tree is a binary tree where each node has exactly 0 or 2 children.

Constraints:
1. 1 <= n <= 20

Input: n = 7
Output: [[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]

Input: n = 3
Output: [[0,0,0]]

*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class AllPossibleFullBinaryTrees {

    Map<Integer, List<TreeNode>> dp = new HashMap<>();

    AllPossibleFullBinaryTrees() {
        List<TreeNode> tmp = new ArrayList<>();
        dp.put(0, tmp);

        tmp.add(new TreeNode(0));
        dp.put(1, tmp);
    }

    public static void main(String[] args) {
        AllPossibleFullBinaryTrees lc = new AllPossibleFullBinaryTrees();

        System.out.println(lc.allPossibleFBT(7));
        System.out.println(lc.allPossibleFBT(3));
    }

    public List<TreeNode> allPossibleFBT(int n) {
        if ((n & 1) == 0)
            return new ArrayList<>();

        if (dp.containsKey(n))
            return dp.get(n);

        List<TreeNode> res = new ArrayList<>();
        for (int left = 1; left < n; left++) {
            int right = n - left - 1;

            if ((left & 1) == 1 && (right & 1) == 1) {
                List<TreeNode> leftTrees = allPossibleFBT(left);
                List<TreeNode> rightTrees = allPossibleFBT(right);

                for (TreeNode t1 : leftTrees) {
                    for (TreeNode t2 : rightTrees) {
                        res.add(new TreeNode(0, t1, t2));
                        dp.put(n, res);
                    }
                }
            }
        }

        return dp.get(n);
    }
}
