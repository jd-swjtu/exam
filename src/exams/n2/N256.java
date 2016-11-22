package exams.n2;

public class N256 {

	public static void main(String[] args) {
		System.out.println(new N256().minCost(new int[][]{
			{10,20,30},
			{20,30,10},
			{30,20,10},
			{10,20,30},
			{20,30,10},
			{30,20,10}
		}));
	}

	/*
	 * There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. 
	 * The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by a n x 3 cost matrix. 
For example, costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with color green, 
and so on... Find the minimum cost to paint all houses.
	 */
	
	public int minCost(int[][] costs) {
		int len = costs.length;
		
		for(int i=1; i<len; i++) {
			costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);
			costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]);
			costs[i][2] += Math.min(costs[i-1][1], costs[i-1][0]);
		}
		
		return Math.min(Math.min(costs[len-1][0], costs[len-1][1]), costs[len-1][2]);
	}
}
