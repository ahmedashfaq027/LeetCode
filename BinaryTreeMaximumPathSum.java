/*

https://leetcode.com/problems/binary-tree-maximum-path-sum/

A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
The path sum of a path is the sum of the node's values in the path.

Given the root of a binary tree, return the maximum path sum of any non-empty path.

Constraints:
1. The number of nodes in the tree is in the range [1, 3 * 104].
2. -1000 <= Node.val <= 1000

Input: root = [1,2,3]
Output: 6
    Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.

Input: root = [-10,9,20,null,null,15,7]
Output: 42
    Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.

*/

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

public class BinaryTreeMaximumPathSum {
    public static void main(String[] args) {
        BinaryTreeMaximumPathSum lc = new BinaryTreeMaximumPathSum();

        TreeNode root = new TreeNode(1,
                new TreeNode(2),
                new TreeNode(3));
        System.out.println(lc.maxPathSum(root));

        root = new TreeNode(-10,
                new TreeNode(9),
                new TreeNode(20,
                        new TreeNode(15),
                        new TreeNode(7)));
        System.out.println(lc.maxPathSum(root));
    }

    int res;

    public int maxPathSum(TreeNode root) {
        res = Integer.MIN_VALUE;
        postSolve(root);
        return res;
    }

    private int postSolve(TreeNode root) {
        if (root == null)
            return 0;

        int left = postSolve(root.left);
        int right = postSolve(root.right);

        if (left < 0)
            left = 0;

        if (right < 0)
            right = 0;

        res = Math.max(res, (left + root.val + right));

        return root.val + Math.max(left, right);
    }
}
