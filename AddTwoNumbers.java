/*

https://leetcode.com/problems/add-two-numbers

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Constraints:
1. The number of nodes in each linked list is in the range [1, 100].
2. 0 <= Node.val <= 9
3. It is guaranteed that the list represents a number that does not have leading zeros.

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.

Input: l1 = [0], l2 = [0]
Output: [0]

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]

*/

class ListNode {
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

public class AddTwoNumbers {
    public static void main(String[] args) {
        AddTwoNumbers lc = new AddTwoNumbers();

        ListNode l1 = new ListNode(9);
        lc.insertEndLL(l1, 9);
        lc.insertEndLL(l1, 9);
        lc.insertEndLL(l1, 9);
        lc.insertEndLL(l1, 9);
        lc.insertEndLL(l1, 9);
        lc.insertEndLL(l1, 9);

        ListNode l2 = new ListNode(9);
        lc.insertEndLL(l1, 9);
        lc.insertEndLL(l1, 9);
        lc.insertEndLL(l1, 9);

        ListNode ans = lc.addTwoNumbers(l1, l2);
        lc.printLL(ans);

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(-1);
        int sum = 0, carry = 0;
        while (l1 != null && l2 != null) {
            sum = (l1.val + l2.val + carry) % 10;
            carry = (l1.val + l2.val + carry) / 10;
            insertEndLL(ans, sum);

            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            sum = (l1.val + carry) % 10;
            carry = (l1.val) / 10;
            insertEndLL(ans, sum);

            l1 = l1.next;
        }

        while (l2 != null) {
            sum = (l2.val + carry) % 10;
            carry = (l2.val) / 10;
            insertEndLL(ans, sum);

            l2 = l2.next;
        }

        if (carry > 0)
            insertEndLL(ans, carry);

        return ans.next;
    }

    private void insertEndLL(ListNode h, int data) {
        ListNode tmp = h;

        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = new ListNode(data);

    }

    private void printLL(ListNode h) {
        while (h != null) {
            System.out.print(h.val + " ");
            h = h.next;
        }
        System.out.println();
    }
}
