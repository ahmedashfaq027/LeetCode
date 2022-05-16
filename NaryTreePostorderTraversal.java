/*

https://leetcode.com/problems/n-ary-tree-postorder-traversal/

Given the root of an n-ary tree, return the preorder traversal of its nodes' values.

Nary-Tree input serialization is represented in their level order traversal. Each group of children is separated by the null value (See examples)

Constraints:
1. The number of nodes in the tree is in the range [0, 104].
2. 0 <= Node.val <= 104
3. The height of the n-ary tree is less than or equal to 1000.

Follow up: Recursive solution is trivial, could you do it iteratively?

Input: root = [1,null,3,2,4,null,5,6]
Output: [5,6,3,2,4,1]
    Explanation:            1
                  3         2           4
               5    6

Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
Output: [2,6,14,11,7,3,12,8,4,13,9,10,5,1]
    Explanation:                1
                    2       3           4           5
                          6   7         8           9
                              11        12          13
                              14

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

public class NaryTreePostorderTraversal {
    public static void main(String[] args) {
        NaryTreePostorderTraversal lc = new NaryTreePostorderTraversal();

        Node root = new Node(1,
                new ArrayList<>(Arrays.asList(
                        new Node(3, new ArrayList<>(Arrays.asList(
                                new Node(5),
                                new Node(6)))),
                        new Node(2),
                        new Node(4))));
        System.out.println(lc.postorder(root));

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
        System.out.println(lc.postorder(root));
    }

    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        postOrder(root, res);
        return res;
    }

    private void postOrder(Node root, List<Integer> res) {
        if (root == null)
            return;

        if (root.children != null) {
            for (Node i : root.children) {
                postOrder(i, res);
            }
        }

        res.add(root.val);
    }
}
