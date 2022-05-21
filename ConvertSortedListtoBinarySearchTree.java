/*

https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/

Given the head of a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Constraints:
1. The number of nodes in head is in the range [0, 2 * 104].
2. -105 <= Node.val <= 105

Input: head = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
    Explanation: One possible answer is [0,-3,9,-10,null,5], which represents the shown height balanced BST.

Input: head = []
Output: []

*/

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
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

public class ConvertSortedListtoBinarySearchTree {
    public static void main(String[] args) {
        ConvertSortedListtoBinarySearchTree lc = new ConvertSortedListtoBinarySearchTree();

        BinaryTreeLevelOrderTraversal print = new BinaryTreeLevelOrderTraversal();

        ListNode head = new ListNode(-10, new ListNode(-3, new ListNode(0, new ListNode(5, new ListNode(9)))));
        TreeNode res = lc.sortedListToBST(head);
        System.out.println(print.levelOrder(res));

        head = null;
        res = lc.sortedListToBST(head);
        System.out.println(print.levelOrder(res));
    }

    /*
        Explanation:
            Using slow and fast pointers, we can navigate till the mid element.
            Hence maintain a previous to make its next null and next of fast to null.
            So we have 2 heads now. Slow element is the root node.
            We recurse to form the remaining nodes.
    */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;

        if (head.next == null)
            return new TreeNode(head.val);

        ListNode prev = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode head2 = slow.next;
        prev.next = null;
        slow.next = null;

        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(head2);

        return root;
    }
}
