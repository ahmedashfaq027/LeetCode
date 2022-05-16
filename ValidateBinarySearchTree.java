/*

https://leetcode.com/problems/validate-binary-search-tree/

Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:
1. The left subtree of a node contains only nodes with keys less than the node's key.
2. The right subtree of a node contains only nodes with keys greater than the node's key.
3. Both the left and right subtrees must also be binary search trees.

Constraints:
1. The number of nodes in the tree is in the range [1, 104].
2. -231 <= Node.val <= 231 - 1

Input: root = [2,1,3]
Output: true
    Explanation:        2
                    1       3

Input: root = [5,1,4,null,null,3,6]
Output: false
    Explanation:            5
                    1               4
                                3       6

*/

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

public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        ValidateBinarySearchTree lc = new ValidateBinarySearchTree();

        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        System.out.println(lc.isValidBST(root));

        root = new TreeNode(5, new TreeNode(1), new TreeNode(4, new TreeNode(3), new TreeNode(6)));
        System.out.println(lc.isValidBST(root));

        root = new TreeNode(2, new TreeNode(2), new TreeNode(2));
        System.out.println(lc.isValidBST(root));

        root = new TreeNode(5, new TreeNode(4), new TreeNode(6, new TreeNode(3), new TreeNode(7)));
        System.out.println(lc.isValidBST(root));
    }

    public boolean isValidBST(TreeNode root) {
        long min = Long.MIN_VALUE;
        long max = Long.MAX_VALUE;

        return check(root, min, max);
    }

    private boolean check(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }

        if (min >= root.val || root.val >= max) {
            return false;
        }

        return check(root.left, min, root.val) && check(root.right, root.val, max);
    }
}
