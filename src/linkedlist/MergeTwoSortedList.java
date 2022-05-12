package linkedlist;

import util.ListNode;

/*
 * LeetCode: https://leetcode.com/problems/merge-two-sorted-lists/
 * NeetCode: https://www.youtube.com/watch?v=XIdigk956u0&list=PLot-Xpze53lfQmTEztbgdp8ALEoydvnRQ&index=6
 *
 */
public class MergeTwoSortedList {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null && list2 == null) {
            return null;
        }

        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        ListNode ptr1 = list1;
        ListNode ptr2 = list2;

        ListNode dummyHead = new ListNode();
        ListNode curr = dummyHead;

        while (ptr1 != null && ptr2 != null) {

            if (ptr1.val <= ptr2.val) {
                curr.next = ptr1;
                ptr1 = ptr1.next;
            } else {
                curr.next = ptr2;
                ptr2 = ptr2.next;
            }
            curr = curr.next;
        }

        if (ptr1 != null) {
            curr.next = ptr1;
        }

        if (ptr2 != null) {
            curr.next = ptr2;
        }

        return dummyHead.next;
    }

}
