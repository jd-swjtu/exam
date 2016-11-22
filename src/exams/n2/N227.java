package exams.n2;

import java.util.Stack;

public class N227 {

	public static void main(String[] args) {
		//System.out.println(new N227().calculate(" 3+5 / 2 "));
		//System.out.println(new N227().calculate(" 3+2 * 2 "));
		//System.out.println(new N227().calculate(" 3+2-5/2*3"));
		System.out.println(new N227().calculate("2*3-4"));
	}

	/*
	 * Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

You may assume that the given expression is always valid.

Some examples:

"3+2*2" = 7
" 3/2 " = 1
" 3+5 / 2 " = 5

	 */

	public int calculate(String s) {
		Stack<Integer> stack = new Stack<Integer>();
		char[] ss = s.toCharArray();

		int idx = 0;
		for(int i=0; i<ss.length; i++) {
			if(ss[i] != ' ') {
				ss[idx++] = ss[i];
			}
		}

		// System.out.println(new String(ss, 0, idx));
		int flag=0;
		String str="";
		for(int i=0; i<idx; i++) {
			if(ss[i] == '+' || ss[i] == '*' || ss[i] == '/' || ss[i] == '-') {
				int cur = Integer.parseInt(str);
				if(flag == 1 || flag == 2) {
					int pre = stack.pop();
					if(flag == 1) {
						cur = cur * pre;
					} else {
						cur = pre / cur;
					}
				}
				stack.push(cur);
				str = "";
				if(ss[i] == '-') str = "-";
				if(ss[i] == '*') flag = 1;
				else if(ss[i] == '/') flag = 2;
				else flag = 0;
			} else {
				str += ss[i];
			}
		}

		int cur = Integer.parseInt(str);
		while(!stack.isEmpty()) {
			int pre = stack.pop();
			if(flag == 1) {
				cur = cur * pre;
				flag = 0;
			} else if(flag == 2) {
				cur = pre / cur;
				flag = 0;
			} else {
				cur += pre;
			}
		}

		// System.out.println(stack);
		return cur;
	}
}
