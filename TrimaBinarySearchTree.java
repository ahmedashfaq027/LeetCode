/*

https://leetcode.com/problems/trim-a-binary-search-tree/

Given the root of a binary search tree and the lowest and highest boundaries as low and high, trim the tree so that all its elements lies in [low, high]. Trimming the tree should not change the relative structure of the elements that will remain in the tree (i.e., any node's descendant should remain a descendant). It can be proven that there is a unique answer.
Return the root of the trimmed binary search tree. Note that the root may change depending on the given bounds.

Constraints:
1. The number of nodes in the tree is in the range [1, 104].
2. 0 <= Node.val <= 104
3. The value of each node in the tree is unique.
4. root is guaranteed to be a valid binary search tree.
5. 0 <= low <= high <= 104

Input: root = [1,0,2], low = 1, high = 2
Output: [1,null,2]

Input: root = [3,0,4,null,2,null,null,1], low = 1, high = 3
Output: [3,2,null,1]

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

public class TrimaBinarySearchTree {
    public static void main(String[] args) {
        TrimaBinarySearchTree lc = new TrimaBinarySearchTree();

        PrintBinaryTree print = new PrintBinaryTree();

        TreeNode root = new TreeNode(1,
                new TreeNode(0),
                new TreeNode(2));
        print.print(print.printTree(root));
        print.print(print.printTree(lc.trimBST(root, 1, 2)));
        System.out.println();

        root = new TreeNode(3,
                new TreeNode(0,
                        null,
                        new TreeNode(2,
                                new TreeNode(1),
                                null)),
                new TreeNode(4));
        print.print(print.printTree(root));
        print.print(print.printTree(lc.trimBST(root, 1, 3)));
    }

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null)
            return null;

        if (root.val < low) {
            return trimBST(root.right, low, high);
        }

        if (root.val > high) {
            return trimBST(root.left, low, high);
        }

        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);

        return root;
    }
}
