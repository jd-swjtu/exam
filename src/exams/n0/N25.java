package exams.n0;

import exams.utils.ListNode;

/*
 Reverse Nodes in k-Group

Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list.
 If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5
 */
public class N25 {

	public static void main(String[] args) {
		System.out.println(new N25().reverseKGroup(ListNode.create("987654321"), 4));
	}

	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode h = new ListNode(0);
		h.next = head;
		
		ListNode pre = h;
		ListNode tail=head;
		
		while(true) {
	        for (int i=0; i < k; ++i)
	        {
	            if ( tail == null  )
	                return h.next;
	            tail = tail.next;
	        }

	        ListNode new_head = reverse( head, tail);
	        pre.next = new_head;
	        pre = head;
	        head = tail;
		}
    }
	
	public ListNode reverseKGroup1(ListNode head, int k) {
	        ListNode node=head;
	        for (int i=0; i < k; ++i)
	        {
	            if ( node == null  )
	                return head; // nothing to do list too sort
	            node = node.next;
	        }

	        ListNode new_head = reverse( head, node);
	        System.out.println("@" + new_head.val);
	        head.next = reverseKGroup( node, k);
	        return new_head;
	    }
		
	
	ListNode reverse(ListNode first, ListNode last) {
        ListNode prev = last;
        
        while ( first != last )
        {
            ListNode tmp = first.next;
            first.next = prev;
            prev = first;
            first = tmp;
        }
        
        return prev;
    }
}
