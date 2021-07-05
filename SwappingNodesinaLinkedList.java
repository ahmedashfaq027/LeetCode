/*

https://leetcode.com/problems/swapping-nodes-in-a-linked-list/

You are given the head of a linked list, and an integer k.
Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node from the end (the list is 1-indexed).

Constraints:
1. The number of nodes in the list is n.
2. 1 <= k <= n <= 105
3. 0 <= Node.val <= 100

Input: head = [1,2,3,4,5], k = 2
Output: [1,4,3,2,5]

Input: head = [7,9,6,6,7,8,3,0,9,5], k = 5
Output: [7,9,6,6,8,7,3,0,9,5]

Input: head = [1], k = 1
Output: [1]

Input: head = [1,2], k = 1
Output: [2,1]

Input: head = [1,2,3], k = 2
Output: [1,2,3]

*/

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class SwappingNodesinaLinkedList {
    public static void main(String[] args) {
        SwappingNodesinaLinkedList lc = new SwappingNodesinaLinkedList();

        ListNode h1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        lc.printLL(lc.swapNodes(h1, 2));

        ListNode h2 = new ListNode(1);
        lc.printLL(lc.swapNodes(h2, 1));

        ListNode h3 = new ListNode(1, new ListNode(2));
        lc.printLL(lc.swapNodes(h3, 1));

        ListNode h4 = new ListNode(7, new ListNode(9, new ListNode(6, new ListNode(6, new ListNode(7, new ListNode(8, new ListNode(3, new ListNode(0, new ListNode(9, new ListNode(5))))))))));
        lc.printLL(lc.swapNodesOptimal(h4, 5));
    }

    public ListNode swapNodesOptimal(ListNode head, int k) {
        ListNode slow, fast, first;
        slow = fast = first = head;

        while (fast.next != null) {
            if (k > 1) {
                fast = fast.next;
                first = fast;
                k--;
            } else {
                slow = slow.next;
                fast = fast.next;
            }
        }

        slow.val = slow.val ^ first.val ^ (first.val = slow.val);

        return head;
    }

    public ListNode swapNodes(ListNode head, int k) {
        int len = lengthLL(head);

        int idx1 = k - 1, idx2 = len - k;
        ListNode tmp1 = head, tmp2 = head;

        for (int i = 0; i < len; i++) {
            if (i < idx1) {
                tmp1 = tmp1.next;
            }
            if (i < idx2) {
                tmp2 = tmp2.next;
            }
        }

        tmp1.val = tmp1.val ^ tmp2.val ^ (tmp2.val = tmp1.val);

        return head;
    }

    private int lengthLL(ListNode h) {
        int len = 0;
        while (h != null) {
            len++;
            h = h.next;
        }
        return len;
    }

    private void printLL(ListNode h) {
        while (h != null) {
            System.out.print(h.val + " ");
            h = h.next;
        }
        System.out.println();
    }
}
