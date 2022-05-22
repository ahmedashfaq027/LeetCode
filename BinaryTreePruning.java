/*

https://leetcode.com/problems/binary-tree-pruning/

Given the root of a binary tree, return the same tree where every subtree (of the given tree) not containing a 1 has been removed.
A subtree of a node node is node plus every node that is a descendant of node.

Constraints:
1. The number of nodes in the tree is in the range [1, 200].
2. Node.val is either 0 or 1.

Input: root = [1,null,0,0,1]
Output: [1,null,0,null,1]
    Explanation:
    Only the red nodes satisfy the property "every subtree not containing a 1".
    The diagram on the right represents the answer.

Input: root = [1,0,1,0,0,0,1]
Output: [1,null,1,null,1]

Input: root = [1,1,0,1,1,0,1,0]
Output: [1,1,0,1,1,null,1]

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

public class BinaryTreePruning {
    public static void main(String[] args) {
        BinaryTreePruning lc = new BinaryTreePruning();

        PrintBinaryTree print = new PrintBinaryTree();

        TreeNode root = new TreeNode(1,
                null,
                new TreeNode(0,
                        new TreeNode(0),
                        new TreeNode(1)));
        print.print(print.printTree(root));
        TreeNode res = lc.pruneTree(root);
        print.print(print.printTree(root));

        root = new TreeNode(1,
                new TreeNode(0,
                        new TreeNode(0),
                        new TreeNode(0)),
                new TreeNode(1,
                        new TreeNode(0),
                        new TreeNode(1)));
        print.print(print.printTree(root));
        res = lc.pruneTree(root);
        print.print(print.printTree(root));

        root = new TreeNode(1,
                new TreeNode(1,
                        new TreeNode(1,
                                new TreeNode(0),
                                null),
                        new TreeNode(1)),
                new TreeNode(0,
                        new TreeNode(0),
                        new TreeNode(1)));
        print.print(print.printTree(root));
        res = lc.pruneTree(root);
        print.print(print.printTree(root));
    }

    public TreeNode pruneTree(TreeNode root) {
        if (root == null)
            return null;

        boolean containsOne = containsOne(root);
        if (!containsOne)
            root = null;

        return root;
    }

    private boolean containsOne(TreeNode root) {
        if (root == null)
            return false;

        boolean leftContains = containsOne(root.left);
        boolean rightContains = containsOne(root.right);

        if (!leftContains)
            root.left = null;

        if (!rightContains)
            root.right = null;

        return root.val == 1 || leftContains || rightContains;
    }
}
