/*

https://leetcode.com/problems/remove-linked-list-elements/

Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.

Constraints:
1. The number of nodes in the list is in the range [0, 104].
2. 1 <= Node.val <= 50
3. 0 <= val <= 50

Input: head = [1,2,6,3,4,5,6], val = 6
Output: [1,2,3,4,5]

Input: head = [], val = 1
Output: []

Input: head = [7,7,7,7], val = 7
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

public class RemoveLinkedListElements {
    public static void main(String[] args) {
        RemoveLinkedListElements lc = new RemoveLinkedListElements();

        ListNode head = new ListNode(1, new ListNode(2, new ListNode(6, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6)))))));
        ListNode.print(lc.removeElements(head, 6));

        head = null;
        ListNode.print(lc.removeElements(head, 1));

        head = new ListNode(7, new ListNode(7, new ListNode(7, new ListNode(7))));
        ListNode.print(lc.removeElements(head, 7));
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return null;

        ListNode temp = head, prev = null;
        while (temp != null) {
            if (temp.val == val) {
                if (prev == null) {
                    head = head.next;
                    temp = head;
                } else {
                    prev.next = temp.next;
                    temp = temp.next;
                }
            } else {
                prev = temp;
                temp = temp.next;
            }
        }

        return head;
    }
}
