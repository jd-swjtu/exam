package exams.n3;

/*
 Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).

Range Sum Query 2D
The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.

Example:
Given matrix = [
  [3, 0, 1, 4, 2],
  [5, 6, 3, 2, 1],
  [1, 2, 0, 1, 5],
  [4, 1, 0, 1, 7],
  [1, 0, 3, 0, 5]
]

sumRegion(2, 1, 4, 3) -> 8
update(3, 2, 2)
sumRegion(2, 1, 4, 3) -> 10
Note:
The matrix is only modifiable by the update function.
You may assume the number of calls to update and sumRegion function is distributed evenly.
You may assume that row1 ≤ row2 and col1 ≤ col2.

 */

class NumMatrix {
	int[][] data = null;
	int[][] sums = null;
	int rows;
	int cols;

	public NumMatrix(int[][] matrix) {
		data = matrix;
		rows = matrix.length;
		cols = matrix[0].length;
		sums = new int[rows][cols];

		this.recalculate(0, 0);
	}

	private void recalculate(int orow, int ocol) {
		sums[0][0] = data[0][0];
		int row = orow;
		int col = ocol;
		if (ocol == 0) {
			row = row == 0 ? 1 : row;
			for (int i = row; i < rows; i++)
				sums[i][0] = sums[i - 1][0] + data[i][0];
		}
		if (orow == 0) {
			col = col == 0 ? 1 : col;
			for (int i = col; i < cols; i++)
				sums[0][i] = sums[0][i - 1] + data[0][i];
		}
		for (int i = row; i < rows; i++) {
			for (int j = col; j < cols; j++) {
				sums[i][j] = data[i][j] + sums[i - 1][j] + sums[i][j - 1] - sums[i - 1][j - 1];
			}
		}
	}

	public void update(int row, int col, int val) {
		data[row][col] = val;
		this.recalculate(row, col);
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		if (row1 == 0 && col1 != 0) {
			return sums[row2][col2] - sums[0][col1];
		} else if (col1 == 0 && row1 != 0) {
			return sums[row2][col2] - sums[row1][0];
		} else {
			return sums[row2][col2] - sums[row2][col1 - 1] - sums[row1 - 1][col2] + sums[row1 - 1][col1 - 1];
		}
	}
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */

public class N308 {

	public static void main(String[] args) {
		int[][] matrix = new int[][] { 
			{ 3, 0, 1, 4, 2 },
			{ 5, 6, 3, 2, 1 },
			{ 1, 2, 0, 1, 5 },
			{ 4, 1, 0, 1, 7 },
			{ 1, 0, 3, 0, 5 } };

		NumMatrix n = new NumMatrix(matrix);

		System.out.println(n.sumRegion(2, 1, 4, 3));
		n.update(3, 2, 2);
		System.out.println(n.sumRegion(2, 1, 4, 3));
	}
}
