package exams.n0;

/*
 Jump Game

Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.


 */
public class N55 {

	public static void main(String[] args) {
		System.out.println(new N55().canJump(new int[]{2,3,1,1,4}));
		System.out.println(new N55().canJump(new int[]{3,2,1,0,4}));
	}

	public boolean canJump(int[] nums) {
        return helper(nums, 0);
    }

	private boolean helper(int[] nums, int i) {
		if(i == nums.length-1) return true;
		if(i > nums.length-1) return false;
		
		int v = nums[i];
		for(int j=1; j<=v; j++) {
			if (helper(nums, i+j)) return true;
		}
		return false;
	}
}
