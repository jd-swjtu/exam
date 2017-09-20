package exams.n0;

import exams.utils.ListNode;

/*
 Remove Nth Node From End of List
Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.


 */
public class N19 {

	public static void main(String[] args) {
		System.out.println(new N19().removeNthFromEnd(ListNode.create("12345").reverse(), 3).reverse());
	}

	
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode p = head;
		while(n>0 && p != null) {
			p = p.next;
			n--;
		}
		
		if(n==0 && p == null) return head.next;
		if(n>0 || p == null) return head;
		
		ListNode q = head;
		while(p.next != null) {
			q = q.next;
			p = p.next;
		}
		
		if(q.next != null) {
			q.next = q.next.next;
		}
		
		return head;

	}
	
	public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode p = head;
        int count=0;
        while(p != null) {
        	p = p.next;
        	count++;
        }
        
        if(n>count) return head;
        if(n==count) return head.next;
        int loop = count - n - 1;
        p = head;
        while(loop > 0) {
        	p = p.next;
        	loop--;
        }
        
        if (p.next != null) {
        	p.next = p.next.next;
        }
        
        return head;
    }

}
