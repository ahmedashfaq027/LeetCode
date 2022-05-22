/*

https://leetcode.com/problems/print-binary-tree/

Given the root of a binary tree, construct a 0-indexed m x n string matrix res that represents a formatted layout of the tree. The formatted layout matrix should be constructed using the following rules:
1. The height of the tree is height and the number of rows m should be equal to height + 1.
2. The number of columns n should be equal to 2height+1 - 1.
3. Place the root node in the middle of the top row (more formally, at location res[0][(n-1)/2]).
4. For each node that has been placed in the matrix at position res[r][c], place its left child at res[r+1][c-2height-r-1] and its right child at res[r+1][c+2height-r-1].
5. Continue this process until all the nodes in the tree have been placed.
6. Any empty cells should contain the empty string "".

Return the constructed matrix res.

Constraints:
1. The number of nodes in the tree is in the range [1, 210].
2. -99 <= Node.val <= 99
3. The depth of the tree will be in the range [1, 10].

Input: root = [1,2]
Output:
[["","1",""],
 ["2","",""]]

Input: root = [1,2,3,null,4]
Output:
[["","","","1","","",""],
 ["","2","","","","3",""],
 ["","","4","","","",""]]

*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class PairG<T1, T2> {
    public T1 x;
    public T2 y;

    public PairG(T1 x, T2 y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Pair{x=" + x + ", y=" + y + "}";
    }
}

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

public class PrintBinaryTree {
    public static void main(String[] args) {
        PrintBinaryTree lc = new PrintBinaryTree();

        TreeNode root = new TreeNode(1,
                new TreeNode(2),
                null);
        lc.print(lc.printTree(root));

        root = new TreeNode(1,
                new TreeNode(2,
                        null,
                        new TreeNode(4)),
                new TreeNode(3));
        lc.print(lc.printTree(root));
    }

    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> res = new ArrayList<>();

        getDepth(root, 1);

        // Initialize the result list
        int totalColumns = (int) (Math.pow(2, maxDepth) - 1);
        for (int i = 0; i < maxDepth; i++) {
            List<String> tmp = new ArrayList<>();
            for (int j = 0; j < totalColumns; j++) {
                tmp.add("");
            }
            res.add(tmp);
        }

        Queue<PairG<TreeNode, Integer>> q = new LinkedList<>();
        q.add(new PairG<>(root, totalColumns / 2));

        int level = 0;
        int height = maxDepth - 1;
        while (!q.isEmpty()) {
            int n = q.size();

            for (int i = 0; i < n; i++) {
                PairG<TreeNode, Integer> tmp = q.poll();
                TreeNode nd = tmp.x;
                int col = tmp.y;

                res.get(level).set(col, String.valueOf(nd.val));

                // Left child is at (col - 2^(height - level - 1))
                if (nd.left != null) {
                    q.add(new PairG<>(nd.left, col - (int) (Math.pow(2, height - level - 1))));
                }

                // Left child is at (col + 2^(height - level - 1))
                if (nd.right != null) {
                    q.add(new PairG<>(nd.right, col + (int) (Math.pow(2, height - level - 1))));
                }

            }

            level++;
        }

        return res;
    }

    int maxDepth = 0;

    private void getDepth(TreeNode root, int depth) {
        if (root == null)
            return;

        maxDepth = Math.max(maxDepth, depth);
        getDepth(root.left, depth + 1);
        getDepth(root.right, depth + 1);
    }

    public void print(List<List<String>> twoDList) {
        for (List<String> i : twoDList) {
            for (String j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        System.out.println();
    }
}
