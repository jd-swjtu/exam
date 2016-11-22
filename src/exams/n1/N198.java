package exams.n1;

public class N198 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int rob2(int[] nums) {
        int len = nums.length;
        if(len == 0) return 0;
        
        int[] dp = new int[len+1];
        dp[0]=0;
        dp[1] = nums[0];
        for(int i=1; i<len; i++) {
            dp[i+1] = Math.max(dp[i], dp[i-1] + nums[i]);
        }
        return dp[len];
    }
	
	public int rob(int[] nums) {
        int len = nums.length;
        if(len == 0) return 0;
        
        int dp0 =0;
        int dp1 = nums[0];
        for(int i=1; i<len; i++) {
            int dp = Math.max(dp1, dp0 + nums[i]);
            dp0 = dp1;
            dp1 = dp;
        }
        return dp1;
    }
}
