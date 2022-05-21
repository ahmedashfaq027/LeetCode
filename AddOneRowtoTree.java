/*

https://leetcode.com/problems/add-one-row-to-tree/

Given the root of a binary tree and two integers val and depth, add a row of nodes with value val at the given depth depth.
Note that the root node is at depth 1.

The adding rule is:
1. Given the integer depth, for each not null tree node cur at the depth depth - 1, create two tree nodes with value val as cur's left subtree root and right subtree root.
2. cur's original left subtree should be the left subtree of the new left subtree root.
3. cur's original right subtree should be the right subtree of the new right subtree root.
4. If depth == 1 that means there is no depth depth - 1 at all, then create a tree node with value val as the new root of the whole original tree, and the original tree is the new root's left subtree.

Constraints:
1. The number of nodes in the tree is in the range [1, 104].
2. The depth of the tree is in the range [1, 104].
3. -100 <= Node.val <= 100
4. -105 <= val <= 105
5. 1 <= depth <= the depth of tree + 1

Input: root = [4,2,6,3,1,5], val = 1, depth = 2
Output: [4,1,1,2,null,null,6,3,1,5]

Input: root = [4,2,null,3,1], val = 1, depth = 3
Output: [4,2,null,1,1,3,null,null,1]

*/

import java.util.LinkedList;
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

public class AddOneRowtoTree {
    public static void main(String[] args) {
        AddOneRowtoTree lc = new AddOneRowtoTree();

        TreeNode root = new TreeNode(4,
                new TreeNode(2,
                        new TreeNode(3),
                        new TreeNode(1)),
                new TreeNode(6,
                        new TreeNode(5),
                        null));
        TreeNode res = lc.addOneRow(root, 1, 2);

        root = new TreeNode(4,
                new TreeNode(2,
                        new TreeNode(3),
                        new TreeNode(1)),
                null);
        res = lc.addOneRow(root, 1, 3);
    }

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }

        int level = 0;
        while (!q.isEmpty()) {
            int n = q.size();
            level++;

            for (int i = 0; i < n; i++) {
                TreeNode tmp = q.poll();
                TreeNode left = tmp.left;
                TreeNode right = tmp.right;

                if (left != null)
                    q.add(left);

                if (right != null)
                    q.add(right);

                if (level == depth - 1) {
                    tmp.left = new TreeNode(val);
                    tmp.left.left = left;
                    tmp.right = new TreeNode(val);
                    tmp.right.right = right;
                }
            }
        }

        return root;
    }
}
