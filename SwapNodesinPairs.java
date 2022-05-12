/*

https://leetcode.com/problems/swap-nodes-in-pairs/

Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)

Constraints:
1. The number of nodes in the list is in the range [0, 100].
2. 0 <= Node.val <= 100

Input: head = [1,2,3,4]
Output: [2,1,4,3]

Input: head = []
Output: []

Input: head = [1]
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

public class SwapNodesinPairs {
    public static void main(String[] args) {
        SwapNodesinPairs lc = new SwapNodesinPairs();

        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode.print(lc.swapPairs(head));

        head = null;
        ListNode.print(lc.swapPairs(head));

        head = new ListNode(1);
        ListNode.print(lc.swapPairs(head));
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;

        return reverseKNodes(head, 2);
    }

    private ListNode reverseKNodes(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;

        ListNode prev = null, curr = head, next = null;

        int i = k;
        while (i-- > 0) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head.next = reverseKNodes(curr, k);

        return prev;
    }

    public ListNode swapPairsRecurse(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode next = head.next;
        head.next = swapPairsRecurse(head.next.next);
        next.next = head;

        return next;
    }

    public ListNode swapPairsIter(ListNode head) {
        ListNode dummyNode = new ListNode(0, head);

        ListNode prev = dummyNode, curr = head, next = null;
        while (curr != null && curr.next != null) {
            next = curr.next;
            prev.next = next;
            curr.next = next.next;
            next.next = curr;

            prev = curr;
            curr = curr.next;
        }

        return dummyNode.next;
    }
}
