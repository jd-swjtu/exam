package exams.n0;

import java.util.ArrayList;
import java.util.List;

/*
 Subsets
DescriptionHintsSubmissionsDiscussSolution
Discuss Pick One
Given a set of distinct integers, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 */
public class N78 {

	public static void main(String[] args) {
		new N78().subsets(new int[]{1,2,2});
	}

	public List<List<Integer>> subsets(int[] nums) {
		List<Integer> tmp = new ArrayList<>();
		helper(nums, tmp, 0);
		return null;
	}

	void helper(int[] n, List<Integer> s, int idx) {
		System.out.println(s);

		for (int i = idx; i < n.length; i++) {
			if (i == idx ||  n[i] != n[i - 1]) {
				s.add(n[i]);

				helper(n, s, i + 1);
				s.remove(s.size() - 1);
			}
		}
}
}
