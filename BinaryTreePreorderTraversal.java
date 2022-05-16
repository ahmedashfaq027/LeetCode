/*

https://leetcode.com/problems/binary-tree-preorder-traversal/

Given the root of a binary tree, return the preorder traversal of its nodes' values.

Constraints:
1. The number of nodes in the tree is in the range [0, 100].
2. -100 <= Node.val <= 100

Follow up: Recursive solution is trivial, could you do it iteratively?

Input: root = [1,null,2,3]
Output: [1,3,2]
    Explanation:           1
                               2
                           3

Input: root = []
Output: []

Input: root = [1]
Output: [1]

*/

import java.util.ArrayList;
import java.util.List;

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

public class BinaryTreePreorderTraversal {
    public static void main(String[] args) {
        BinaryTreePreorderTraversal lc = new BinaryTreePreorderTraversal();

        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        System.out.println(lc.preorderTraversal(root));

        root = null;
        System.out.println(lc.preorderTraversal(root));

        root = new TreeNode(1);
        System.out.println(lc.preorderTraversal(root));
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preOrder(root, res);
        return res;
    }

    private void preOrder(TreeNode root, List<Integer> res) {
        if (root == null)
            return;

        res.add(root.val);
        preOrder(root.left, res);
        preOrder(root.right, res);
    }
}
