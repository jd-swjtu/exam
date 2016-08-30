package exam;

public class Resolution37 {

	public static void main(String[] args) {
		String[] str = new String[]{"..9748...","7........",".2.1.9...","..7...24.",
				".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."};
		char[][] board = new char[9][9];
		for(int i=0; i<9; i++)
			for(int j=0; j<9; j++) {
				String s = str[i];
				
				board[i][j] = s.charAt(j);
			}
		
		new Resolution37().solveSudoku(board);
		
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
				
	}

	@LeetCode(37)
    public void solveSudoku(char[][] board) {
    	System.out.println(solve(board, 0, 0));
	}
	
	private boolean solve(char[][] board, int i, int j) {
		if(j>=9) {
			i++; j = 0;
		}
		
		if(i>=9) return true;
		
		char c = board[i][j];
		if(c == '.') {
			int[] v=update(board, i, j);
			for(int k=0; k<9; k++) {
				if(v[k] == 0) {
					board[i][j] = (char)('1' + k);
					if(!solve(board, i, j+1))
						board[i][j] = c;
					else
						break;
				}
			}
			if(board[i][j] == '.') return false;
			return true;
		}
		return solve(board, i, j+1);
	}
	
	private int[] update(char[][] board, int i, int j) {
		int[] v = new int[9];
		for(int k=0; k<9; k++) {
			if(board[i][k] != '.')
				v[board[i][k] - '1'] = 1;
			if(board[k][j] != '.')
				v[board[k][j] - '1'] = 1;
		}
		
		int x = i / 3;
		int y = j / 3;
		for(int k=0; k<3; k++)
			for(int m=0; m<3; m++) {
				char c = board[3*x + k][3*y + m];
				if(c != '.')
					v[c-'1'] = 1;
			}
		return v;
	}
}
