/*

https://leetcode.com/problems/linked-list-cycle/

Given head, the head of a linked list, determine if the linked list has a cycle in it.
There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.

Constraints:
1. The number of the nodes in the list is in the range [0, 104].
2. -105 <= Node.val <= 105
3. pos is -1 or a valid index in the linked-list.

Follow up: Can you solve it using O(1) (i.e. constant) memory?

Input: head = [3,2,0,-4], pos = 1
Output: true
    Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).

Input: head = [1,2], pos = 0
Output: true
    Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.

Input: head = [1], pos = -1
Output: false
    Explanation: There is no cycle in the linked list.

*/

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
        next = null;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static void print(ListNode head) {
        if (head == null)
            System.out.println("NULL");

        StringBuilder s = new StringBuilder();
        ListNode temp = head;
        while (temp.next != null) {
            s.append(temp.val).append(" -> ");
            temp = temp.next;
        }
        s.append(temp.val).append(" -> ");

        System.out.println(s);
    }
}

public class LinkedListCycle {
    public static void main(String[] args) {
        LinkedListCycle lc = new LinkedListCycle();

        /* 3 -> 2 -> 0 -> 4
                |---------| */
        ListNode tmp = new ListNode(2, new ListNode(0));
        tmp.next.next = new ListNode(-4, tmp);
        ListNode head = new ListNode(3, tmp);
        System.out.println(lc.hasCycle(head));

        /* 1 -> 2
           |----| */
        tmp = new ListNode(2);
        head = new ListNode(1, tmp);
        tmp.next = head;
        System.out.println(lc.hasCycle(head));

        /* 1 -> null */
        head = new ListNode(1);
        System.out.println(lc.hasCycle(head));
    }

    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow)
                return true;
        }

        return false;
    }
}
