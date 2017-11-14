package exams.n0;

import exams.utils.ListNode;

/*
 Remove Duplicates from Sorted List II
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.


 */
public class N82 {

	public static void main(String[] args) {
		ListNode node = ListNode.create("1112");
		ListNode x = new N82().deleteDuplicates(node);
		System.out.println(x);
	}
	
public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode h = new ListNode(0);
        h.next = head;
        
        ListNode p = h;
        int pval = 0;
        boolean deleted = false;
        
        while(p.next != null) {
        	//Remove two nodes with the same value
	        if (p.next != null && p.next.next != null) {
	        	if (p.next.val == p.next.next.val) {
	        		pval = p.next.val;
	        		deleted = true;
	        		p.next = p.next.next.next;
	        	}
	        } else {
	        	break;
	        }
	        
	        //Removed followed nodes with the same value
	        if(deleted) {
	        	while(p.next != null && p.next.val == pval) {
	        		p.next = p.next.next;
	        	}
	        	deleted = false;
	        } else {
	        	//No node removed, move to next
	        	p = p.next;
	        }
        }
        
        return h.next;
    }

}
