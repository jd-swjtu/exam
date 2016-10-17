package exam;

public class DP {

	public static void main(String[] args) {
		DP dp = new DP();
		
		System.out.println(dp.minSteps(100));
		System.out.println(dp.minStepsR(100));

		System.out.println(dp.longIncresingSub(new int[]{5,1,2,3,2,4,1}));
		
		System.out.println(dp.numDecodings("100"));
		
		System.out.println(dp.maxCoins(new int[]{2,5,6,4,5,1,2}));
	}

	public int minStepsR(int n) {
		if (n == 1) return 0;
		//if (n == 2) return 1;
		//if (n == 3) return 1;
		
		int step = minStepsR(n-1) + 1;
		
		if(n % 3 == 0) {
			step = Math.min(step, minStepsR(n/3) + 1);
		}
		
		if(n%2 == 0) {
			step = Math.min(step, minStepsR(n/2) + 1);
		}
		
		return step;
	}
	
	public int minSteps(int n) {
		int[] dp = new int[n+1];
		dp[1] = 0;
		
		for(int i=2; i<=n; i++) {
			dp[i] = dp[i-1] + 1;
			if(i%2 == 0) dp[i] = Math.min(dp[i],  dp[i/2] +1);
			if(i%3 == 0) dp[i] = Math.min(dp[i],  dp[i/3] +1);
		}
		return dp[n];
	}
	
	public int longIncresingSub(int[] nums) {
		int global = 1;
		int local = 1;
		
		for(int i=1; i<nums.length; i++) {
			local = (nums[i]>nums[i-1])?local+1:1;
			global = Math.max(global, local);
		}
		return global;
	}
	
	public int numDecodings(String s) {  
        if (s.length()==0||s==null||s=="0") 
            return 0; 

        int[] dp = new int[s.length()+1];  
        dp[0] = 1;  
        
        if (isValid(s.substring(0,1)))
            dp[1] = 1;  
        else 
            dp[1] = 0; 
        
        for(int i=2; i<=s.length();i++){  
            if (isValid(s.substring(i-1,i)))  
                dp[i] += dp[i-1];  
            if (isValid(s.substring(i-2,i)))  
                dp[i] += dp[i-2];  
        }  
        return dp[s.length()];  
    }  
      
    public boolean isValid(String s){  
        if (s.charAt(0)=='0') 
            return false;  
        int code = Integer.parseInt(s);  
        return code>=1 && code<=26;  
    }
    
    public int maxCoins(int[] coins) {
    	int n = coins.length;
    	if(n<1) return 0;
    	//int[] dp = new int[n+1];
    	
    	//dp[0] = 0;
    	//dp[1] = coins[0];
    	int pprev = 0;
    	int prev = coins[0];
    	int cur = prev;
    	
    	for(int i=1; i<n; i++) {
    		cur = Math.max(prev, pprev + coins[i]);
    		pprev = prev;
    		prev = cur;
    	}
    	
    	//return dp[n];
    	return cur;
    }
}
