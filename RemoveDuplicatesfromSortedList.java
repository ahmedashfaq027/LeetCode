/*

https://leetcode.com/problems/remove-duplicates-from-sorted-list/

Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.

Constraints:
1. The number of nodes in the list is in the range [0, 300].
2. -100 <= Node.val <= 100
3. The list is guaranteed to be sorted in ascending order.

Input: head = [1,1,2]
Output: [1,2]

Input: head = [1,1,2,3,3]
Output: [1,2,3]

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

public class RemoveDuplicatesfromSortedList {
    public static void main(String[] args) {
        RemoveDuplicatesfromSortedList lc = new RemoveDuplicatesfromSortedList();

        ListNode head = new ListNode(1, new ListNode(1, new ListNode(2)));
        ListNode.print(lc.deleteDuplicates(head));

        head = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3)))));
        ListNode.print(lc.deleteDuplicates(head));

        head = new ListNode(1, new ListNode(1, new ListNode(1)));
        ListNode.print(lc.deleteDuplicates(head));
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        while (temp != null && temp.next != null) {
            if (temp.val == temp.next.val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }


        return head;
    }
}
