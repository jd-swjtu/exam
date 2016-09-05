package exam;

import java.util.ArrayDeque;
import java.util.Queue;

public class MostWater {
	static int[] values = new int[]{1,2,3,4,5,6,7,8,9,10,9,8,7,6,5,4,3,2,1};
	
	public static void main(String[] args) {
		System.out.println(new MostWater().maxArea(values));
		System.out.println(new MostWater().maxArea2(values));
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

}
