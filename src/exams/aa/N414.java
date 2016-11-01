package exams.aa;

import java.util.Arrays;
import java.util.TreeSet;

public class N414 {

	public static void main(String[] args) {
		System.out.println(new N414().thirdMax(new int[]{2, 2, 3, 1}));
		System.out.println(new N414().thirdMax(new int[]{3, 2, 1}));
		System.out.println(new N414().thirdMax(new int[]{2, 1}));
	}

	public int thirdMax(int[] nums) {
		int[] max = new int[] {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
		int count = 0;

		if(nums.length == 1) return nums[0];
		
		TreeSet<Integer> t = new TreeSet<Integer>();


		for(int i=0; i<nums.length; i++) {
			if(count == 3) {
				t.add(nums[i]);
			} else {
				t.add(nums[i]);
				
				count++;
			}
		}

		if(count == 3) return max[1];
		else return max[3];
	}
}
