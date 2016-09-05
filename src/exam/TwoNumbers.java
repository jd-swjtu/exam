package exam;

public class TwoNumbers {
	public static void main(String[] args) {
		TwoNumbers tn = new TwoNumbers();
		
			/*	int n1 = 280196;
				int n2 = 923333395;
		
				System.out.println(ListNode.create("123333333333333335555555"));
		
				System.out.println(tn.add(ListNode.create(n1).reverse(), ListNode.create(n2).reverse()).reverse());
				System.out.println(n1 + n2);
			System.out.println(tn.removeNthFromEnd(ListNode.create("2134"), 2));

		System.out.println(tn.swapPairs(ListNode.create("123456")));

		System.out.println(tn.reverseKGroup(ListNode.create("12"), 3));*/
		System.out.println(tn.multiply("99", "99"));
		
		System.out.println(tn.isMatch("babbbbaabababaabbababaababaabbaabababbaaababbababaaaaaabbabaaaabababbabbababbbaaaababbbabbbbbbbbbbaabbb",
				"b**bb**a**bba*b**a*bbb**aba***babbb*aa****aabb*bbb***a"));
		/*System.out.println(tn.isMatch("a","aa") == false);
		System.out.println(tn.isMatch("aa","a") == false);
		System.out.println(tn.isMatch("aa","aa") == true);
		System.out.println(tn.isMatch("aaa","aa") == false);
		System.out.println(tn.isMatch("aa", "*") == true);
		System.out.println(tn.isMatch("aa", "a*") == true);
		System.out.println(tn.isMatch("ab", "?*") == true);
		System.out.println(tn.isMatch("aab", "c*a*b") == false);
		System.out.println(tn.isMatch("aab", "a*a*b") == true);*/
		
	}

	/*
	 *You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
	 */
	@LeetCode(2)
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

	//#24
	public ListNode swapPairs(ListNode head) {
		if(head == null) return null;

		ListNode h = new ListNode(0);
		h.next = head;

		ListNode p = h;

		while(p.next != null && p.next.next != null) {
			ListNode q = p.next;
			ListNode qq = p.next.next;

			p.next = qq;
			q.next = qq.next;
			qq.next = q;

			p = p.next.next;
		}

		return h.next;
	}

	//#25
	@LeetCode(25)
	public ListNode reverseKGroup(ListNode head, int k) {
		if(head == null) return head;

		ListNode p = head;
		ListNode q = null;
		ListNode h =  new ListNode(0);
		h.next = head;

		ListNode s = h;
		ListNode e = null;

		int i = 0;
		while(i < k) {
			if(p != null) {
				if(q == null) {
					q = p;
					p = p.next;

					q.next = null;
					e = q;
				} else {
					ListNode x = p;
					p = p.next;
					x.next = q;
					q = x;
				}

				i++;
			} else {
				break;
			}

			if(i == k) {
				s.next = q;
				s = e;
				q = null;
				i = 0;
			}
		}

		if(i<k) {
			if(s == h) {
				s.next = null;
			}
			while(q != null) {
				e = s.next;
				s.next = q;
				q = q.next;
				s.next.next = e;
			}
		}

		return h.next;
	}
	
	@LeetCode(43)
	public String multiply(String num1, String num2) {
		int l1 = num1.length();
		int l2 = num2.length();
		int[] d = new int[l1+l2];
		for (int i = 0; i <l1; i++) {
			int a = num1.charAt(l1-i-1) - '0';
			for (int j = 0; j < l2; j++) {
				int b = num2.charAt(l2-j-1) - '0';
				d[i + j] += a * b;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < d.length; i++) {
			int digit = d[i] % 10;
			int carry = d[i] / 10;
			sb.insert(0, digit);
			if (i < d.length - 1)
				d[i + 1] += carry;
		}
		//trim starting zeros
		while (sb.length() > 0 && sb.charAt(0) == '0') {
			sb.deleteCharAt(0);
		}
		return sb.length() == 0 ? "0" : sb.toString();

	}

	public String multiplyx(String num1, String num2) {
		if("0".equals(num1) || "0".equals(num2)) return "0";
        int l = num2.length();
        String value = "0";
        String w = num1;
        while(l>0) {
        	int v = (num2.charAt(l-1) - '0');
        	
        	for(int i=0; i<v; i++) {
        		value = addNumber(value, w);
        	}
        	
        	l--;
        	w = w + "0";
        }
        return value;
    }

	public String addNumber(String num1, String num2) {
		int c = 0;
		String result = "";
		int l1 = num1.length();
		int l2 = num2.length();
		for(int i=l1; i>0; i--) {
			int c1 = num1.charAt(i-1) - '0';
			
			for(int j=l2; j>0; j--) {
				int c2 = num2.charAt(j-1) - '0';
				
			}
		}
	
		while(l1 > 0 && l2 > 0) {
			int c1 = num1.charAt(l1-1) - '0';
			int c2 = num2.charAt(l2-1) - '0';
	
			int c3 = c1 + c2 + c;
			c = c3/10;
			result = (char)(c3%10 + '0') + result;
	
			l1--;
			l2--;
		}
	
		while(l1>0) {
			int c1 = num1.charAt(l1-1) - '0';
			int c3 = c1 + c;
			c = c3/10;
			result = (char)(c3%10 + '0') + result;
	
			l1--;
		}
		while(l2>0) {
			int c1 = num2.charAt(l2-1) - '0';
			int c3 = c1 + c;
			c = c3/10;
			result = (char)(c3%10 + '0') + result;
	
			l2--;
		}
		if(c > 0) {
			result = (char)(c + '0') + result;
		}
		return result;
	}
	
	
	@LeetCode(44)
	public boolean isMatch(String s, String p) {
		StringBuffer pp = new StringBuffer();
		
		if(p != null) {
			char c = p.charAt(0);
			pp.append(c);
			for(int i=1; i<p.length(); i++) {
				char cc = p.charAt(i);
				if(cc == '*' && c == '*') continue;
				c = cc;
				pp.append(c);
			}
		}
		System.out.println(pp.toString());
		return isMatchx(s, pp.toString());
	}
	public boolean isMatchx(String s, String p) {
		if(p == null || p.length() == 0) {
			if(s == null || s.length() == 0) return true;
			return false;
		}

		if(p.charAt(0) != '*' ) {
			if(s == null || s.length() == 0) return false;

			if(p.charAt(0) == s.charAt(0) || p.charAt(0) == '?') {
				//if(s.length() == 1 || p.length() == 1) return true;
				return isMatchx(s.substring(1), p.substring(1));
			}
			return false;
		} else {
			int start = 0;
			boolean r = isMatchx(s, p.substring(1));
			while(!r && start < s.length()) {
				start++;
				r = isMatchx(s.substring(start), p.substring(1));
			}
			return r;
		}
	}
}