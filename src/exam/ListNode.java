package exam;

public class ListNode {
	public int val;
	public ListNode next;

	public static ListNode create(int value) {
		int v = value % 10;
		int m = value / 10;

		ListNode p = new ListNode(v);

		while( m > 0) {
			value = m;
			v = value % 10;
			m = value / 10;

			if( v == 0 && m == 0) break;

			ListNode q = new ListNode(v);
			q.next = p;
			p = q;
		}

		return p;
	}

	public static ListNode create(String value) {
		int len = value.length();
		if(len == 0) return null;
		ListNode header = new ListNode(0);
		ListNode p = header;

		for(int i=0; i<len; i++) {
			ListNode q = new ListNode(Integer.valueOf(value.charAt(i)) - '0');
			p.next = q;
			p = q;
		}

		return header.next;
	}
	
	@LeetCode(value=206, c="a")
	public ListNode reverse() {
		ListNode q = null;
		ListNode p = this;
		
		q = p;
		p = p.next;
		q.next = null;
		
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
		int v = 0;
		while(p != null) {
			v += p.val;
			sbf.append(p.val % 10);

			p = p.next;
			v = v / 10;
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
	
	public static void main(String[] args) {
		System.out.println(ListNode.create(1234));
	}
} 

