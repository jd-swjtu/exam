package exams.utils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

import exams.utils.Utils.Triple;

public class DP {

	public int knapsack() {
		int[] v = new int[]{1,4,4,5,7};
		int[] w = new int[]{1,2,3,4,5};
		int total = 9;
		int[][] m = new int[v.length+1][total+1];
		
		System.out.println(Arrays.toString(m[0]));
		for(int i=1; i<v.length+1; i++) {
			for(int j=1; j<total+1; j++) {
				if(j >= w[i-1]) {
					m[i][j] = Math.max(m[i-1][j], m[i-1][j-w[i-1]]+v[i-1]);
				} else {
					m[i][j] = m[i-1][j];
				}
			}
			System.out.println(Arrays.toString(m[i]));
		}
		return m[v.length][total];
	}
	
	public int knapsack(int v[], int w[], int total) {
		int[][] m = new int[v.length+1][total+1];
		
		System.out.println(Arrays.toString(m[0]));
		for(int i=1; i<v.length+1; i++) {
			for(int j=1; j<total+1; j++) {
				if(j >= w[i-1]) {
					//1+ items
					//m[i][j] = Math.max(m[i-1][j], m[i][j-w[i-1]]+v[i-1]);
					//only 1 item
					m[i][j] = Math.max(m[i-1][j], m[i-1][j-w[i-1]]+v[i-1]);
				} else {
					m[i][j] = m[i-1][j];
				}
			}
			System.out.println(Arrays.toString(m[i]));
		}
		return m[v.length][total];
	}
	
	public int maxCommonSubArray(int[] a, int[] b) {
		int aLen = a.length;
		int bLen = b.length;
		int[][] dp = new int[aLen+1][bLen+1];
		//dp[0]{x] = dp[x][0] = 0
		int max = 0;
		for(int i=1; i<=aLen; i++) {
			for(int j=1; j<=bLen; j++) {
				dp[i][j] = a[i-1] == b[j-1]?(dp[i-1][j-1]+1):Math.max(dp[i-1][j], dp[i][j-1]);
				max = Math.max(max, dp[i][j]);
			}
			System.out.println(Arrays.toString(dp[i]));
		}
		return max;
	}
	
	//10 - Regular Expression Matching
	public boolean isMatch(String s, String p) {

	    if (s == null || p == null) {
	        return false;
	    }
	    boolean[][] dp = new boolean[s.length()+1][p.length()+1];
	    dp[0][0] = true;
	    for (int i = 0; i < p.length(); i++) {
	        if (p.charAt(i) == '*' && dp[0][i-1]) {
	            dp[0][i+1] = true;
	        }
	    }
	    System.out.println(Arrays.toString(dp[0]));
	    for (int i = 0 ; i < s.length(); i++) {
	        for (int j = 0; j < p.length(); j++) {
	            if (p.charAt(j) == '.') {
	                dp[i+1][j+1] = dp[i][j];
	            }
	            if (p.charAt(j) == s.charAt(i)) {
	                dp[i+1][j+1] = dp[i][j];
	            }
	            if (p.charAt(j) == '*') {
	                if (p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.') {
	                    dp[i+1][j+1] = dp[i+1][j-1];
	                } else {
	                    dp[i+1][j+1] = (dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]);
	                }
	            }
	        }
	    }
	    return dp[s.length()][p.length()];
	}
	
	public boolean isMatch2(String s, String p) {
        int m = s.length(), n = p.length(); 
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for (int i = 0; i <= m; i++)
        	//j=0, i>0, all are false
            for (int j = 1; j <= n; j++)
                if (p.charAt(j-1) == '*')
                    dp[i][j] = dp[i][j - 2] || (i > 0 && (s.charAt(i - 1) == p.charAt(j - 2) 
                    	|| p.charAt(j - 2) == '.') && dp[i - 1][j]);
                else dp[i][j] = i > 0 && dp[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.');
        return dp[m][n];
    }
	
	//Use v to compose total - coin changes
	public int maxCount(int[] v, int total) {
		int len = v.length;
		int[][] dp = new int[len+1][total+1];
		dp[0][0]=1;
		for(int i=1; i<=len; i++) {
			for(int j=0; j<=total; j++) {
				dp[i][j] = (j>=v[i-1]?dp[i][j-v[i-1]]:0) + dp[i-1][j];
			}
			System.out.println(Arrays.toString(dp[i]));
		}
		return dp[len][total];
	}
	
	public boolean subset(int[] arr, int total, boolean repeat) {
		int len = arr.length;
		boolean[][] dp = new boolean[len+1][total+1];
		dp[0][0] = true;
		System.out.println(Arrays.toString(dp[0]));
		for(int i=1; i<=len; i++) {
			for(int j=0; j<=total; j++) {
				if (j==0 && i==0) {
					dp[i][j] = true;
				} else {
					if (!repeat)
						dp[i][j] = dp[i-1][j] || (j>=arr[i-1]?dp[i-1][j-arr[i-1]]:false);
					else
						dp[i][j] = dp[i-1][j] || (j>=arr[i-1]?dp[i][j-arr[i-1]]:false);
				}
			}
			System.out.println(Arrays.toString(dp[i]));
		}
		return dp[len][total];
	}
	
	public int maxProfitJobSchedule(Triple<Integer,Integer,Integer>[] jobs) {
		int len = jobs.length;
		int[] profits = new int[len];
		
		Arrays.sort(jobs, new Comparator<Triple<Integer,Integer,Integer>>() {

			@Override
			public int compare(Triple<Integer,Integer,Integer> o1, Triple<Integer,Integer,Integer> o2) {
				return o1.t2 - o2.t2;
			}});
		for(int i=0; i<len; i++) {
			profits[i] = jobs[i].t3;
		}
		for(int i=1; i<len; i++) {
			for(int j=0; j<i; j++) {
				Triple<Integer,Integer,Integer> oi = jobs[i];
				Triple<Integer,Integer,Integer> oj = jobs[j];
				if(oj.t2<=oi.t1) {
					profits[i] = Math.max(profits[i], oi.t3 + oj.t3);
				}
			}
		}
		System.out.println(Arrays.toString(profits));
		return 0;
	}
	
	public int longestValidParentheses(char[] s) {
        if(s.length <= 1) return 0;
        int curMax = 0;
        int[] longest = new int[s.length];
        for(int i=1; i < s.length; i++){
        	int prev = i - longest[i-1]-1;
        	if(s[i]==')' && prev>=0 && s[prev] == '(') {
        		longest[i] = i - prev + 1 + (prev-1>=0?longest[prev-1]:0);
        		curMax = Math.max(longest[i],curMax);
        	}
        	
            /*if(s[i] == ')' && i-longest[i-1]-1 >= 0 && s[i-longest[i-1]-1] == '('){
                    longest[i] = longest[i-1] + 2 + ((i-longest[i-1]-2 >= 0)?longest[i-longest[i-1]-2]:0);
                    curMax = Math.max(longest[i],curMax);
            }*/
        }
        System.out.println(Arrays.toString(longest));
        return curMax;
    }
	
	//wild char
	public boolean isMatch3(String s, String p) {
        int m = s.length(), n = p.length(); 
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for (int i = 0; i <= m; i++)
        	//j=0, i>0, all are false
            for (int j = 1; j <= n; j++)
                if (p.charAt(j-1) == '*')
                    dp[i][j] = dp[i][j - 1] || (i > 0 && dp[i - 1][j]);
                else dp[i][j] = i > 0 && dp[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?');
        return dp[m][n];
    }
	
	public int maxRectangular(int[] h) {
		int max = 0;
		int len = h.length;
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0; i<len;) {
			if(stack.isEmpty() || h[stack.peek()] <= h[i]) {
				stack.push(i);
				i++;
			} else {
				int top = stack.pop();
				max=Math.max(max, h[top] * (i - 1 - (stack.isEmpty()?-1:stack.peek())));
			}
		}
		return max;
	}
	/*
	 85
	 
	 Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 6.
	 */
	public int maximalRectangle(char[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int[][] dp=new int[m][n];
        
        
        int max = 0;
        for(int i=0; i<m; i++) {
        	for(int j=0; j<n; j++) {
        		if(i==0 && j==0) {
        			dp[0][0]=Integer.valueOf(matrix[0][0]);
        		} else if(i==0) {
        			dp[i][j] = Integer.valueOf(matrix[0][0])==1?dp[i][j-1]:0;
        		} else if(j==0) {
        			dp[i][j] = Integer.valueOf(matrix[0][0])==1?dp[i-1][j]:0;
        		} else {
        			if (Integer.valueOf(matrix[0][0])==1) {
        				if(dp[i-1][j-1] > 0 && dp[i-1][j]>0 && dp[i][j-1] > 0) {
        					dp[i][j] = 0;
        				}
        			}
        		}
        	}
        }
        return 0;
    }
	
	//d = 3,4,5,6,2,5; A0=3x4, A1=4x5, A2=5x6, A3=6x2, A4=2x5
	public int matrix(int[] d) {
		int len = d.length - 1;
		int[][] dp=new int[len][len];
		for(int l=0; l<len; l++) {
			for(int i=0; i+l<len; i++) {
			    int j = i + l;
				if (i == j) {
					dp[i][j] = 0;
				} else {
					int min = Integer.MAX_VALUE;
					for(int k=i; k<j; k++) {
						min = Math.min(min, dp[i][k] + dp[k+1][j] + d[i]*d[k+1]*d[j+1] /* AiAk x Ak+1Aj = d[i]xd[k+1] d[k+1]xd[j+1] */);
					}
					dp[i][j] = min;
				}
			}
			
		}
		for(int i=0; i<len; i++)
			System.out.println(Arrays.toString(dp[i]));
		return dp[0][len-1];
	}
	
	public static void main(String[] args) {
		System.out.println(new DP().knapsack());
		System.out.println(new DP().knapsack(new int[]{2,5,9,6}, new int[]{1,2,3,4}, 10));
		System.out.println(new DP().maxCommonSubArray(new int[]{1,2,3,2,1}, new int[]{1,0,4,3,2,1,4}));
		System.out.println(new DP().isMatch2("a", "a*"));
		System.out.println(new DP().maxCount(new int[]{2,3,5,6}, 10));
		System.out.println(new DP().subset(new int[]{2,3}, 7, true));
		System.out.println(new DP().maxProfitJobSchedule(new Triple[]{
			new Triple(1,4,3), new Triple(2,6,5), new Triple(4,7,2), new Triple(6,8,6), new Triple(5,9,4), new Triple(7,10,8)
		}));
		System.out.println(new DP().longestValidParentheses(")()(())(".toCharArray()));
		System.out.println(new DP().isMatch3("ab", "a*?*"));
		System.out.println(new DP().maxRectangular(new int[]{0,1,1,0}));
		System.out.println(new DP().matrix(new int[]{3,4,5,6,2,5}));
	}

}
