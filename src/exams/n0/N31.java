package exams.n0;

import java.util.Arrays;

/*
 Next Permutation

Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
 */
public class N31 {

	public static void main(String[] args) {
		int[] nums = new int[]{1,3,2};
		new N31().nextPermutation(nums);
		System.out.println(Arrays.toString(nums));
	}

	public void nextPermutation(int[] nums) {
		int len = nums.length;
		if(len <= 1) return;
		
		int i = len - 1;
		for(; i>0; i--) {
			if(nums[i-1] < nums[i]) {
				break;
			}
		}
		
		if(i>0) {
			for(int j=len-1; j>=i; j--) {
				if(nums[j] > nums[i-1]) {
					int t = nums[j];
					nums[j] = nums[i-1];
					nums[i-1] = t;
					break;
				}
			}
			Arrays.sort(nums, i, len);
		} else {
			Arrays.sort(nums);
		}
    }
}
