package exams.n0;

import java.util.Arrays;
import java.util.List;

/*
 Valid Sudoku
 */
public class N36 {

	public static void main(String[] args) {
char[][] board = new char[][] {
	{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
	{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
	{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
	{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
	{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
	{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
	{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
	{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
	{'.', '.', '.', '.', '8', '.', '.', '7', '9'},
};

		System.out.println(new N36().solve(board));
		for(int i=0; i<9; i++) {
			System.out.println(Arrays.toString(board[i]));
		}
	}
	
	public boolean solve(char[][] board) {
        for(int i=0; i<9; i++) {
        	for(int j=0; j<9; j++) {
        		char c = board[i][j];
        		if(c == '.') {
        			for(char cc='1'; cc <= '9'; cc++) {
        				board[i][j]=cc;
        				if(validSudoku(board)) {
        					if(solve(board)) return true;
        				}
        				board[i][j]='.';
        			}
        			return false;
        		}
        	}
        }
        return true;
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
