package exams.n0;

import java.util.Arrays;

public class N62 {
/*
	A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

	The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

	How many possible unique paths are there?
			*/
	public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=0; i<m; i++) {
        	for(int j=0; j<n; j++) {
        		if (i==0 || j==0) {
        			dp[i][j]=1;
        		} else {
        			dp[i][j] = dp[i-1][j] + dp[i][j-1];
        		}
        	}
        }
        
        return dp[m-1][n-1];
    }

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if (m == 0) return 0;
        
        int n = obstacleGrid[0].length;
        if (n==0) return 0;

        if (obstacleGrid[0][0] == 1) return 0;
        int[][] dp = new int[m+1][n+1];
        
        for(int i=1; i<m+1; i++) {
        	for(int j=1; j<n+1; j++) {
        		if (i==1 && j==1) {
        			dp[1][1]=1;
        		} else if (obstacleGrid[i-1][j-1] == 1) {
        			dp[i][j]=0;
        		} else {
        			dp[i][j] = dp[i-1][j] + dp[i][j-1];
        		}
        	}
        	System.out.println(Arrays.toString(dp[i]));
        }
        return dp[m][n];
    }
	
	public int minPathSum(int[][] grid) {
		int m = grid.length;
        if (m == 0) return 0;
        
        int n = grid[0].length;
        if (n==0) return 0;

        int[][] dp = new int[m][n];
        
        for(int i=0; i<m; i++) {
        	for(int j=0; j<n; j++) {
        		if(i==0 && j==0) {
        			dp[0][0] = grid[0][0];
        		} else if(j==0) {
        			dp[i][j]=dp[i-1][j] + grid[i][j];
        		} else if(i==0) {
        			dp[i][j]=dp[i][j-1] + grid[i][j];
        		} else {
        			dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
        		}
        	}
        	System.out.println(Arrays.toString(dp[i]));
        }
        return dp[m-1][n-1];
    }

	public static void main(String[] args) {
		System.out.println(new N62().uniquePaths(3, 3));
		System.out.println(new N62().uniquePathsWithObstacles(new int[][] {
			{0,0,0}, {0,1,0}, {0,0,0}
		}));
		System.out.println(new N62().minPathSum(new int[][]{
			{1,3,1},
			{1,5,1},
			{4,2,1}
		}));
	}

}
