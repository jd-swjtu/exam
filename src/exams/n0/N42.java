package exams.n0;

/*
 Trapping Rain Water
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.


 */
public class N42 {

	public static void main(String[] args) {
		System.out.println(new N42().trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
	}
	
	public int trap(int[] height) {
		if(height == null || height.length < 3) return 0;
		int len = height.length;
		
		int[] left = new int[len];
		int[] right = new int[len];

		int max =  height[0];
		left[0] = max;
		for(int i=1; i<len; i++) {
			if(max < height[i]) max = height[i];
			left[i] = max;
		}

		max = height[len-1];
		right[len-1]=max;
		for(int i=len-2; i>=0; i--) {
			if(max < height[i]) max = height[i];
			right[i] = max;
		}

		int result =0;
		for(int i=0; i<len; i++) {
			result += Math.min(left[i], right[i]) - height[i];
		}

		return result;
	}
}
