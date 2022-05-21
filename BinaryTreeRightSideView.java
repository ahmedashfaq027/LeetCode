/*

https://leetcode.com/problems/binary-tree-right-side-view/

Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

Constraints:
1. The number of nodes in the tree is in the range [0, 100].
2. -100 <= Node.val <= 100

Input: root = [1,2,3,null,5,null,4]
Output: [1,3,4]

Input: root = [1,null,3]
Output: [1,3]

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

public class BinaryTreeRightSideView {
    public static void main(String[] args) {
        BinaryTreeRightSideView lc = new BinaryTreeRightSideView();

        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        null,
                        new TreeNode(5)),
                new TreeNode(3,
                        null,
                        new TreeNode(4)));
        System.out.println(lc.rightSideView(root));

        root = new TreeNode(1,
                null,
                new TreeNode(3));
        System.out.println(lc.rightSideView(root));

        root = null;
        System.out.println(lc.rightSideView(root));
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (root == null)
            return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int n = q.size();

            TreeNode tmp = null;
            for (int i = 0; i < n; i++) {
                tmp = q.poll();

                if (tmp.left != null)
                    q.add(tmp.left);

                if (tmp.right != null)
                    q.add(tmp.right);
            }

            res.add(tmp.val);
        }

        return res;
    }
}
