package exam;

import java.util.ArrayDeque;
import java.util.Queue;

public class MostWater {
	static int[] values = new int[]{1,2,3,4,5,6,7,8,9,10,9,8,7,6,5,4,3,2,1};

	public static void main(String[] args) {
		System.out.println(new MostWater().maxArea(values));
		System.out.println(new MostWater().maxArea2(values));
		
		System.out.println(new MostWater().trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
	}


	public int maxArea(int[] heights) {
		int max = 0;

		int len = heights.length;
		Queue<Integer> nodes = new ArrayDeque<Integer>();
		nodes.add(0);

		for(int i = 1; i < len; i++) {
			Integer v = nodes.peek();
			if(heights[i] > v) {
				nodes.add(i);
			}
		}

		for(Integer start: nodes) {
			int s = start.intValue();
			for(int j = s + 1; j < len; j++) {
				int min = heights[s] < heights[j]?heights[s]:heights[j];
				int v = min * (j - s);

				if(v > max) {
					max = v;
					System.out.println(s + ":" + j + "=" + v);
				}
			}
		}

		return max;
	}

	/*
	 *Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container.
	 */
	@LeetCode(11)
	public int maxArea2(int[] heights) {
		int max = 0;
		int s = 0;
		int e = heights.length - 1;

		while ( s < e) {
			int min = 0;
			if(heights[s] < heights[e]) {
				min = heights[s];
				s++;
			} else {
				min = heights[e];
				e--;
			}
			int v = min * (e - s + 1);

			if(v > max) {
				max = v;
				//System.out.println(s + ":" + e + "=" + v);
			}
		}

		return max;
	}

	public int trap(int[] A) {  
		// special case  
		if (A == null || A.length == 0) {  
			return 0;  
		}  

		int i, max, volume, left[] = new int[A.length], right[] = new int[A.length];  

		// from left to right  
		for (left[0] = A[0], i = 1, max = A[0]; i < A.length; i++) {  
			if (A[i] < max) {  
				left[i] = max;  
			} else {  
				left[i] = A[i];  
				max = A[i];  
			}  
		}  

		// from right to left  
		for (right[A.length - 1] = A[A.length - 1], i = A.length - 2, max = A[A.length - 1]; i >= 0; i--) {  
			if (A[i] < max) {  
				right[i] = max;  
			} else {  
				right[i] = A[i];  
				max = A[i];  
			}  
		}  

		for(i=0; i<A.length; i++)
			System.out.print(left[i] + " ");
		System.out.println();
		for(i=0; i<A.length; i++)
			System.out.print(right[i] + " ");
		System.out.println();
		
		// trapped water  
		for (volume = 0, i = 1; i <= A.length - 2; i++) {  
			int tmp = Math.min(left[i], right[i]) - A[i];  
			if (tmp > 0) {  
				volume += tmp;  
			}  
		}  

		return volume;  
	}  
}
