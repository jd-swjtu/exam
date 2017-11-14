package exams.utils;

import java.util.Arrays;

public class DP {

	public int knapsack() {
		int[] v = new int[]{1,4,4,5,7};
		int[] w = new int[]{1,2,3,4,5};
		int total = 9;
		int[][] m = new int[v.length+1][total+1];
		
		System.out.println(Arrays.toString(m[0]));
		for(int i=1; i<v.length+1; i++) {
			for(int j=1; j<total+1; j++) {
				if(j >= w[i-1]) {
					m[i][j] = Math.max(m[i-1][j], m[i-1][j-w[i-1]]+v[i-1]);
				} else {
					m[i][j] = m[i-1][j];
				}
			}
			System.out.println(Arrays.toString(m[i]));
		}
		return m[v.length][total];
	}
	
	public int knapsack(int v[], int w[], int total) {
		int[][] m = new int[v.length+1][total+1];
		
		System.out.println(Arrays.toString(m[0]));
		for(int i=1; i<v.length+1; i++) {
			for(int j=1; j<total+1; j++) {
				if(j >= w[i-1]) {
					//1+ items
					m[i][j] = Math.max(m[i-1][j], m[i][j-w[i-1]]+v[i-1]);
					//only 1 item
					//m[i][j] = Math.max(m[i-1][j], m[i-1][j-w[i-1]]+v[i-1]);
				} else {
					m[i][j] = m[i-1][j];
				}
			}
			System.out.println(Arrays.toString(m[i]));
		}
		return m[v.length][total];
	}
	
	public static void main(String[] args) {
		System.out.println(new DP().knapsack());
		System.out.println(new DP().knapsack(new int[]{2,5,9,6}, new int[]{1,2,3,4}, 5));
	}

}
