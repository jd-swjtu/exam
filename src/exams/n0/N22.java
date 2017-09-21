package exams.n0;

import java.util.ArrayList;
import java.util.List;

/*
 Generate Parentheses

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
 */
public class N22 {

	public static void main(String[] args) {
		System.out.println(new N22().generateParenthesis(4));
	}

	public List<String> generateParenthesis(int n) {
		List<String> results = new ArrayList<>();
        this.generatePairs(n, 0, 0, "", results);
        return results;
    }
	
	public void generatePairs(int n, int l, int r, String s, List<String> results) {
		if(r == n) {
			results.add(s);
			return;
		}
		if(l<n)
			generatePairs(n, l+1, r, s+"(", results);

		if(l>r)
			generatePairs(n, l, r+1, s+")", results);
	}
}
