package exams.n0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 Combination Sum
Given a set of candidate numbers (C) (without duplicates) and a target number (T), 
find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7, 
A solution set is: 
[
  [7],
  [2, 2, 3]
]
 */
public class N39 {

	public static void main(String[] args) {
		//new N39().combinationSum(new int[]{2, 3,6,7}, 7);
		
		//n40
		new N39().combinationSum(new int[]{10,1,2,7,6,1,5}, 8);
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<Integer> temp = new ArrayList<>();
		Arrays.sort(candidates);
		this.go2(candidates, target, 0, temp);
		return null;
	}
	
	public void go(int[] c, int t, int i, List<Integer> temp) {
		if (t == 0) {
			System.out.println(temp);
			return;
		}
		for (int j = i; j < c.length; j++) {
			if (t - c[j] < 0) continue;
			temp.add(c[j]);
			go(c, t - c[j], j, temp);
			temp.remove(temp.size() - 1);
		}
	}

	public void go2(int[] c, int t, int i, List<Integer> temp) {
		if (t == 0) {
			System.out.println(temp);
			return;
		}
		for (int j = i; j < c.length; j++) {
			if (t - c[j] < 0) continue;
			if(j>i && c[j] == c[j-1]) continue;
			temp.add(c[j]);
			go2(c, t - c[j], j+1, temp);
			temp.remove(temp.size() - 1);
		}
	}
}
