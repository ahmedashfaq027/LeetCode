/*

https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).

Constraints:
1. The number of nodes in the tree is in the range [0, 2000].
2. -100 <= Node.val <= 100

Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]

Input: root = [1]
Output: [[1]]

Input: root = []
Output: []

*/

import java.util.*;

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

public class BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        BinaryTreeZigzagLevelOrderTraversal lc = new BinaryTreeZigzagLevelOrderTraversal();

        TreeNode root = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20,
                        new TreeNode(15),
                        new TreeNode(7)));
        System.out.println(lc.zigzagLevelOrder(root));

        root = new TreeNode(1);
        System.out.println(lc.zigzagLevelOrder(root));

        root = null;
        System.out.println(lc.zigzagLevelOrder(root));
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int level = 0;
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

            if (level % 2 != 0)
                Collections.reverse(lRes);

            res.add(lRes);
            level++;
        }

        return res;
    }
}
