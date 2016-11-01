package exams.aa;

public class N121 {

	public static void main(String[] args) {
		System.out.println(new N121().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
		System.out.println(new N121().maxProfit(new int[]{7, 6,5,4,3}));
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
}
