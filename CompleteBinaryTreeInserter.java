/*

https://leetcode.com/problems/complete-binary-tree-inserter/

A complete binary tree is a binary tree in which every level, except possibly the last, is completely filled, and all nodes are as far left as possible.
Design an algorithm to insert a new node to a complete binary tree keeping it complete after the insertion.

Implement the CBTInserter class:
1. CBTInserter(TreeNode root) Initializes the data structure with the root of the complete binary tree.
2. int insert(int v) Inserts a TreeNode into the tree with value Node.val == val so that the tree remains complete, and returns the value of the parent of the inserted TreeNode.
3. TreeNode get_root() Returns the root node of the tree.

Constraints:
1. The number of nodes in the tree will be in the range [1, 1000].
2. 0 <= Node.val <= 5000
3. root is a complete binary tree.
4. 0 <= val <= 5000
5. At most 104 calls will be made to insert and get_root.

Input
    ["CBTInserter", "insert", "insert", "get_root"]
    [[[1, 2]], [3], [4], []]
Output
    [null, 1, 2, [1, 2, 3, 4]]

    Explanation
        CBTInserter cBTInserter = new CBTInserter([1, 2]);
        cBTInserter.insert(3);  // return 1
        cBTInserter.insert(4);  // return 2
        cBTInserter.get_root(); // return [1, 2, 3, 4]

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

class CBTInserter {
    Queue<TreeNode> q;
    TreeNode root;

    public CBTInserter(TreeNode root) {
        q = new LinkedList<>();
        q.add(root);
        this.root = root;

        boolean lastLevel = false;
        while (!lastLevel) {
            TreeNode tmp = q.peek();

            if (tmp.left != null) {
                q.add(tmp.left);
            } else {
                lastLevel = true;
            }

            if (tmp.right != null) {
                q.add(tmp.right);
                q.remove();
            } else {
                lastLevel = true;
            }
        }
    }

    public int insert(int val) {
        TreeNode node = new TreeNode(val);

        if (q.peek().left != null && q.peek().right != null)
            q.remove();

        TreeNode parent = q.peek();
        if (parent.left == null) {
            parent.left = node;
        } else {
            parent.right = node;
        }

        q.add(node);
        return parent.val;
    }

    public TreeNode get_root() {
        return root;
    }
}

public class CompleteBinaryTreeInserter {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2),
                null);

        CBTInserter cBTInserter = new CBTInserter(root);
        System.out.println(cBTInserter.insert(3));  // return 1
        System.out.println(cBTInserter.insert(4));  // return 2
        System.out.println(cBTInserter.get_root()); // return [1, 2, 3, 4]
    }
}
