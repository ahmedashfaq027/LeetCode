/*

https://leetcode.com/problems/merge-two-sorted-lists/

Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.

Constraints:
1. The number of nodes in both lists is in the range [0, 50].
2. -100 <= Node.val <= 100
3. Both l1 and l2 are sorted in non-decreasing order.

Input: l1 = [1,2,4], l2 = [1,3,4]
Output: [1,1,2,3,4,4]

Input: l1 = [], l2 = []
Output: []

Input: l1 = [], l2 = [0]
Output: [0]

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

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        MergeTwoSortedLists lc = new MergeTwoSortedLists();
        ListNode l1 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(2, new ListNode(4)));

        // ListNode l1 = null;
        // ListNode l2 = null;

        // ListNode l1 = new ListNode(5);
        // ListNode l2 = new ListNode(1, new ListNode(2, new ListNode(4)));

        // ListNode l1 = new ListNode(-9, new ListNode(3));
        // ListNode l2 = new ListNode(5, new ListNode(7));

        lc.printLL(l1);
        lc.printLL(l2);

        ListNode res = lc.mergeTwoLists(l1, l2);
        lc.printLL(res);
    }

    // Merges two lists without using extra space
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null)
            return null;
        else if (l1 == null)
            return l2;
        else if (l2 == null)
            return l1;

        ListNode h = l1, prev = null;
        while (l1 != null && l2 != null) {
            while (l1 != null && l1.val <= l2.val) {
                prev = l1;
                l1 = l1.next;
            }

            if (l1 == null)
                break;

            if (l1.val <= l2.val) {
                ListNode tmp = new ListNode(l2.val);
                tmp.next = l1.next;
                l1.next = tmp;
                prev = l1;
                l1 = tmp;
                l2 = l2.next;
            } else {
                ListNode tmp = new ListNode(l2.val);
                if (prev == null) {
                    tmp.next = l1;
                    l1 = tmp;
                    h = tmp;
                } else {
                    tmp.next = l1;
                    prev.next = tmp;
                    prev = tmp;
                }
                l2 = l2.next;
            }
        }

        while (l1 != null) {
            l1 = l1.next;
        }

        if (l2 != null) {
            prev.next = l2;
        }

        return h;
    }

    // Merges two lists with extra space
    public ListNode mergeTwoListsWithExtraSpace(ListNode l1, ListNode l2) {
        ListNode head = null;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                head = insertEndLL(head, l1.val);
                l1 = l1.next;
            } else {
                head = insertEndLL(head, l2.val);
                l2 = l2.next;
            }
        }
        while (l1 != null) {
            head = insertEndLL(head, l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            head = insertEndLL(head, l2.val);
            l2 = l2.next;
        }

        return head;
    }

    private ListNode insertEndLL(ListNode h, int data) {
        if (h == null) {
            return new ListNode(data);
        }

        ListNode tmp = h;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = new ListNode(data);
        return h;
    }

    private void printLL(ListNode h) {
        while (h != null) {
            System.out.print(h.val + " ");
            h = h.next;
        }
        System.out.println();
    }
}