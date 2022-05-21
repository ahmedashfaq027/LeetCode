/*

https://leetcode.com/problems/symmetric-tree/

Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

Constraints:
1. The number of nodes in the tree is in the range [1, 1000].
2. -100 <= Node.val <= 100

Follow up: Could you solve it both recursively and iteratively?

Input: root = [1,2,2,3,4,4,3]
Output: true

Input: root = [1,2,2,null,3,null,3]
Output: false

*/

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
    public static void main(String[] args) {
        SymmetricTree lc = new SymmetricTree();

        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(3),
                        new TreeNode(4)),
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(3)));
        System.out.println(lc.isSymmetric(root));

        root = new TreeNode(1,
                new TreeNode(2,
                        null,
                        new TreeNode(3)),
                new TreeNode(2,
                        null,
                        new TreeNode(3)));
        System.out.println(lc.isSymmetric(root));
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;

        Queue<TreeNode> leftQ = new LinkedList<>(), rightQ = new LinkedList<>();

        leftQ.add(root);
        rightQ.add(root);

        while (!leftQ.isEmpty()) {
            TreeNode tmpLeft = leftQ.poll();
            TreeNode tmpRight = rightQ.poll();

            if (tmpLeft == null && tmpRight == null) {
                continue;
            }

            if (tmpLeft == null || tmpRight == null) {
                return false;
            }

            if (tmpLeft.val != tmpRight.val) {
                return false;
            }

            leftQ.add(tmpLeft.right);
            rightQ.add(tmpRight.left);
            leftQ.add(tmpLeft.left);
            rightQ.add(tmpRight.right);
        }

        return true;
    }

    public boolean isSymmetricRecursive(TreeNode root) {
        if (root == null)
            return true;

        return checkSymmetric(root.left, root.right);
    }

    private boolean checkSymmetric(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null)
            return true;

        if (t1 == null || t2 == null)
            return false;

        return (t1.val == t2.val) &&
                checkSymmetric(t1.left, t2.right) &&
                checkSymmetric(t1.right, t2.left);
    }
}
