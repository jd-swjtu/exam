package exams.n0;

import java.util.Arrays;

/*
 Search for a Range

Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].


 */
public class N34 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(new N34().searchRange(new int[]{5, 7,7,8,8,10, 11, 12, 14}, 8)));
	}
	
	public int[] searchRange(int[] nums, int target) {
        //find it
		int s = 0;
		int e = nums.length;
		int loc = -1;
		while(s<=e) {
			int m = (s+e)/2;
			if(nums[m] == target) {
				loc = m;
				break;
			}
			
			if(target < nums[m]) {
				e = m-1;
			} else {
				s = m + 1;
			}
		}
		System.out.println(e + " " + s);
		
		if(loc == -1) {
			return new int[]{-1, -1};
		}
		int l=loc;
		int r=loc;
		while(l>0 && nums[l-1] == target) {
			l -= 1;
		}
		while(r<nums.length-2 && nums[r+1] == target) {
			r += 1;
		}
		return new int[]{l, r};
    }
}
