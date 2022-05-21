/*

https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

Given the root of a binary tree, flatten the tree into a "linked list":
1. The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
2. The "linked list" should be in the same order as a pre-order traversal of the binary tree.

Constraints:
1. The number of nodes in the tree is in the range [0, 2000].
2. -100 <= Node.val <= 100

Follow up: Can you flatten the tree in-place (with O(1) extra space)?

Input: root = [1,2,5,3,4,null,6]
Output: [1,null,2,null,3,null,4,null,5,null,6]

Input: root = []
Output: []

Input: root = [0]
Output: [0]

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

public class FlattenBinaryTreetoLinkedList {
    public static void main(String[] args) {
        FlattenBinaryTreetoLinkedList lc = new FlattenBinaryTreetoLinkedList();

        BinaryTreeLevelOrderTraversal print = new BinaryTreeLevelOrderTraversal();

        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(3),
                        new TreeNode(4)),
                new TreeNode(5,
                        null,
                        new TreeNode(6)));
        lc.flatten(root);
        System.out.println(print.levelOrder(root));

        root = null;
        lc.flatten(root);
        System.out.println(print.levelOrder(root));

        root = new TreeNode(0);
        lc.flatten(root);
        System.out.println(print.levelOrder(root));
    }

    TreeNode prev;

    public void flatten(TreeNode root) {
        if (root == null)
            return;

        if (prev == null) {
            prev = root;
        } else {
            prev.right = root;
            prev.left = null;
            prev = root;
        }

        // Storing right node as the links on right will be jumbled
        TreeNode next = root.right;

        flatten(root.left);
        flatten(next);
    }
}
