package exams.n0;

import java.util.Arrays;

/*
 Remove Element

Given an array and a value, remove all instances of that value in place and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.

Example:
Given input array nums = [3,2,2,3], val = 3

Your function should return length = 2, with the first two elements of nums being 2.


 */
public class N27 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println(new N27().removeElement2(new int[]{3,3,4}, 3));
	}
	
	public int removeElement2(int[] nums, int val) {
        int j = nums.length-1;
        int i = 0;
        while(i<j) {
            while(i<j && nums[j] == val) j--;
            while(i<j && nums[i] != val) i++;
            
            if(i<j) {
                nums[i] = nums[j];
                j--;
                i++;
            }
        }
        
        System.out.println(Arrays.toString(nums));
        while(j>=0 && nums[j] == val) j--;
        return j+1;
    }

	public int removeElement(int[] nums, int val) {
		int len = nums.length;
		int loc = 0;
		for(int i=0; i<len; i++) {
			if(val != nums[i]) {
				nums[loc++] = nums[i];
			}
		}
		return loc;
	}
	
	public int removeElement1(int[] A, int elem) {
	    int l = A.length;
	    for (int i=0; i<l; i++) {
	        if (A[i] == elem) {
	            A[i--] = A[l-- -1];
	        }
	    }
	    return l;
	}
	
	
}
