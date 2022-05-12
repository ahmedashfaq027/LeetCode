/*

https://leetcode.com/problems/rotate-list/

Given the head of a linked list, rotate the list to the right by k places.

Constraints:
1. The number of nodes in the list is in the range [0, 500].
2. -100 <= Node.val <= 100
3. 0 <= k <= 2 * 109

Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]

Input: head = [0,1,2], k = 4
Output: [2,0,1]

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

public class RotateList {
    public static void main(String[] args) {
        RotateList lc = new RotateList();

        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode.print(lc.rotateRight(head, 2));

        head = new ListNode(0, new ListNode(1, new ListNode(2)));
        ListNode.print(lc.rotateRight(head, 4));
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0)
            return head;

        int length = 1;
        ListNode temp = head;
        while (temp.next != null) {
            length++;
            temp = temp.next;
        }

        k = k % length;
        k = length - k;

        temp.next = head;
        while (k-- > 0) {
            temp = temp.next;
        }

        head = temp.next;
        temp.next = null;

        return head;
    }
}
