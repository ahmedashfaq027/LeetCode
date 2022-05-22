/*

https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/

Given the root of a binary tree, the value of a target node target, and an integer k, return an array of the values of all nodes that have a distance k from the target node.
You can return the answer in any order.

Constraints:
1. The number of nodes in the tree is in the range [1, 500].
2. 0 <= Node.val <= 500
3. All the values Node.val are unique.
4. target is the value of one of the nodes in the tree.
5. 0 <= k <= 1000

Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
Output: [7,4,1]
    Explanation: The nodes that are a distance 2 from the target node (with value 5) have values 7, 4, and 1.

Input: root = [1], target = 1, k = 3
Output: []

*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

public class AllNodesDistanceKinBinaryTree {
    public static void main(String[] args) {
        AllNodesDistanceKinBinaryTree lc = new AllNodesDistanceKinBinaryTree();

        PrintBinaryTree print = new PrintBinaryTree();

        TreeNode target = new TreeNode(5,
                new TreeNode(6),
                new TreeNode(2,
                        new TreeNode(7),
                        new TreeNode(4)));
        TreeNode root = new TreeNode(3,
                target,
                new TreeNode(1,
                        new TreeNode(0),
                        new TreeNode(8)));

        print.print(print.printTree(root));
        System.out.println(lc.distanceK(root, target, 2));

        root = new TreeNode(1);
        System.out.println(lc.distanceK(root, root, 3));
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        if (k == 0) {
            res.add(target.val);
            return res;
        }

        solve(root, target, k, new HashSet<>(), res);

        return res;
    }

    private int solve(TreeNode root, TreeNode target, int k, Set<TreeNode> set, List<Integer> res) {
        if (root == null)
            return -1;

        if (root.val == target.val) {
            set.add(root);
            dfs(root.left, k - 1, set, res);
            dfs(root.right, k - 1, set, res);
            return 1;
        }

        int leftVal = solve(root.left, target, k, set, res);
        if (leftVal != -1) {
            dfs(root, k - leftVal, set, res);
            return leftVal + 1;
        }

        int rightVal = solve(root.right, target, k, set, res);
        if (rightVal != -1) {
            dfs(root, k - rightVal, set, res);
            return rightVal + 1;
        }

        return -1;
    }

    private void dfs(TreeNode root, int k, Set<TreeNode> set, List<Integer> res) {
        if (root == null || set.contains(root))
            return;

        if (k == 0) {
            res.add(root.val);
            return;
        }

        dfs(root.left, k - 1, set, res);
        dfs(root.right, k - 1, set, res);
        set.add(root);
    }
}
