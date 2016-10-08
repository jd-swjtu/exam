package exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class TwoSum {
	public static void main(String[] args) {
		int[] x = (new TwoSum()).twoSum(new int[]{1,2,2,3,5,7,9}, 7);
		System.out.println(x[0] + ":" + x[1]);

		/*System.out.println(new TwoSum().atoi("0"));
		System.out.println(new TwoSum().atoi("23xx11"));
		System.out.println(new TwoSum().atoi("+123"));
		System.out.println(new TwoSum().atoi("-123xx"));
		System.out.println(new TwoSum().atoi("-2147483648"));
		System.out.println(new TwoSum().atoi("2147483648"));*/

		//System.out.println(new TwoSum().atoi("9223372036854775809"));

		int[] a = new int[]{ 1, 12, 34, 56, 23, 12};//7, 2, 5, 3, 2, 1}; //{5,4,3,2,1};// {1,2,3,4,5}; //
		//new TwoSum().nextPermutation(a);
		new TwoSum().quicksort(a, 0, a.length-1);
		for(int i=0; i<a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println();
		System.out.println(new TwoSum().firstMissingPositive(new int[]{0,1,2,3}));
		System.out.println("=========");
		new TwoSum().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
		//System.out.println(new TwoSum().maxSubArray1(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
		System.out.println(new TwoSum().maxSubArray2(new int[]{-2,-1,4,-1,2,-1,-5}));
		
		System.out.println("#121");
		System.out.println(new TwoSum().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
		System.out.println(new TwoSum().maxProfit(new int[]{7, 1, 7, 5, 6, 4}));
		System.out.println(new TwoSum().maxProfit(new int[]{2,1,2,1,0,1,2}));
		System.out.println(new TwoSum().maxProfit1(new int[]{2,1,2,1,0,1,2}));
		
		System.out.println(new TwoSum().wordPatternII("aabb", "xyzxyzabcabc"));
		System.out.println("Quick Sort");
		new TwoSum().quicksort(new int[]{5,4,3,2,1,9,8,7,6}, 0, 8);
		
		TwoSum ts = new TwoSum();
		ts.add(1);ts.add(3);ts.add(5);
		System.out.println(ts.find(4));
		System.out.println(ts.find(7));
		
		System.out.println(ts.minCost(new int[][]{
			{10,20,30},
			{20,30,10},
			{30,20,10},
			{10,20,30},
			{20,30,10},
			{30,20,10}
		}));
		
		System.out.println(ts.numWays(3, 2));
		System.out.println(ts.numWaysx(3, 2));
	}
	
	private Map<Integer,Boolean> numbers = new HashMap<Integer,Boolean>();
	public void add(int v) {
		if(numbers.keySet().contains(v)) {
			numbers.put(v, Boolean.TRUE);
		} else {
			numbers.put(v, Boolean.FALSE);
		}
	}
	@LeetCode(170)
	public boolean find(int target) {
		for(Integer v: numbers.keySet()) {
			int vv = target - v.intValue();
			if(vv == v.intValue()) {
				if(numbers.get(v)) return true;
				continue;
			} else {
				if(numbers.containsKey(vv)) return true;
				continue;
			}
		}
		return false;
	}

	@LeetCode(121)
	public int maxProfit(int[] prices) {
		if(prices.length < 2) return 0;
		
		int profit = 0;
		int max = 0;
		int min = 0;
		if(prices[0]>prices[1]) {
			min = max = prices[1];
		} else {
			min = prices[0];
			max = prices[1];
			profit = max - min;
		}
		for(int i=2; i<prices.length; i++) {
			if(prices[i] > max) {
				max = prices[i];
			}
			if(prices[i] < min) {
				min = max = prices[i];
			}
			
			profit = Math.max(profit, max - min);
		}
		return profit;
	}
	
	@LeetCode(121)
	public int maxProfit1(int[] prices) {
		if(prices.length < 2) return 0;
		
		int profit = 0;
		int min = prices[0];
		
		for(int i=1; i<prices.length; i++) {
			int v = prices[i] - min;
			if(v > profit) profit =v ;
			
			min = Math.min(prices[i], min);
		}
		return profit;
	}

	public int maxSubArray2(int[] A) {  
		if(A==null || A.length==0)  
			return 0;  
		int global = A[0];  
		int local = A[0];  
		for(int i=1;i<A.length;i++)  
		{  
			local = Math.max(A[i],local+A[i]);  
			global = Math.max(local,global);  
		}  
		return global;  
	}  

	public int maxSubArray1(int[] A) {
		if (A == null || A.length == 0){
			return 0;
		}

		int max = Integer.MIN_VALUE, sum = 0;
		for (int i = 0; i < A.length; i++) {
			sum += A[i];
			max = Math.max(max, sum);
			System.out.println("#" + max + " : " + sum);
			sum = Math.max(sum, 0);
		}

		return max;
	}

	public int maxSubArray(int[] nums) {
		int l = nums.length;
		int[][] r = new int[l][l];

		int max = Integer.MIN_VALUE;
		for(int i=0; i<l; i++) {
			r[i][i] = nums[i];
			if(r[i][i] > max) max = r[i][i];
			for(int j=i+1; j<l; j++) {
				r[i][j] = r[i][j-1] + nums[j];

				if(r[i][j] > max) {
					max = r[i][j];
				}
			}
		}

		return max;
	}

	@LeetCode(238)
public int[] productExceptSelf(int[] nums) {
       int len = nums.length;
       int[] res = new int[len];
       
       res[0] = 1;
       for (int i = 1; i < len; i++) {
       res[i] = res[i - 1] * nums[i - 1];
       }
       /*int right = 1;
       for (int i = len - 1; i >= 0; i--) {
       res[i] *= right;
       right *= nums[i];
       }*/
       
       for(int i=0; i<len; i++)
    	   System.out.println(res[i]);
       
       return res;
    }

	public boolean isVaild(char[][] board) {
		int[] v = new int[9];

		for(int i=0; i<9; i++) {
			for(int x=0; x<9; x++) v[x]=0;
			for(int j=0; j<9; j++) {
				char c= board[i][j];
				if(c == '.') continue;

				int vv = c - '1';
				if(v[vv] != 0) return false;
				v[vv] = 1;
			}
		}

		for(int i=0; i<9; i++) {
			for(int x=0; x<9; x++) v[x]=0;
			for(int j=0; j<9; j++) {
				char c= board[j][i];
				if(c == '.') continue;

				int vv = c - '1';
				if(v[vv] != 0) return false;
				v[vv] = 1;
			}
		}

		for(int i=0; i<9; i++) {
			for(int x=0; x<9; x++) v[x]=0;
			for(int k=0; k<3; k++) {

				for(int l=0; l<3; l++) {
					char c = board[3*(i/3)+k][3*(i%3) + l];
					if(c == '.') continue;

					int vv = c - '1';
					if(v[vv] != 0) return false;
					v[vv] = 1;
				}
			}
		}

		return true;
	}

	/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
	 */
	@LeetCode(value=1, c="a")
	public int[] twoSum(int[] nums, int target) {
		Map<Integer,Integer> mapping = new HashMap<Integer,Integer>();
		for(int i=0; i<nums.length; i++) {
			mapping.put(nums[i], i);
		}

		for(int i=0; i<nums.length; i++) {
			int v = target - nums[i];

			if(mapping.keySet().contains(v)) {
				return new int[]{i, mapping.get(v)};
			}
		}
		return new int[]{0,0};
	}

	/*
	 *Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.
	 */
	@LeetCode(8)
	public int atoi(String s) {
		if (s == null || "".equals(s)) return 0;

		s = s.trim();
		int sign = 1;
		if(s.charAt(0) == '-') {
			sign = -1;
			s = s.substring(1);
		} else if(s.charAt(0) == '+') {
			s = s.substring(1);
		}

		long v = 0;
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);

			if(c >= '0' && c <= '9') {
				v = v*10 + c - '0';
			} else {
				break;
			}

			if(sign == 1 && v > Integer.MAX_VALUE) return Integer.MAX_VALUE;
			if(sign == -1 && (-1 * v) < Integer.MIN_VALUE) return Integer.MIN_VALUE;
		}

		return (int)(v*sign);
	}


	//#31 - 7 2 5 3 2 1
	@LeetCode(31)
	public void nextPermutation(int[] nums) {
		boolean found = false;
		int v = 0;
		int i;
		for(i = nums.length - 1; i >0; i--) {
			if(nums[i] > nums[i-1]) {
				found = true;
				v = nums[i-1];
				break;
			}
		}

		if(found) {
			int j = 0;
			int vv = Integer.MAX_VALUE;
			for(int k = nums.length - 1; k >= i; k--) {
				if(nums[k] > v) {
					if(nums[k] <= vv) {
						vv = nums[k];
						j = k;
					}
				}
			}
			vv = nums[j];
			nums[j] = nums[i-1];
			nums[i-1] = vv;
		}
		//sort 
		for(int j=i; j<nums.length - 1; j++) {
			int vv = nums[j];
			int l = 0;
			for(int k = j+1; k<nums.length ; k++) {
				if(nums[k] < vv) {
					vv = nums[k];
					l = k;
				}
			}
			if(l != 0) {
				vv = nums[j];
				nums[j] = nums[l];
				nums[l] = vv;
			}
		}
	}

	/*
	 *Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.
	 */
	@LeetCode(41)
	public int firstMissingPositive(int[] nums) {
		for(int i=0; i<nums.length; i++) {
			while(nums[i] != i+1) {
				if(nums[i] <= 0 || nums[i] >= nums.length) break;

				if(nums[i] == nums[nums[i]-1]) break;

				int temp = nums[i];
				nums[i] = nums[temp-1];
				nums[temp-1] = temp;
			}
		}
		for(int i=0; i<nums.length; i++) {
			if(nums[i] != i+1) return i+1;
		}
		return nums.length+1;
	}

	@LeetCode(value=15, c="a")
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		Arrays.sort(nums);

		for(int i=0; i<nums.length - 2; i++) {
			if(i != 0 && nums[i] == nums[i-1]) continue;
			int s = i+1;
			int e = nums.length - 1;

			while(s<e) {
				int v = nums[i] + nums[s] + nums[e];
				if(v == 0) {
					ArrayList<Integer> tmp = new ArrayList<Integer>();
					tmp.add(nums[i]);
					tmp.add(nums[s]);
					tmp.add(nums[e]);
					results.add(tmp);

					System.out.println(String.format("%d %d %d\n", nums[i], nums[s], nums[e]));
					s++;
					e--;

					while (s < e && nums[s] == nums[s - 1]) { 
						s++;
					}
					while (s < e && nums[e] == nums[e + 1]) {
						e--;
					}
				} else {
					if(v>0) {
						e--;
					} else {
						s++;
					}
				}
			}
		}
		return results;
	}
	
	public void quicksort(int[] a, int l, int r) {
		int s = split(a, l, r);
		if(l < s -1)
			quicksort(a, l, s-1);
		if(s < r)
			quicksort(a, s, r);
	}
	
	public int split(int[] a, int s, int e) {
		int m = (s+e)/2;
		int ss = s; int ee = e;
		System.out.println("@@: " + s + " " + e);
		System.out.print("#@:");
		for(int i=s; i<=e; i++)
			System.out.print(" " + a[i]);
		System.out.print("\n##: " + m + "=" + a[m]);
		
		while(s<=e) {
			while(a[s] < a[m])
				s++;
			
			while(a[e] > a[m])
				e--;
			if(s<=e) {
				int tmp = a[s];
				a[s] = a[e];
				a[e] = tmp;
				
				s++;
				e--;
			}
		}
		
		for(int i=ss; i<=ee; i++)
			System.out.print(" " + a[i]);
		System.out.println(": " + s + " " + e);
		
		return s;
	}
	
	@LeetCode(290)
	public boolean wordPattern(String pattern, String str) {
        if(pattern == null) return false;
        if(str == null) return false;
        
        int len = pattern.length();
        String[] strs = str.split(" ");
        
        if(len != strs.length) return false;
        
        Map<Character,String> mapping = new HashMap<Character,String>();
        for(int i=0; i<len; i++) {
            char c = pattern.charAt(i);
            String s = strs[i];
            
            String ss = mapping.get(c);
            if(ss == null) {
                if(mapping.values().contains(s)) return false;
                mapping.put(c, s);
            } else {
                if(!ss.equals(s)) return false;
            }
        }
        return true;
    }
	
	@LeetCode(291)
	public boolean wordPatternII(String pattern, String str) {
        if(pattern == null) return false;
        if(str == null) return false;
      
        Map<Character,String> mapping = new HashMap<Character,String>();
        return wordPatternHelper(pattern, 0, str, 0, mapping);
	}
	
	private boolean wordPatternHelper(String pattern, int i, String str, int j, Map<Character,String> mapping) {
        if(i==pattern.length() && j == str.length()) {
        	System.out.println(mapping);
        	return true;
        }
        if(i>=pattern.length() || j >= str.length()) return false;
        
        char c = pattern.charAt(i);
        for(int k=j+1; k<=str.length(); k++) {
            String s = str.substring(j, k);
            
            String ss = mapping.get(c);
            if(ss == null) {
                if(!mapping.values().contains(s)) {
                	mapping.put(c, s);
                	
                	if(wordPatternHelper(pattern, i+1, str, k, mapping)) return true;
                	mapping.remove(c);
                }
            } else {
                if(ss.equals(s)) {
                	if(wordPatternHelper(pattern, i+1, str, k, mapping)) return true;
                }
            }
        }
        return false;
    }
	
	@LeetCode(167)
	public int[] twoSumII(int[] numbers, int target) {
        if(numbers.length < 2) return new int[]{0,0};
        
        int s = 0;
        int e = numbers.length - 1;
        while(s < e) {
            int v = numbers[s] + numbers[e] - target;
            if(v == 0) {
                return new int[]{s+1, e+1};
            } else if(v > 0) {
                e--;
            } else {
                s++;
            }
        }
        return new int[]{0,0};
    }
	
	public int numWays(int n, int k) {
        int dp[] = {0, k , k*k, 0};
        if(n <= 2){
            return dp[n];
        }
        for(int i = 2; i < n; i++){
            dp[3] = (k - 1) * (dp[1] + dp[2]);
            dp[1] = dp[2];
            dp[2] = dp[3];
        }
        return dp[3];
    }
	
	public int numWaysx(int n, int k) {
        int dp[] = new int[n<2?3:n+1];
        dp[0] = 0;
        dp[1] = k;
        dp[2] = k * k;
        
        if(n <= 2){
            return dp[n];
        }
        for(int i = 3; i <= n; i++){
            dp[i] = (k - 1) * (dp[i-2] + dp[i-1]);
        }
        return dp[n];
    }
	
	public int minCostx(int[][] costs) {
        if(costs != null && costs.length == 0) return 0;
        for(int i = 1; i < costs.length; i++){
            costs[i][0] = costs[i][0] + Math.min(costs[i - 1][1], costs[i - 1][2]);
            costs[i][1] = costs[i][1] + Math.min(costs[i - 1][0], costs[i - 1][2]);
            costs[i][2] = costs[i][2] + Math.min(costs[i - 1][0], costs[i - 1][1]);
        }
        return Math.min(costs[costs.length - 1][0], Math.min(costs[costs.length - 1][1], costs[costs.length - 1][2]));
    }
	
	private int minCostValue = Integer.MAX_VALUE;
	@LeetCode(256)
	public int minCost(int[][] costs) {
		minCost(costs, 0, 0, 0);
		minCost(costs, 0, 1, 0);
		minCost(costs, 0, 2, 0);
		return minCostValue;
	}
	
	private void minCost(int[][] costs, int i, int j, int w) {
		if(w>= minCostValue) return;
		if(i == costs.length) {
			if(w < minCostValue) {
				minCostValue = w;
			}
			return;
		}
		minCost(costs, i+1, (j+1)%3, w + costs[i][(j+1)%3]);
		minCost(costs, i+1, (j+2)%3, w + costs[i][(j+2)%3]);
	}
}
