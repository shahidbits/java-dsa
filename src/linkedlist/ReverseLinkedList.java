package linkedlist;

import util.ListNode;

/*
 * LeetCode: https://leetcode.com/problems/reverse-linked-list/
 * NeetCode: https://www.youtube.com/watch?v=G0_I-ZF0S38&list=PLot-Xpze53lfQmTEztbgdp8ALEoydvnRQ&index=10
 *
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {

        if (head == null) {
            return null;
        }


        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {

            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }

        return prev;

    }
}
