package exams.n0;

public class N36 {

	public static void main(String[] args) {

	}

	public boolean validSudoku(char[][] data) {
		for(int i=0; i<9; i++) {
			int[] a = new int[9];
			for(int j=0; j<9; j++) {
				char c = data[i][j];
				if(c == '.') continue;

				if(a[c-'1'] != 0) return false;
				a[c-'1']=1;
			}
		}

		for(int i=0; i<9; i++) {
			int[] a = new int[9];
			for(int j=0; j<9; j++) {
				char c = data[j][i];
				if(c == '.') continue;

				if(a[c-'1'] != 0) return false;
				a[c-'1']=1;
			}
		}

		for(int i=0; i<9; i++) {
			int[] a = new int[9];

			for(int k=0; k<3; k++) {

				for(int l=0; l<3; l++) {
					char c = data[3*(i/3)+k][3*(i%3) + l];
					if(c == '.') continue;

					int vv = c - '1';
					if(a[vv] != 0) return false;
					a[vv] = 1;
				}
			}
		}
		return true;
	}
}
