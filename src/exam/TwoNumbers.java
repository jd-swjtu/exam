package exam;

public class TwoNumbers {
	public static void main(String[] args) {
		TwoNumbers tn = new TwoNumbers();
		
		String n1 = "280196";
		String n2 = "923333395";
		
		System.out.println(tn.create("123333333333333335555555"));
		
		System.out.println(tn.add(tn.create(n1), tn.create(n2)));
		System.out.println(n1 + n2);
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

	public ListNode create(int value) {
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
	
	public ListNode create(String value) {
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
	
	public String values(ListNode p) {
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
	
	public int value(ListNode p) {
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

class ListNode {
	public int val;
	public ListNode next;
	
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
}
