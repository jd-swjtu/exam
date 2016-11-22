package exams.n1;

import java.util.HashMap;
import java.util.Map;

public class N138 {

	public static void main(String[] args) {
		RandomListNode n1 = new RandomListNode(1);
		RandomListNode n2 = new RandomListNode(2);
		RandomListNode n3 = new RandomListNode(3);
		RandomListNode n4 = new RandomListNode(4);
		
		n1.next = n2; n2.next = n3; n3.next = n4;
		
		n1.random = n3;
		n2.random = n4;
		n4.random = n1;
		
		N138 n = new N138();
		n.tranverse(n1);
		n.tranverse(n.copyRandomList2(n1));
	}


	/**
	 * Definition for singly-linked list with a random pointer.*/
	static class RandomListNode {
		int label;
		RandomListNode next, random;
		RandomListNode(int x) { this.label = x; }
	};

	public RandomListNode copyRandomList(RandomListNode head) {
		if(head == null) return head;
		
		RandomListNode p = head;
		while(p != null) {
			RandomListNode t = new RandomListNode(p.label);
			t.next = p.next;
			p.next = t;
			
			p = t.next;
		}
		
		//Copy random point
		p = head;
		while(p != null) {
			if(p.random != null) {
				p.next.random = p.random.next;
			}
			
			p = p.next.next;
		}
		
		//Remove orignal
		p = head.next;
		while(p != null && p.next != null) {
			p.next = p.next.next;
			p = p.next;
		}
		
		return head.next;
	}
	
	public RandomListNode copyRandomList2(RandomListNode head) {
		if(head == null) return head;
		
		Map<RandomListNode,RandomListNode> mapping = new HashMap<>();
		
		RandomListNode newHead = new RandomListNode(head.label);
		newHead.random = head.random;
		
		RandomListNode p = head.next;
		RandomListNode q = newHead;
		
		mapping.put(head, newHead);
		
		while(p != null) {
			RandomListNode t = new RandomListNode(p.label);
			t.random = p.random;
			
			mapping.put(p, t);
			
			p = p.next;
			q.next = t;
			q = t;
		}
		
		p = newHead;
		while(p != null) {
			if(p.random != null) {
				p.random = mapping.get(p.random);
			}
			p = p.next;
		}
		
		return newHead;
	}
	
	private void tranverse(RandomListNode head) {
		while(head != null) {
			System.out.println("" + head.label + " : " + (head.random!=null?head.random.label:"-"));
			head = head.next;
		}
	}
}