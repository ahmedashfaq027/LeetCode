/*

https://leetcode.com/problems/path-sum-ii/

Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.
A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.

Constraints:
1. The number of nodes in the tree is in the range [0, 5000].
2. -1000 <= Node.val <= 1000
3. -1000 <= targetSum <= 1000

Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: [[5,4,11,2],[5,8,4,5]]
    Explanation:                        5
                            4                       8
                    11                      13              4
                  7   2                                   5   1

    There are two paths whose sum equals targetSum:
    5 + 4 + 11 + 2 = 22
    5 + 8 + 4 + 5 = 22

Input: root = [1,2,3], targetSum = 5
Output: []

Input: root = [1,2], targetSum = 0
Output: []

*/

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class PathSumII {
    public static void main(String[] args) {
        PathSumII lc = new PathSumII();

        TreeNode root = new TreeNode(5,
                new TreeNode(4,
                        new TreeNode(11,
                                new TreeNode(7),
                                new TreeNode(2)),
                        null),
                new TreeNode(8,
                        new TreeNode(13),
                        new TreeNode(4,
                                new TreeNode(5),
                                new TreeNode(1))));
        System.out.println(lc.pathSum(root, 22));

        root = new TreeNode(1,
                new TreeNode(2),
                new TreeNode(3));
        System.out.println(lc.pathSum(root, 5));

        root = new TreeNode(1,
                new TreeNode(2),
                null);
        System.out.println(lc.pathSum(root, 0));
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, targetSum, 0, new ArrayList<>(), res);
        return res;
    }

    private void dfs(TreeNode root, int targetSum, int currSum, List<Integer> tempRes, List<List<Integer>> res) {
        if (root == null)
            return;

        currSum += root.val;
        tempRes.add(root.val);

        if (root.left == null && root.right == null) {
            if (currSum == targetSum)
                res.add(tempRes);
            return;
        }

        if (root.left != null) {
            dfs(root.left, targetSum, currSum, new ArrayList<>(tempRes), res);
        }

        if (root.right != null) {
            dfs(root.right, targetSum, currSum, new ArrayList<>(tempRes), res);
        }
    }
}
