package exams.n2;

public class N200 {

	public static void main(String[] args) {
		char[][] grid = {
				{'1', '1', '0', '1', '0'},
				{'1', '1', '1', '1', '0'},
				{'1', '1', '0', '0', '0'},
				{'0', '0', '1', '0', '0'},
				{'0', '0', '0', '1', '1'}
		};
		System.out.println(new N200().numIslands(grid));
	}

	public int numIslands(char[][] grid) {
		int h = grid.length;
		int w = grid[0].length;
		
		int max = 0;
		int count = 0;
		
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				if(grid[i][j] == '1') {
					count++;
					int area = 0;
					
					area = go(grid, i, j, area);
					if(area > max) {
						max = area;
					}
				}
			}
		}
		System.out.println("Max: " + max + ", count=" + count);
		return count;
		
	}
	
	private int go(char[][] grid, int i, int j, int area) {
		int h = grid.length;
		int w = grid[0].length;
		
		if(i>=h || i<0 || j<0 || j>=w) return area;
		
		if(grid[i][j] == '1') {
			area+=1;
			grid[i][j] = '0';
		
			area = go(grid, i-1, j, area);
			area = go(grid, i+1, j, area);
			area = go(grid, i, j-1, area);
			area = go(grid, i, j+1, area);
		}
		
		return area;
	}
}
