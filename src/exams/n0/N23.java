package exams.n0;

import exams.utils.ListNode;

/*
 Merge k Sorted Lists

Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 */
public class N23 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode mergeKLists(ListNode[] lists) {
        return this.partion(lists, 0, lists.length-1);
    }
	
	public ListNode partion(ListNode[] lists,int s,int e){
	    if(s==e)  return lists[s];
	    if(s<e){
	        int q=(s+e)/2;
	        ListNode l1=partion(lists,s,q);
	        ListNode l2=partion(lists,q+1,e);
	        return mergeTwoLists(l1,l2);
	    }else
	        return null;
	}
	
	//N21
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
