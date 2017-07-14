package exams.n1;

import exams.utils.ListNode;

/*
Sort a linked list using insertion sort.
 */
public class N147 {
	public ListNode sort(ListNode n, ListNode h) {
		ListNode p = h;
		ListNode q = null;
		while(p != null && p.val < n.val) {
			q = p;
			p = p.next;
		}
		if(q == null) {
			n.next = h;
			return n;
		}
		n.next = q.next;
		q.next = n;
		return h;
	}
	
    public ListNode insertionSortList(ListNode head) {
        if(head.next == null) return head;
        
        ListNode p = head.next;
        
        p = insertionSortList(p);
        head.next = null;

        return sort(head, p);
    }

    public ListNode insertionSortList2(ListNode head) {
        if(head.next == null) return head;
        
        ListNode h = head;
        ListNode p = head.next;
        h.next = null;
        while ( p != null) {
        	ListNode q = p;
        	p = p.next;
        	
        	q.next = null;
        	h = this.sort(q, h);
        }
        return h; 
    }
    
	public static void main(String[] args) {
		System.out.println(new N147().insertionSortList(ListNode.create("1325647")));
		System.out.println(new N147().insertionSortList2(ListNode.create("1325647")));
	}

}
