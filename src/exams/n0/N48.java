package exams.n0;

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
				r[n-j-1][i] = matrix[i][j];
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				matrix[i][j] = r[i][j];
			}
		}
	}
}
