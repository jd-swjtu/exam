package exams.n0;

import exams.utils.ListNode;

/*
 Swap Nodes in Pairs
DescriptionHintsSubmissionsDiscussSolution
Discuss Pick One
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 */
public class N24 {

	public static void main(String[] args) {
		System.out.println(new N24().swapPairs(ListNode.create("54321")));
	}

	public ListNode swapPairs(ListNode head) {
        ListNode h = new ListNode(0);
        h.next = head;
        ListNode p = h;
        
        while(p.next != null && p.next.next != null) {
        	ListNode q = p.next.next;
        	p.next.next = q.next;
        	q.next = p.next;
        	p.next = q;
        	p = q.next;
        }
        return h.next;
    }
}
