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

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        MergeTwoSortedLists lc = new MergeTwoSortedLists();

        ListNode l1 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(2, new ListNode(4)));

        ListNode.print(l1);
        ListNode.print(l2);
        ListNode.print(lc.mergeTwoLists(l1, l2));

        l1 = null;
        l2 = null;

        ListNode.print(l1);
        ListNode.print(l2);
        ListNode.print(lc.mergeTwoLists(l1, l2));

        l1 = new ListNode(5);
        l2 = new ListNode(1, new ListNode(2, new ListNode(4)));

        ListNode.print(l1);
        ListNode.print(l2);
        ListNode.print(lc.mergeTwoLists(l1, l2));

        l2 = new ListNode(5, new ListNode(7));
        l1 = new ListNode(-9, new ListNode(3));

        ListNode.print(l1);
        ListNode.print(l2);
        ListNode.print(lc.mergeTwoLists(l1, l2));
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }

            temp = temp.next;
        }

        if (l1 != null) {
            temp.next = l1;
        }

        if (l2 != null) {
            temp.next = l2;
        }

        return dummy.next;
    }

    // Merges two lists without using extra space
    public ListNode mergeTwoListsNoExtraSpace(ListNode l1, ListNode l2) {
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
}
