package exams.n0;

import java.util.Arrays;

/*
 Remove Duplicates from Sorted Array

Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array nums = [1,1,2],

Your function should return length = 2, with the first two elements of 
nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
 */
public class N26 {

	public static void main(String[] args) {
		int[] a = new int[]{1,1,2,2,3,3,4,5};
		System.out.println(new N26().removeDuplicates(a) + " " + Arrays.toString(a));
	}

    public int removeDuplicates(int[] nums) {
        if(nums.length <= 1) return nums.length;
        
        int i=1;
        for(int j=1; j<nums.length; j++) {
        	if(nums[j] != nums[i-1]) {
        		nums[i++] = nums[j];
        	}
        }
        return i;
    }
}
