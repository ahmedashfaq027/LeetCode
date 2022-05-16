/*

https://leetcode.com/problems/binary-tree-inorder-traversal/

Given the root of a binary tree, return the inorder traversal of its nodes' values.

Constraints:
1. The number of nodes in the tree is in the range [0, 100].
2. -100 <= Node.val <= 100

Follow up: Recursive solution is trivial, could you do it iteratively?

Input: root = [1,null,2,3]
Output: [1,3,2]
    Explanation:           1
                               2
                           3

Input: root = []
Output: []

Input: root = [1]
Output: [1]

*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

public class NaryTreePreorderTraversal {
    public static void main(String[] args) {
        NaryTreePreorderTraversal lc = new NaryTreePreorderTraversal();

        Node root = new Node(1,
                new ArrayList<>(Arrays.asList(
                        new Node(3, new ArrayList<>(Arrays.asList(
                                new Node(5),
                                new Node(6)))),
                        new Node(2),
                        new Node(4))));
        System.out.println(lc.preorder(root));

        root = new Node(1,
                new ArrayList<>(Arrays.asList(
                        new Node(2),
                        new Node(3, new ArrayList<>(Arrays.asList(
                                new Node(6),
                                new Node(7, new ArrayList<>(Arrays.asList(
                                        new Node(11, new ArrayList<>(Arrays.asList(
                                                new Node(14))))
                                )))
                        ))),
                        new Node(4, new ArrayList<>(Arrays.asList(
                                new Node(8, new ArrayList<>(Arrays.asList(
                                        new Node(12))))
                        ))),
                        new Node(5, new ArrayList<>(Arrays.asList(
                                new Node(9, new ArrayList<>(Arrays.asList(
                                        new Node(13)
                                ))),
                                new Node(10)
                        )))
                )));
        System.out.println(lc.preorder(root));
    }

    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        preOrder(root, res);
        return res;
    }

    private void preOrder(Node root, List<Integer> res) {
        if (root == null)
            return;

        res.add(root.val);

        if (root.children != null) {
            for (Node i : root.children) {
                preOrder(i, res);
            }
        }
    }
}
