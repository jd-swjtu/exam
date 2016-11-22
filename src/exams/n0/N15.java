package exams.n0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N15 {

	public static void main(String[] args) {
		System.out.println(new N15().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
	}

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		if(nums.length < 3) return results;

		Arrays.sort(nums);
		int len = nums.length;
		for(int i=0; i<len-2; i++) {
			if(i>0 && nums[i] == nums[i-1]) continue;

			int s = i+1;
			int e = len-1;

			while(s<e) {
				int v = nums[i] + nums[s] + nums[e];
				if(v == 0) {
					List<Integer> result = new ArrayList<Integer>();
					result.add(nums[i]);
					result.add(nums[s]);
					result.add(nums[e]);
					results.add(result);

					s++;
					e--;
					
					while(s<e && nums[s] == nums[s-1]) s++;
					while(s<e && nums[e] == nums[e+1]) e--;
				} else if(v > 0) {
					e--;
				} else {
					s++;
				}
			}
		}

		return results;
	}
}
