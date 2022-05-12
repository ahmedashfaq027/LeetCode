/*

https://leetcode.com/problems/linked-list-cycle-ii/

Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.
Do not modify the linked list.

Constraints:
1. The number of the nodes in the list is in the range [0, 104].
2. -105 <= Node.val <= 105
3. pos is -1 or a valid index in the linked-list.

Follow up: Can you solve it using O(1) (i.e. constant) memory?

Input: head = [3,2,0,-4], pos = 1
Output: tail connects to node index 1
    Explanation: There is a cycle in the linked list, where tail connects to the second node.

Input: head = [1,2], pos = 0
Output: tail connects to node index 0
    Explanation: There is a cycle in the linked list, where tail connects to the first node.

Input: head = [1], pos = -1
Output: no cycle
    Explanation: There is no cycle in the linked list.

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

public class LinkedListCycleII {
    public static void main(String[] args) {
        LinkedListCycleII lc = new LinkedListCycleII();

        /* 3 -> 2 -> 0 -> 4
                |---------| */
        ListNode tmp = new ListNode(2, new ListNode(0));
        tmp.next.next = new ListNode(-4, tmp);
        ListNode head = new ListNode(3, tmp);
        System.out.println(lc.detectCycle(head).val);

        /* 1 -> 2
           |----| */
        tmp = new ListNode(2);
        head = new ListNode(1, tmp);
        tmp.next = head;
        System.out.println(lc.detectCycle(head).val);

        /* 1 -> null */
        head = new ListNode(1);
        System.out.println(lc.detectCycle(head).val);
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null)
            return null;

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }

        return null;
    }
}
