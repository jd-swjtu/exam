package exams.n0;

import exams.utils.ListNode;

public class N02 {

	public static void main(String[] args) {
		System.out.println(new N02().addTwoNumbers(ListNode.create("1235"),null));
		System.out.println(new N02().addTwoNumbers(ListNode.create("1235"),ListNode.create("66")));
		System.out.println(new N02().addTwoNumbers1(ListNode.create("1235"),ListNode.create("66")));
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode h = new ListNode(0);
		ListNode p = h;
		int c = 0;
		while(l1 != null || l2 != null) {
			if(l1!=null) {
				c += l1.val;
				l1=l1.next;
			}
			if(l2!=null) {
				c += l2.val;
				l2=l2.next;
			}
			
			p.next = new ListNode(c%10);
			p = p.next;
			c = c/10;
		}
		if(c!=0) {
			p.next = new ListNode(c);
		}

		return h.next;
	}
	
	public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
		ListNode h = new ListNode(0);
		ListNode p = h;
		int c = 0;
		while(l1 != null || l2 != null) {
			if(l1!=null) {
				c += l1.val;
				l1=l1.next;
			}
			if(l2!=null) {
				c += l2.val;
				l2=l2.next;
			}
			
			p.val = c%10;
			
			c = c/10;
			p.next = new ListNode(c);
			p = p.next;
		}
		
		return h;
	}
}
