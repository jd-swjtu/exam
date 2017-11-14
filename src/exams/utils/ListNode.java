package exams.utils;

import exam.LeetCode;

public class ListNode {
	public int val;
	public ListNode next;

	public static ListNode create(String value) {
		int len = value.length();
		if(len == 0) return null;
		ListNode header = new ListNode(0);
		ListNode p = header;

		for(int i=0; i<len; i++) {
			ListNode q = new ListNode(value.charAt(i) - '0');
			
			q.next = p.next;
			p.next = q;
		}

		return header.next;
	}
	
	@LeetCode(value=206, c="a")
	public ListNode reverse() {
		ListNode q = null;
		ListNode p = this;
		
		while(p != null) {
			ListNode x = p;
			p = p.next;
			
			x.next = q;
			q = x;
		}
		
		return q;
	}

	public ListNode(int v) {
		this.val = v;
	}

	public String toString() {
		ListNode p = this;
		StringBuffer sbf = new StringBuffer();
		while(p != null) {
			sbf.insert(0, p.val);
			
			p = p.next;
		}

		return sbf.toString();
	}

	public int value() {
		ListNode p = this;
		int v = 0;
		int i=1;
		while(p != null) {
			v += p.val * i;

			p = p.next;
			i *= 10;
		}
		return v;
	}
	
	public ListNode pairSwap() {
		ListNode dummy = new ListNode(0);
		ListNode p = dummy;
		ListNode q = this;
		while(q != null && q.next != null) {
			ListNode t = q.next.next;
			
			p.next = q.next;
			q.next.next = q;
			
			p = p.next.next;
			p.next = null;

			q = t;
		}
		if(q != null)
			p.next = q;
		return dummy.next;
	}
	
	public static void main(String[] args) {
		System.out.println(ListNode.create("12345").pairSwap());
	}
} 

