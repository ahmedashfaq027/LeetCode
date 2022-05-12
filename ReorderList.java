/*

https://leetcode.com/problems/reorder-list/

You are given the head of a singly linked-list. The list can be represented as:
L0 → L1 → … → Ln - 1 → Ln

Reorder the list to be on the following form:
L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …

You may not modify the values in the list's nodes. Only nodes themselves may be changed.

Constraints:
1. The number of nodes in the list is in the range [1, 5 * 104].
2. 1 <= Node.val <= 1000

Input: head = [1,2,3,4]
Output: [1,4,2,3]

Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]

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

public class ReorderList {
    public static void main(String[] args) {
        ReorderList lc = new ReorderList();

        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        lc.reorderList(head);
        ListNode.print(head);

        head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        lc.reorderList(head);
        ListNode.print(head);
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;

        ListNode temp = null;
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        temp.next = null;

        slow = reverseList(slow);
        ListNode.print(slow);
        mergeLists(head, slow);
    }

    private void mergeLists(ListNode l1, ListNode l2) {
        while (l2 != null) {
            ListNode tmp = l1.next;
            l1.next = l2;
            l1 = l2;
            l2 = tmp;
        }
    }

    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode prev = null, curr = head, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
