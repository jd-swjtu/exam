package exams.n2;

import exams.utils.ListNode;

/*
 Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?
 */
public class N234 {
	private ListNode left;
	int max = 0;
	int i=0; //to control compare times - max/2
	
	//call helper until the end, then start to compare(it will return to previous stack, 
	//so the right will go backward, and use left=left.next to make left go forward)
	//The problem is that it compared all items twice
	public boolean isPalindrome2(ListNode head) {
		if (head == null || head.next == null) return true;
		left = head;
		return helper(head);
	}
	
	public boolean helper(ListNode right) {
		if(right == null) {
			max = i;
			return true;
		}
		
		i++;
		boolean ret = helper(right.next);
		i--;
		if(i < max/2) return ret;
		if (ret && right.val != left.val) return false;
		
		left = left.next;
		return true;
	}

	public boolean isPalindrome(ListNode head) {
		if(head == null) return false;
		if (head.next == null) return true;
		
		ListNode p = head;
		ListNode q = head;
		ListNode h = null;
		
		while(q != null && q.next != null) {
			q = q.next.next;
			
			ListNode t = p;
			p = p.next;

			//Reverse
			t.next = h;
			h = t;
		}
		if(q != null) {
			//number of node is odd, p is middle node
			q = p.next;
		} else {
			//number of node is even, p is head of right half
			q = p;
		}
		
		//System.out.println(q);
		//System.out.println(h);
		
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
		System.out.println(new N234().isPalindrome2(ListNode.create("1234554321").reverse()));
	}
}
