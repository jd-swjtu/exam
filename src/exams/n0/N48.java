package exams.n0;

import java.util.Arrays;

/*
 Rotate Image
You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Note:
You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

Example 1:

Given input matrix = 
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

rotate the input matrix in-place such that it becomes:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
Example 2:

Given input matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
], 

rotate the input matrix in-place such that it becomes:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]
 */
public class N48 {

	public static void main(String[] args) {
		int[][] matrix = new int[][] {
			{1,2,3,4,5},
			{6,7,8,9,10},
			{11,12,13,14,15},
			{16,17,18,19,20},
			{21,22,23,24,25}
		};

		//new N48().rotate(matrix);
		new N48().rotate2(matrix);

		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[i].length; j++)
				System.out.print(matrix[i][j] + ",");
			System.out.println();
		}

	}

	public void rotate(int[][] matrix) {
		int n = matrix.length;
		for(int i=0; i<(n+1)/2; i++) {
			for(int j=0; j<(n-1)/2; j++) {
				int t = matrix[i][j];
				matrix[i][j] = matrix[j][n-i-1];
				matrix[j][n-i-1] = matrix[n-i-1][n-j-1];
				matrix[n-i-1][n-j-1] = matrix[n-j-1][i];
				matrix[n-j-1][i] = t;
			}
		}
	}

	public void rotate2(int[][] matrix) {
		int n = matrix.length;
		int m = matrix[0].length;

		int[][] r = new int[m][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				r[m-j-1][i] = matrix[i][j];
			}
		}
		for(int i=0; i<m; i++)
			System.out.println(Arrays.toString(r[i]));
		
		if(m == n)
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				matrix[i][j] = r[i][j];
			}
		}
	}
}
