package exams.n0;

/*
 First Missing Positive
Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.
 */
public class N41 {

	public static void main(String[] args) {
		System.out.println(new N41().firstMissingPositive(new int[]{2,2,3}));
	}

public int firstMissingPositive(int[] nums) {
        for(int i=0; i<nums.length; i++) {
        	while(nums[i]>0 && nums[i]<nums.length && nums[i] != nums[nums[i]-1]) {
        		int k = nums[i];
        		nums[i] = nums[k-1];
        		nums[k-1] = k;
        	}
        }
        
        for(int i=0; i<nums.length; i++) {
        	if(nums[i] != i+1) return i+1;
        }
        return nums.length+1;
    }
}
