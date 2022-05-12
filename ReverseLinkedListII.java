/*

https://leetcode.com/problems/reverse-linked-list-ii/

Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.

Constraints:
1. The number of nodes in the list is n.
2. 1 <= n <= 500
3. -500 <= Node.val <= 500
4. 1 <= left <= right <= n

Follow up: Could you do it in one pass?

Input: head = [1,2,3,4,5], left = 2, right = 4
Output: [1,4,3,2,5]

Input: head = [5], left = 1, right = 1
Output: [5]

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

public class ReverseLinkedListII {
    public static void main(String[] args) {
        ReverseLinkedListII lc = new ReverseLinkedListII();

        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        lc.reverseBetween(head, 2, 4);
        ListNode.print(head);

        head = new ListNode(5);
        ListNode.print(lc.reverseBetween(head, 1, 1));
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null)
            return head;

        ListNode leftPrev = null, leftNode = head;
        for (int i = 1; i < left; i++) {
            leftPrev = leftNode;
            leftNode = leftNode.next;
        }

        ListNode rightNext = head;
        for (int i = 0; i < right; i++) {
            rightNext = rightNext.next;
        }

        int k = right - left + 1;
        if (leftPrev == null) {
            head = reverseKNodes(head, k);
        } else {
            leftPrev.next = reverseKNodes(leftNode, k);
        }

        if (rightNext != null) {
            leftNode.next = rightNext;
        }

        return head;
    }

    private ListNode reverseKNodes(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;

        ListNode prev = null, curr = head, next = null;
        while (k-- > 0) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
