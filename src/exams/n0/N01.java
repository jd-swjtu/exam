package exams.n0;

import java.util.HashMap;
import java.util.Map;

public class N01 {

	public static void main(String[] args) {
		N01 n1 = new N01();
		int[] ret = n1.twoSum(new int[]{1, 3,4,5,7,2,4,6}, 10);
		System.out.println(ret[0] + " : " + ret[1]);

	}
	/**
	 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

	 * @param nums
	 * @param target
	 * @return
	 */
	
	public int[] twoSum(int[] a, int v) {
		if(a.length < 2) return new int[]{0,0};
		
		Map<Integer,Integer> mapping = new HashMap<>();
		int i=0;
		for(int x: a) {
			mapping.put(x, i++);
		}
		
		for(int k: mapping.keySet()) {
			int diff = v - k;
			if(mapping.keySet().contains(diff)) {
				return new int[]{mapping.get(k), mapping.get(diff)};
			}
		}
		return new int[]{0,0};
	}

	public int[] twoSum2(int[] nums, int target) {
		if(nums.length < 2) return new int[]{0,0};

		Map<Integer,Integer> numsMap = new HashMap<Integer,Integer>();
		int i=0;
		for(int num: nums) {
			numsMap.put(num, i++);
		}

		i=0;
		for(int num: nums) {
			int anum = target - num;
			if(numsMap.containsKey(anum)) {
				return new int[]{i, numsMap.get(anum)};
			}
			i++;
		}

		return new int[]{0,0};
	}

}
