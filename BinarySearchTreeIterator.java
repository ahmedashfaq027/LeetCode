/*

https://leetcode.com/problems/binary-search-tree-iterator/

Implement the BSTIterator class that represents an iterator over the in-order traversal of a binary search tree (BST):

BSTIterator(TreeNode root) Initializes an object of the BSTIterator class. The root of the BST is given as part of the constructor. The pointer should be initialized to a non-existent number smaller than any element in the BST.
boolean hasNext() Returns true if there exists a number in the traversal to the right of the pointer, otherwise returns false.
int next() Moves the pointer to the right, then returns the number at the pointer.
Notice that by initializing the pointer to a non-existent smallest number, the first call to next() will return the smallest element in the BST.

You may assume that next() calls will always be valid. That is, there will be at least a next number in the in-order traversal when next() is called.

Constraints:
1. The number of nodes in the tree is in the range [1, 105].
2. 0 <= Node.val <= 106
3. At most 105 calls will be made to hasNext, and next.

Follow up:
Could you implement next() and hasNext() to run in average O(1) time and use O(h) memory, where h is the height of the tree?

Input
    ["BSTIterator", "next", "next", "hasNext", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
    [[[7, 3, 15, null, null, 9, 20]], [], [], [], [], [], [], [], [], []]
Output
    [null, 3, 7, true, 9, true, 15, true, 20, false]

    Explanation
        BSTIterator bSTIterator = new BSTIterator([7, 3, 15, null, null, 9, 20]);
        bSTIterator.next();    // return 3
        bSTIterator.next();    // return 7
        bSTIterator.hasNext(); // return True
        bSTIterator.next();    // return 9
        bSTIterator.hasNext(); // return True
        bSTIterator.next();    // return 15
        bSTIterator.hasNext(); // return True
        bSTIterator.next();    // return 20
        bSTIterator.hasNext(); // return False

*/

import java.util.Stack;

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

class BSTIterator {
    Stack<TreeNode> st;

    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        while (root != null) {
            st.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode node = st.pop();

        TreeNode cursor = node.right;
        while (cursor != null) {
            st.push(cursor);
            cursor = cursor.left;
        }

        return node.val;
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }
}

public class BinarySearchTreeIterator {
    public static void main(String[] args) {
        BinarySearchTreeIterator lc = new BinarySearchTreeIterator();

        TreeNode root = new TreeNode(7,
                new TreeNode(3),
                new TreeNode(15,
                        new TreeNode(9),
                        new TreeNode(20)));

        BSTIterator bSTIterator = new BSTIterator(root);
        System.out.println(bSTIterator.next());    // return 3
        System.out.println(bSTIterator.next());    // return 7
        System.out.println(bSTIterator.hasNext()); // return True
        System.out.println(bSTIterator.next());    // return 9
        System.out.println(bSTIterator.hasNext()); // return True
        System.out.println(bSTIterator.next());    // return 15
        System.out.println(bSTIterator.hasNext()); // return True
        System.out.println(bSTIterator.next());    // return 20
        System.out.println(bSTIterator.hasNext()); // return False
    }
}
