package exams.n0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?
  Find all unique quadruplets in the array which gives the sum of target.

Note: The solution set must not contain duplicate quadruplets.

For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
 */
public class N18 {

	public static void main(String[] args) {
		//System.out.println(new N18().fourSum(new int[]{1, 0,-1,0,-2,2}, 0));
		System.out.println(new N18().fourSum(new int[]{-1, 0, 1, 2, -1, -4}, -1));
		//System.out.println(new N18().fourSum(new int[]{-1,-5,-5,-3,2,5,0,4}, -7));
	}

	
	
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> results = new ArrayList<>();
        if(nums.length < 4) return results;
		
		int len = nums.length;
		Arrays.sort(nums);
		for(int i=0; i<len-3; i++) {
			if(i>0 && nums[i] == nums[i-1]) continue;
			for(int j=i+1; j<len-2; j++) {
				if(j>i+1 && nums[j]==nums[j-1]) continue;
                
				int start = j+1;
				int end = len-1;
				
				while(start < end) {
					int sum = nums[i] + nums[j] + nums[start] + nums[end];
					
					if(sum == target) {
						results.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));
						
						start++;
						while(start<end && nums[start] == nums[start-1]) start++;

						end--;
						while(start<end && nums[end] == nums[end+1]) end--;
					} else if(sum > target) {
						end--;
					} else {
						start++;
					}
				}
			}
		}
		
		return results;
    }
}
