package exams.oo;

public class N265 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new N265().minCostII(new int[][]{
			{10,20,30},
			{20,30,10},
			{30,20,10},
			{10,20,30},
			{20,30,10},
			{30,20,10}
		}));
	}

	/*
	 * 
	 * There are a row of n houses, each house can be painted with one of the k colors. 
	 * The cost of painting each house with a certain color is different. 
	 * You have to paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by a n x k cost matrix.
 For example, costs[0][0] is the cost of painting house 0 with color 0; costs[1][2] is the cost of painting house 1 with color 2, 
 and so on... Find the minimum cost to paint all houses.
	 */
	
	public int minCostII(int[][] costs) {
		int len = costs.length;
		int k = costs[0].length;
		
		int min = 0;
		int secMin = 0;
		int minRow = -1;
		
		for(int i=0; i<len; i++) {
			int curMin = Integer.MAX_VALUE;
			int curSecMin = Integer.MAX_VALUE;
			int curMinRow = -1;
			
			for(int j=0; j<k; j++) {
				costs[i][j] += (minRow !=j)?min:secMin;
				
				if(costs[i][j] < curMin) {
					curSecMin = curMin;
					curMin = costs[i][j];
					curMinRow = j;
				} else if(costs[i][j] < curSecMin) {
					curSecMin = costs[i][j];
				}
			}
			
			min = curMin;
			secMin = curSecMin;
			minRow = curMinRow;
		}
		
		int result = Integer.MAX_VALUE;
		for(int j=0; j<k; j++) {
			if(costs[len-1][j] < result)
				result = costs[len-1][j];
		}
		
		return result;
	}
}
