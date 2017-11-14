package exams.n0;

public class N74 {

	public static void main(String[] args) {
		System.out.println(new N74().searchMatrix(new int[][]{
			{1,   3,  5,  7},
			{10, 11, 16, 20},
			{23, 30, 34, 50}
		}, 50));
	}

	/*
	 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

    Integers in each row are sorted from left to right.
    The first integer of each row is greater than the last integer of the previous row.

For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]

Given target = 3, return true.
	 */
	public boolean searchMatrix(int[][] matrix, int target) {
		int w = matrix[0].length;
		int h = matrix.length;

		int s = 0;
		int e = w * h -1;
		while(s<=e) {
			int mid = (s+e)/2;
			int r = mid/w;
			int c = mid%w;

			if(matrix[r][c] > target) {
				e = mid - 1;
			} else if(matrix[r][c] < target) {
				s = mid + 1;
			} else {
				return true;
			}
		}

		return false;
	}
	
	public boolean searchMatrix1(int[][] m, int t) {
		int w = m[0].length;
		int h = m.length;
		
		int j =  w - 1;
		int i = 0;
		
		while(i<h && j>=0) {
			if (m[i][j] == t) {
				return true;
			} else if (m[i][j] < t) {
				i++;
			} else {
				j--;
			}
		}
		return false;
		
	}
}
