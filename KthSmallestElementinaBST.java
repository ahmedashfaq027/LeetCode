/*

https://leetcode.com/problems/kth-smallest-element-in-a-bst/

Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.

Constraints:
1. The number of nodes in the tree is n.
2. 1 <= k <= n <= 104
3. 0 <= Node.val <= 104

Follow up: If the BST is modified often (i.e., we can do insert and delete operations) and you need to find the kth smallest frequently, how would you optimize?

Input: root = [3,1,4,null,2], k = 1
Output: 1

Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3

*/

import java.util.Stack;

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

public class KthSmallestElementinaBST {
    public static void main(String[] args) {
        KthSmallestElementinaBST lc = new KthSmallestElementinaBST();

        TreeNode root = new TreeNode(3,
                new TreeNode(1,
                        null,
                        new TreeNode(2)),
                new TreeNode(4));
        System.out.println(lc.kthSmallest(root, 1));

        root = new TreeNode(5,
                new TreeNode(3,
                        new TreeNode(2,
                                new TreeNode(1),
                                null),
                        new TreeNode(4)),
                new TreeNode(6));
        System.out.println(lc.kthSmallest(root, 3));
    }

    int count = 0, value = 0;

    public int kthSmallest(TreeNode root, int k) {
        count = 0;
        value = 0;

        dfsInorder(root, k);

        return value;
    }

    private void dfsInorder(TreeNode root, int k) {
        if (root == null) {
            return;
        }

        dfsInorder(root.left, k);

        count++;
        if (count == k) {
            value = root.val;
            return;
        }

        dfsInorder(root.right, k);
    }

    public int kthSmallestIterative(TreeNode root, int k) {
        if (root == null)
            return 0;

        Stack<TreeNode> st = new Stack<>();
        int count = 0;
        while (root != null || !st.isEmpty()) {
            while (root != null) {
                st.push(root);
                root = root.left;
            }

            root = st.pop();
            count++;

            if (count == k) {
                return root.val;
            }

            root = root.right;
        }

        return 0;
    }
}
