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

    public static void print(ListNode head) {
        if (head == null) {
            System.out.println("NULL");
            return;
        }

        StringBuilder s = new StringBuilder();
        ListNode temp = head;
        while (temp.next != null) {
            s.append(temp.val).append(" -> ");
            temp = temp.next;
        }
        s.append(temp.val);

        System.out.println(s);
    }
}

public class RemoveNthNodeFromEndofList {
    public static void main(String[] args) {
        RemoveNthNodeFromEndofList lc = new RemoveNthNodeFromEndofList();

        ListNode h1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode.print(lc.removeNthFromEnd(h1, 2));

        ListNode h2 = new ListNode(1);
        ListNode.print(lc.removeNthFromEnd(h2, 1));

        ListNode h3 = new ListNode(1, new ListNode(2));
        ListNode.print(lc.removeNthFromEnd(h3, 1));
    }

    ListNode res;

    public ListNode removeNthFromEnd(ListNode head, int n) {
        recurse(head, n);
        return res;
    }

    private int recurse(ListNode head, int n) {
        if (head == null)
            return 1;

        int tmp = recurse(head.next, n);

        if (tmp == n) {
            res = head.next;
            return -1;
        }

        if (tmp == -1) {
            res = head;
            head.next = head.next.next;
            return -2;
        }

        if (tmp == -2) {
            res = head;
            return -2;
        }

        return tmp + 1;
    }

    public ListNode removeNthFromEndTwoPtrs(ListNode head, int n) {
        ListNode dummyNode = new ListNode(0, head);
        ListNode slow = dummyNode, fast = dummyNode;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return dummyNode.next;
    }

    public ListNode removeNthFromEndBrute(ListNode head, int n) {
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
}
