package exams.n2;

public class N240 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new N240().searchMatrix(new int[][]{
			{1,   4,  7, 11, 15},
			{2,   5,  8, 12, 19},
			{3,   6,  9, 16, 22},
			{10, 13, 14, 17, 24},
			{18, 21, 23, 26, 30}
		}, 25));
	}
	/*
	 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

    Integers in each row are sorted in ascending from left to right.
    Integers in each column are sorted in ascending from top to bottom.

For example,

Consider the following matrix:

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]

Given target = 5, return true.

Given target = 20, return false.
	 */

	public boolean searchMatrix(int[][] matrix, int target) {
		int w = matrix[0].length;
		int h = matrix.length;

		int i=0;
		int j=w-1;

		while(!(j<0 || i>=h)) {
			if(target < matrix[i][j]) {
				j--;
			} else if(target > matrix[i][j]) {
				i++;
			} else {
				System.out.println("Found " + i + "/" + j);
				return true;
			}
		}
		return false;
	}
}
