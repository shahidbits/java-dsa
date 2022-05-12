package drivers;

import linkedlist.MergeTwoSortedList;
import linkedlist.PalindromeLinkedList;
import linkedlist.ReverseLinkedList;
import util.ListNode;

public class LinkedListDriver {

    public void mergeTwoSortedList() {
        MergeTwoSortedList mergeTwoSortedList = new MergeTwoSortedList();

//        ListNode list1 = new ListNode(1);
//        list1.next = new ListNode(2);
//        list1.next.next = new ListNode(3);
//
//        ListNode list2 = new ListNode(1);
//        list2.next = new ListNode(2);
//        list2.next.next = new ListNode(4);

        ListNode list1 = new ListNode(-9);
        list1.next = new ListNode(3);

        ListNode list2 = new ListNode(5);
        list2.next = new ListNode(7);

        mergeTwoSortedList.mergeTwoLists(list1, list2);
    }

    public void reverseLinkedList() {
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();

        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(3);
        list1.next.next.next = new ListNode(4);

        reverseLinkedList.reverseList(list1);
    }

    public void palindromeLinkedList() {
        PalindromeLinkedList palindromeLinkedList = new PalindromeLinkedList();

        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(3);
        list1.next.next.next = new ListNode(2);
        list1.next.next.next.next = new ListNode(1);

        System.out.println("isPalindrome = " + palindromeLinkedList.isPalindrome(list1));
    }

}
