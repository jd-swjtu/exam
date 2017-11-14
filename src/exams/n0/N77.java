package exams.n0;

import java.util.ArrayList;
import java.util.List;

/*
Combinations
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

 */
public class N77 {

	public static void main(String[] args) {
		new N77().combine(4, 2);
	}

	public List<List<Integer>> combine(int n, int k) {
        List<Integer> tmp = new ArrayList<>();
        helper(n, k, tmp, 1);
        return null;
    }

	void helper(int n, int k, List<Integer> s, int idx) {
		if(s.size() == k) {
			System.out.println(s);
			return;
		}
		
		for(int i=idx; i<=n; i++) {
			s.add(i);
			helper(n, k, s, i+1);
			s.remove(s.size()-1);
		}
	}
}
