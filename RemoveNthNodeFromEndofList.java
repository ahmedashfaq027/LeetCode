/*

https://leetcode.com/problems/remove-nth-node-from-end-of-list/

Given the head of a linked list, remove the nth node from the end of the list and return its head.

Constraints:
1. The number of nodes in the list is sz.
2. 1 <= sz <= 30
3. 0 <= Node.val <= 100
4. 1 <= n <= sz

Follow up: Could you do this in one pass?

Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]

Input: head = [1], n = 1
Output: []

Input: head = [1,2], n = 1
Output: [1]

*/

public class ListNode {
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

public class RemoveNthNodeFromEndofList {
    public static void main(String[] args) {
        RemoveNthNodeFromEndofList lc = new RemoveNthNodeFromEndofList();

        ListNode h1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        lc.printLL(lc.removeNthFromEnd(h1, 2));

        ListNode h2 = new ListNode(1);
        lc.printLL(lc.removeNthFromEnd(h2, 1));

        ListNode h3 = new ListNode(1, new ListNode(2));
        lc.printLL(lc.removeNthFromEnd(h3, 1));
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = lengthLL(head);
        int idxToRemove = length - n;

        int idx = 0;
        ListNode tmp = head, prev = null;
        while (idx != idxToRemove) {
            idx++;
            prev = tmp;
            tmp = tmp.next;
        }

        if (prev == null)
            head = head.next;
        else
            prev.next = tmp.next;

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
