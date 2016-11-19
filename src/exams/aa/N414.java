package exams.aa;

import java.util.TreeSet;

public class N414 {

	public static void main(String[] args) {
		//System.out.println(new N414().thirdMax(new int[]{2, 2, 3, 1}));
		//System.out.println(new N414().thirdMax(new int[]{3, 2, 1}));
		//System.out.println(new N414().thirdMax(new int[]{2, 1}));
		
		System.out.println(new N414().thirdMax(new int[]{1,2,2,5,3,5}));
		System.out.println(new N414().thirdMax2(new int[]{1,2,2,5,3,5}));
	}

	public int thirdMax(int[] nums) {
		if(nums.length == 1) return nums[0];
		
		TreeSet<Integer> t = new TreeSet<Integer>();

		
		for(int i=0; i<nums.length; i++) {
			if(t.size() < 3) {
				t.add(nums[i]);
			} else {
				t.add(nums[i]);
				if(t.size() > 3) t.pollFirst();
			}
			//System.out.println(t);
		}
		
		if(t.size() == 3) {
			return t.pollFirst();
		} else {
			return t.pollLast();
		}
	}
	
	public int thirdMax2(int[] nums) {
		long[] max = new long[]{Long.MIN_VALUE, Long.MIN_VALUE, Long.MIN_VALUE};
		
		for(int i=0; i<nums.length; i++) {
			if(nums[i] > max[0]) {
				max[2] = max[1];
				max[1] = max[0];
				max[0] = nums[i];
			} else if(nums[i] > max[1] && nums[i] < max[0]) {
				max[2] = max[1];
				max[1] = nums[i];
			} else if(nums[i] > max[2] && nums[i] < max[1]) {
				max[2] = nums[i];
			}
			
			System.out.println(max[0] + "," + max[1] + "," + max[2]);
		}
		
		return (int)((max[2] == Long.MIN_VALUE)?max[0]:max[2]);
	}
}
