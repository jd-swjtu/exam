package exams.n1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class N121 {

	public static void main(String[] args) {
		//System.out.println(new N121().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
		//System.out.println(new N121().maxProfit(new int[]{7, 6,5,4,3}));
		System.out.println(new N121().maxProfitx(new int[]{2,5,1,6,4,9,3}));
	}

	public int maxProfit(int[] prices) {
		if(prices.length < 2) return 0;

		int low = prices[0];
		int max = 0;

		for(int i=1; i<prices.length; i++) {
			int cp = prices[i] - low;
			if(prices[i] < low) low = prices[i];

			max = Math.max(cp, max);
		}
		return max;
	}
	
	public int maxProfitx(int[] prices) {
		if(prices.length < 2) return 0;
		int[][] dp = new int[3][prices.length];
		
		int max =  0;
		for(int k=1; k<3; k++) {
			int tmp = dp[k-1][0] - prices[0];
			for(int j=1; j<prices.length; j++) {
				dp[k][j] = Math.max(dp[k][j-1], tmp + prices[j]);
				max = Math.max(max, dp[k][j]);
				tmp = Math.max(tmp, dp[k-1][j] - prices[j]);
			}
			System.out.println(Arrays.toString(dp[k]));
		}
		return max;
    }
}
