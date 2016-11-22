package exams.n0;

public class N79 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = new char[][] {
			{'A','B','C','E'},
			{'S','F','C','S'},
			{'A','D','E','E'}
		};
		
		char[][] board1 = new char[][] {
			{'A','B','C','E'},
			{'S','F','E','S'},
			{'A','D','E','E'}
		};
		
		
				System.out.println(new N79().exist(board1, "ABCESEEEFSAD"));
		//System.out.println(new N79().exist(board, "FCSEED"));
		//System.out.println(new N79().exist(new char[][]{{'a'}}, "a"));
	}

	/*
	 *  Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
	 */
	public boolean exist(char[][] board, String word) {
		int r = board.length;
		int c = board[0].length;

		char[] wordArray = word.toCharArray();
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				boolean[][] visited = new boolean[r][c];
				if(search(board, i, j, r, c, wordArray, 0, visited)) return true;
			}
		}
		return false;
	}


	private boolean search(char[][] board, int x, int y, int r, int c, char[] word, int s, boolean[][] visited) {
		if(s >= word.length) return true;
		if(x<0 || x>=r || y<0 || y>=c) return false;

		char ch = word[s];
		if(visited[x][y] || ch != board[x][y]) return false;
		visited[x][y] = true;

		if(search(board, x+1, y, r, c, word, s+1, visited)) return true;
		if(search(board, x-1, y, r, c, word, s+1, visited)) return true;
		if(search(board, x, y+1, r, c, word, s+1, visited)) return true;
		if(search(board, x, y-1, r, c, word, s+1, visited)) return true;
		
		visited[x][y] = false;
		return false;
	}
}