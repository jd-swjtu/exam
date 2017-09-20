package exams.n0;

import java.util.Arrays;

/*
 Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. 
 Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class N16 {

	public static void main(String[] args) {
		System.out.println(new N16().threeSumClosest(new int[]{-1,  2, 1, -4}, 1));
	}

	public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        if(len < 3) return 0;
        int sum = nums[0]+nums[1]+nums[2];
        if(len == 3) return sum;
        
        Arrays.sort(nums);
        
        for(int i=0; i<len-2; i++) {
        	int e1 = nums[i];
        	
        	int start = i+1;
        	int end = len-1;
        	
        	while(start < end) {
        		int csum = e1 + nums[start] + nums[end];
        		if (Math.abs(csum-target) < Math.abs(sum-target)) sum = csum;
        		if (csum-target > 0) {
        			end--;
        		} else {
        			start++;
        		}
        	}
        }
        return sum;
    }
}
