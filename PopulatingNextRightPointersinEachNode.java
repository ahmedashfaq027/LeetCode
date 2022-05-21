/*

https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:
struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Constraints:
1. The number of nodes in the tree is in the range [0, 212 - 1].
2. -1000 <= Node.val <= 1000

Follow-up:
1. You may only use constant extra space.
2. The recursive approach is fine. You may assume implicit stack space does not count as extra space for this problem.

Input: root = [1,2,3,4,5,6,7]
Output: [1,#,2,3,#,4,5,6,7,#]
    Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.

Input: root = []
Output: []

*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class NodeTree {
    public int val;
    public NodeTree left;
    public NodeTree right;
    public NodeTree next;

    public NodeTree(int _val) {
        val = _val;
    }

    public NodeTree(int _val, NodeTree _left, NodeTree _right, NodeTree _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

public class PopulatingNextRightPointersinEachNode {
    public static void main(String[] args) {
        PopulatingNextRightPointersinEachNode lc = new PopulatingNextRightPointersinEachNode();

        NodeTree root = new NodeTree(1,
                new NodeTree(2,
                        new NodeTree(4),
                        new NodeTree(5),
                        null),
                new NodeTree(3,
                        new NodeTree(6),
                        new NodeTree(7),
                        null),
                null);

        NodeTree res = lc.connect(root);
        System.out.println(lc.printLevelOrder(res));
    }

    public NodeTree connect(NodeTree root) {
        if (root == null)
            return root;

        Queue<NodeTree> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int n = q.size();

            NodeTree prev = null;
            for (int i = 0; i < n; i++) {
                NodeTree tmp = q.poll();

                if (prev != null)
                    prev.next = tmp;

                if (tmp.left != null)
                    q.add(tmp.left);

                if (tmp.right != null)
                    q.add(tmp.right);

                prev = tmp;
            }
        }

        return root;
    }

    private List<Integer> printLevelOrder(NodeTree root) {
        List<Integer> res = new ArrayList<>();

        if (root == null)
            return res;

        Queue<NodeTree> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int n = q.size();

            NodeTree head = q.peek();
            while (head != null) {
                res.add(head.val);
                head = head.next;
            }

            for (int i = 0; i < n; i++) {
                NodeTree tmp = q.poll();

                if (tmp.left != null)
                    q.add(tmp.left);

                if (tmp.right != null)
                    q.add(tmp.right);
            }

            res.add(null);
        }

        return res;
    }
}
