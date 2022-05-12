package linkedlist;

import util.ListNode;

/*
 * LeetCode: https://leetcode.com/problems/merge-two-sorted-lists/
 * NeetCode: https://www.youtube.com/watch?v=XIdigk956u0&list=PLot-Xpze53lfQmTEztbgdp8ALEoydvnRQ&index=6
 *
 */
public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {

        if (head == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;

        // get the middle node (slow)
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode leftHead = head;

        // reverse the second half
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNode rightHead = reverseLinkedList.reverseList(slow);
        ListNode rightHeadCopy = rightHead;

        boolean isPalindrome = true;

        while (rightHead != null) {

            if (leftHead.val != rightHead.val) {
                isPalindrome = false;
                break;
            }

            leftHead = leftHead.next;
            rightHead = rightHead.next;
        }

        // bring back the second half into original state
        slow.next = reverseLinkedList.reverseList(rightHeadCopy);

        return isPalindrome;
    }


}
