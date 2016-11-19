package exams.ll;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N46 {

	public static void main(String[] args) {
		System.out.println(new N46().permute(new int[]{1,2,3}));
		System.out.println(new N46().permuteUnique(new int[]{1,1,2}));
	}

	/*
	 * 
	 *  Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:

[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

	 */

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();

		List<Integer> tmp = new ArrayList<Integer>();
		boolean[] visited = new boolean[nums.length];

		helper(results, tmp, nums, visited, false);
		return results;
	}

	public List<List<Integer>> permuteUnique(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> results = new ArrayList<List<Integer>>();

		List<Integer> tmp = new ArrayList<Integer>();
		boolean[] visited = new boolean[nums.length];

		helper(results, tmp, nums, visited, true);
		return results;
	}

	private void helper(List<List<Integer>> results, List<Integer> tmp, int[] nums, boolean[] visited, boolean noDuplicated) {
		if(tmp.size() == nums.length) {
			results.add(new ArrayList<Integer>(tmp));
			return;
		}

		for(int i=0; i<nums.length; i++) {
			if(noDuplicated && i>0 && nums[i] == nums[i-1] && !visited[i-1]) continue;
			if(visited[i]) continue;
			tmp.add(nums[i]);
			visited[i] = true;
			helper(results, tmp, nums, visited, noDuplicated);
			tmp.remove(tmp.size()-1);
			visited[i] = false;
		}
	}
}
