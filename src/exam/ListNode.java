package exam;

public class ListNode {
	public int val;
	public ListNode next;

	public static ListNode create(int value) {
		int v = value % 10;
		int m = value / 10;

		ListNode header = new ListNode(v);
		ListNode p = header;

		while( m > 0) {
			value = m;
			v = value % 10;
			m = value / 10;

			if( v == 0 && m == 0) break;

			ListNode q = new ListNode(v);
			p.next = q;
			p = q;
		}

		return header;
	}

	public static ListNode create(String value) {
		int len = value.length();
		ListNode header = new ListNode(Integer.valueOf(value.charAt(len-1)) - '0');
		ListNode p = header;

		for(int i=len-1; i>0; i--) {
			ListNode q = new ListNode(Integer.valueOf(value.charAt(i-1)) - '0');
			p.next = q;
			p = q;
		}

		return header;
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

		sbf.reverse();

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
} 

