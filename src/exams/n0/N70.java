package exams.n0;

public class N70 {

	public static void main(String[] args) {
		System.out.println(new N70().climbStairs(3));
	}

	/*
	 * You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Subscribe to see which companies asked this question

	 */

	public int climbStairs(int n) {
		int[] dp = new int[n>2?n+1:3];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;

		for(int i=3; i<=n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}

		return dp[n];
	}
}
