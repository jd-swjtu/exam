package exam;

public class TwoNumbers {
	public static void main(String[] args) {
		TwoNumbers tn = new TwoNumbers();

		String n1 = "280196";
		String n2 = "923333395";

		System.out.println(ListNode.create("123333333333333335555555"));

		System.out.println(tn.add(ListNode.create(n1), ListNode.create(n2)));
		System.out.println(n1 + n2);
		System.out.println(tn.removeNthFromEnd(ListNode.create("213"), 2));
	}

	public ListNode add(ListNode a, ListNode b) {
		ListNode c = new ListNode(0);
		ListNode h = c;
		ListNode p = null, pp = c;

		while ( a != null && b != null) {
			int val = a.val + b.val + c.val;
			c.val = val % 10;

			p = new ListNode(val / 10);
			c.next = p;
			pp = c;

			a = a.next;
			b = b.next;
			c = p;
		}

		ListNode q = (a!=null)?a:b;
		while(q != null) {
			int val = c.val + q.val;
			c.val = val % 10;

			p = new ListNode(val / 10);
			c.next = p;
			pp = c;

			q = q.next;
			c = p;
		}

		if(p!=null && p.val == 0) {
			pp.next = null;
		}

		return h;
	}

	//#19
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if(n == 0) return head;
		if(head == null) return null;

		ListNode p = head;
		while(n>0 && p != null) {
			p = p.next;
			n--;
		}

		if(n>0) return head;
		if(p == null) return head.next;

		ListNode q = head;
		while(p.next != null) {
			q = q.next;
			p = p.next;
		}

		q.next = q.next.next;

		return head;
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode h = new ListNode(0);
		ListNode p = h;
		while(l1 != null && l2 != null) {
			if(l1.val < l2.val) {
				p.next = l1;
				l1 = l1.next;
			} else {
				p.next = l2;
				l2 = l2.next;
			}
			p = p.next;
			p.next = null;
		}

		if(l1 != null) {
			p.next = l1;
		}

		if(l2 != null) {
			p.next = l2;
		}

		return h.next;
	}

	public ListNode mergeKLists(ListNode[] lists) {
		if(lists.length == 0) return null;
		return mergeHelper(lists, 0, lists.length - 1);
	}

	public ListNode mergeHelper(ListNode[] lists, int start ,int end) {
		if(start == end) return lists[start];

		int mid = start + (end - start)/2;
		ListNode left = mergeHelper(lists, start, mid);
		ListNode right = mergeHelper(lists, mid+1, end);

		return mergeTwoLists(left, right);
	}
}