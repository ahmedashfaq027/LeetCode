/*

https://leetcode.com/problems/binary-tree-level-order-traversal/

Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

Constraints:
1. The number of nodes in the tree is in the range [0, 2000].
2. -1000 <= Node.val <= 1000

Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]

Input: root = [1]
Output: [[1]]

Input: root = []
Output: []

*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversal lc = new BinaryTreeLevelOrderTraversal();

        TreeNode root = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20,
                        new TreeNode(15),
                        new TreeNode(7)));
        System.out.println(lc.levelOrder(root));

        root = new TreeNode(1);
        System.out.println(lc.levelOrder(root));

        root = null;
        System.out.println(lc.levelOrder(root));

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int n = q.size();

            List<Integer> lRes = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode tmp = q.poll();

                lRes.add(tmp.val);

                if (tmp.left != null)
                    q.add(tmp.left);

                if (tmp.right != null)
                    q.add(tmp.right);
            }

            res.add(lRes);
        }

        return res;
    }
}
