/*

https://leetcode.com/problems/palindrome-linked-list/

Given the head of a singly linked list, return true if it is a palindrome.

Constraints:
1. The number of nodes in the list is in the range [1, 105].
2. 0 <= Node.val <= 9

Input: head = [1,2,2,1]
Output: true

Input: head = [1,2]
Output: false

*/

import java.util.Stack;

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

public class PalindromeLinkedList {
    public static void main(String[] args) {
        PalindromeLinkedList lc = new PalindromeLinkedList();

        ListNode head = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
        System.out.println(lc.isPalindrome(head));

        head = new ListNode(1, new ListNode(2));
        System.out.println(lc.isPalindrome(head));
    }

    public boolean isPalindrome(ListNode head) {
        Stack<Integer> st = new Stack<>();

        ListNode temp = head;
        while (temp != null) {
            st.push(temp.val);
            temp = temp.next;
        }

        temp = head;
        while (temp != null) {
            if (temp.val != st.peek()) {
                return false;
            }

            st.pop();
            temp = temp.next;
        }

        return true;
    }
}
