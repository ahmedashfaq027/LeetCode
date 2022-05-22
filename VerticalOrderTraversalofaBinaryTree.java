/*

https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/

Given the root of a binary tree, calculate the vertical order traversal of the binary tree.
For each node at position (row, col), its left and right children will be at positions (row + 1, col - 1) and (row + 1, col + 1) respectively. The root of the tree is at (0, 0).
The vertical order traversal of a binary tree is a list of top-to-bottom orderings for each column index starting from the leftmost column and ending on the rightmost column. There may be multiple nodes in the same row and same column. In such a case, sort these nodes by their values.

Return the vertical order traversal of the binary tree.

Constraints:
1. The number of nodes in the tree is in the range [1, 1000].
2. 0 <= Node.val <= 1000

Input: root = [3,9,20,null,null,15,7]
Output: [[9],[3,15],[20],[7]]
    Explanation:
    Column -1: Only node 9 is in this column.
    Column 0: Nodes 3 and 15 are in this column in that order from top to bottom.
    Column 1: Only node 20 is in this column.
    Column 2: Only node 7 is in this column.

Input: root = [1,2,3,4,5,6,7]
Output: [[4],[2],[1,5,6],[3],[7]]
    Explanation:
    Column -2: Only node 4 is in this column.
    Column -1: Only node 2 is in this column.
    Column 0: Nodes 1, 5, and 6 are in this column.
              1 is at the top, so it comes first.
              5 and 6 are at the same position (2, 0), so we order them by their value, 5 before 6.
    Column 1: Only node 3 is in this column.
    Column 2: Only node 7 is in this column.

Input: root = [1,2,3,4,6,5,7]
Output: [[4],[2],[1,5,6],[3],[7]]

*/

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class VerticalOrderTraversalofaBinaryTree {
    public static void main(String[] args) {
        VerticalOrderTraversalofaBinaryTree lc = new VerticalOrderTraversalofaBinaryTree();

        PrintBinaryTree print = new PrintBinaryTree();

        TreeNode root = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20,
                        new TreeNode(15),
                        new TreeNode(7)));
        print.print(print.printTree(root));
        System.out.println(lc.verticalTraversal(root));

        root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(5)),
                new TreeNode(3,
                        new TreeNode(6),
                        new TreeNode(7)));
        print.print(print.printTree(root));
        System.out.println(lc.verticalTraversal(root));
    }

    TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;

        findAll(root, 0, 0);

        for (TreeMap<Integer, PriorityQueue<Integer>> i : map.values()) {
            List<Integer> tmp = new ArrayList<>();
            for (PriorityQueue<Integer> j : i.values()) {
                while (!j.isEmpty()) {
                    tmp.add(j.poll());
                }
            }
            res.add(tmp);
        }

        return res;
    }

    private void findAll(TreeNode root, int level, int col) {
        if (root == null)
            return;

        TreeMap<Integer, PriorityQueue<Integer>> tmp = map.getOrDefault(col, new TreeMap<>());
        PriorityQueue<Integer> q = tmp.getOrDefault(level, new PriorityQueue<>());
        q.add(root.val);
        tmp.put(level, q);
        map.put(col, tmp);

        findAll(root.left, level + 1, col - 1);
        findAll(root.right, level + 1, col + 1);
    }
}
