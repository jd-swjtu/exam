package exams.n2;

import exams.utils.ListNode;

/*
 Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?
 */
public class N234 {

	public boolean isPalindrome(ListNode head) {
		if(head == null) return false;
		if (head.next == null) return true;
		
		ListNode p = head;
		ListNode q = head.next;
		ListNode h = null;
		
		while(q.next != null && q.next.next != null) {
			q = q.next.next;
			
			ListNode t = p;
			p = p.next;

			//Reverse
			t.next = h;
			h = t;
		}
		//p is the end of left half
		if(q.next != null) {
			//number of node is odd, ignore the mid node, q is head of right side
			q = p.next.next;
		} else {
			q = p.next;
		}
		//Add the last node of left half
		p.next = h;
		h = p;
		
		while(h != null) {
			if(h.val != q.val) {
				return false;
			}
			
			h = h.next;
			q = q.next;
		}
		
        return true;
    }
	
	public static void main(String[] args) {
		System.out.println(new N234().isPalindrome(ListNode.create("1").reverse()));
		System.out.println(new N234().isPalindrome(ListNode.create("11").reverse()));
		System.out.println(new N234().isPalindrome(ListNode.create("123454321").reverse()));
		System.out.println(new N234().isPalindrome(ListNode.create("1234554321").reverse()));
	}

}
