package exams.n0;

import exams.utils.ListNode;

/*
 Merge two sorted linked lists and return it as a new list.
 The new list should be made by splicing together the nodes of the first two lists.
 */
public class N21 {

	public static void main(String[] args) {
		System.out.println(new N21().mergeTwoLists(ListNode.create("8642"), ListNode.create("9531")));
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p = head;
        while(l1 != null && l2 != null) {
        	if(l1.val < l2.val) {
        		p.next = l1;
        		l1 = l1.next;
        	} else {
        		p.next = l2;
        		l2 = l2.next;
        	}
        	p = p.next;
        }
        if(l2 != null) {
        	p.next = l2;
        } else {
        	p.next = l1;
        }
        return head.next;
    }
}
