package exams.aa;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class N20 {

	public static void main(String[] args) {
		System.out.println(new N20().isValid("("));
	}

	public boolean isValid(String s) {
		Map<Character,Character> pairs = new HashMap<>();
		pairs.put('(', ')');
		pairs.put('[', ']');
		pairs.put('{', '}');


		Stack<Character> stack = new Stack<Character>();

		if(s==null || s.length() == 0) return true;
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);

			if(pairs.containsKey(c)) {
				stack.push(c);
			} else {
				if(!stack.isEmpty()) {
					char cc = stack.pop();
					if(pairs.get(cc) != c) return false;
				} else {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}
}
