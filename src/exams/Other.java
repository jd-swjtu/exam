package exams;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import exams.utils.TreeNode;

public class Other {
	public static void main(String[] args) throws Exception {
		//System.out.println(new Other().summaryRanges(new int[]{0,1,2,4,5,7}));
		//System.out.println(new Other().numSquares(14));
		//System.out.println(new Other().removeDuplicateLetters("acbxabc"));
		//System.out.println(new Other().reverseVowels("helloo"));
		//System.out.println(new Other().reconstructQueue(new int[][]{{7,0}, {4,3}, {7,1}, {5,0}, {6,1}, {5,2}}));
		//System.out.println(new Other().maxCoins(new int[]{3,1,5,8}));
		//System.out.println(Arrays.toString(new Other().twoSum(new int[]{}, 8)));
		/*System.out.println(new Other().validPalindrome(
				"aguokepatgbnvfqmgmlc"
				+ "upuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuc"
				+ "ulmgmqfvnbgtapekouga"));*/
		//new Other().generateMatrix(10);
		//System.out.println(new Other().minSubArrayLen(9, new int[]{10,2,3}));
		System.out.println(new Other().wordsBreak("leetcode", new String[]{"leet", "codez"}));
		
	}
	
	public boolean wordsBreak(String s, String[] wordDict) {
        Set<String> set = new HashSet<>();
        for(String str: wordDict) set.add(str);
        
        return wordBreak(s.toCharArray(), 0, set);
        
    }
    
    private boolean wordBreak(char[] sa, int start, Set<String> words) {
        if(start == sa.length) return true;
        for(int i=start; i<sa.length; i++) {
            String str = new String(sa, start, i-start+1);
            if(words.contains(str) && wordBreak(sa, i+1, words)) return true;
        }
        return false;
    }
	
	public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) return 0;
        
        int len = nums.length+1;
        int start = 0;
        int sum = 0;
        for(int i=0; i<nums.length; i++) {
        	sum += nums[i];
        	
                while(sum >= s) {
                	len = Math.min(len, i - start + 1);
                	
                    sum -= nums[start];
                    start++;
                }
        }
        return len == nums.length+1?0:len;
    }
	
	public int[][] generateMatrix(int n) {
        int total = n * n;
        int i = 0, j = 0;
        int flag = 0;
        int idx = 1;
        int[][] dir = new int[][]{{0,1}, {1,0}, {0, -1}, {-1, 0}};
        int[][] res = new int[n][n];
        while(true) {
        	res[i][j] = idx;
        	if(idx == total) break;
        	
            int ni = dir[flag%4][0] + i;
            int nj = dir[flag%4][1] + j;
            
            if(ni < 0 || ni > n-1 || nj < 0 || nj > n-1 || res[ni][nj] > 0) {
                flag += 1;
            } else {
                idx++;
                
                i = ni;
                j = nj;
            }
        }
for(i=0; i<n; i++) {
	System.out.println(Arrays.toString(res[i]));
}
        return res;
    }
	
	public boolean validPalindrome(String s) {
        if(s == null || s.length() == 0) return false;
        if(s.length() < 3) return true;
        int len = s.length();
        int i=0;
        int j=len-1;
        
        boolean needRemove = false;
        while(i<j) {
            if(s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
            	needRemove = true;
            	break;
            }
        }
        if(needRemove) {
        	//try left
        	int left = i, right = j;
        	i++;
        	while(i<j) {
        		if(s.charAt(i++) != s.charAt(j--)) {
        			//try right
        			right--;
        			while(left < right) {
        				if(s.charAt(left++) != s.charAt(right--)) return false;
        			}
        		}
        	}
        }
        return true;
    }
	
	public int[] twoSum(int[] nums, int target) {
	    Map<Integer,Set<Integer>> diff = new HashMap<>();
	    for(int i=0; i<nums.length; i++) {
	        if (!diff.containsKey(nums[i])) {
	           diff.put(nums[i], new HashSet<Integer>());
	        } 
	        diff.get(nums[i]).add(i);
	    }

	    for(int i=0; i<nums.length; i++) {
	        int v = target - nums[i];
	        if ( diff.containsKey(v)) {
	            for(int j: diff.get(v)) {
	              if ( i != j) return new int[]{i, j};
	            }
	        }
	    }

	    return new int[]{0,0};
	}

	
	public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        List<String> res = new ArrayList<>();
        if(s == null || s.length() ==0 || dict.size() == 0) return res;
        search(s, dict, "", res);
        return res;
    }
    
    private void search(String s, Set<String> dict, String cur, List<String> res) {       
        for(int l=1; l<=s.length(); l++) {
            String ss = s.substring(0, l);
            if (dict.contains(s)) {
                if (l == s.length()) {
                    res.add((cur + " " + ss).substring(1));
                } else
                    search(s.substring(l), dict, cur + " " + ss, res);
            }
        }
    }
	
	public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] val = new int[n+2];
        for(int i=0; i<n; i++) val[i+1] = nums[i];
        val[0]=1;
        val[n+1]=1;
        
        int[][] dp = new int[n+2][n+2];
        
        for(int len = 1; len <= n; len++) {
            for(int i=1; i<=n-len+1; i++) {
                int j=i+len-1;
                for(int k=i; k<=j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k-1] + dp[k+1][j] + val[i-1]*val[k]*val[j+1]);
                }
            }
        } 
        return dp[1][n];
    }
	
	public List<String> reconstructQueue(int[][] people) {
        //pick up the tallest guy first
        //when insert the next tall guy, just need to insert him into kth position
        //repeat until all people are inserted into list
        Arrays.sort(people,new Comparator<int[]>(){
           @Override
           public int compare(int[] o1, int[] o2){
               return o1[0]!=o2[0]?-o1[0]+o2[0]:o1[1]-o2[1];
           }
        });
    
        List<String> res = new LinkedList<>();
        for(int[] cur : people){
            res.add(cur[1],cur[0] + "->" + cur[1]);       
        }
        return res;
    }
	
	 public String reverseVowels(String s) {
	        if(s == null || s.length() < 2) return s;
	        int start = 0;
	        int end = s.length() - 1;
	        char[] sa = s.toCharArray();
	        while(start < end) {
	            while(start<end && !isVowel(sa[start])) start++;
	            while(start<end && !isVowel(sa[end])) end--;
	            if(start<end) {
	                char c = sa[start];
	                sa[start] = sa[end];
	                sa[end] = c;
	            }
	            start++;
	            end--;
	        }
	        return new String(sa);
	    }
	    
	    private boolean isVowel(char ch) {
	        return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U');
	    }
	
	public String removeDuplicateLetters(String s) {
        StringBuilder sb = new StringBuilder();
        int pos = 0; // the position for the smallest s[i]
        while(pos < s.length()) {
        	int[] cnt = new int[26];
        	for (int i = pos; i < s.length(); i++) cnt[s.charAt(i) - 'a']++;
        	for(int i=pos; i<s.length(); i++) {
        		System.out.println(s.charAt(i) + " " + pos + " " + sb.toString());
        		if (sb.indexOf(s.charAt(i)+"") >= 0) continue;
        		if (s.charAt(i) < s.charAt(pos)) pos = i;
                if (--cnt[s.charAt(i) - 'a'] == 0) break;
        	}
        	sb.append(s.charAt(pos));
        	pos++;
        }
        return sb.toString();
    }
	
	public String removeDuplicateLetters1(String s) {
        int[] cnt = new int[26];
        int pos = 0; // the position for the smallest s[i]
        for (int i = 0; i < s.length(); i++) cnt[s.charAt(i) - 'a']++;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(pos)) pos = i;
            if (--cnt[s.charAt(i) - 'a'] == 0) break;
        }
        return s.length() == 0 ? "" : s.charAt(pos) + removeDuplicateLetters1(
        		s.substring(pos + 1).replaceAll("" + s.charAt(pos), ""));
    }
	
	//[-4,-3,-2,-7,8,2,-3,-1]
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        for(int i=0; i<nums.length; i++) {
            int v = Math.abs(nums[i]) - 1;
            if(nums[v] > 0)
                nums[v] = -nums[v];
        }
        for(int i=0; i<nums.length; i++)
            if(nums[i] > 0)
                ret.add(i+1);
        return ret;
    }
	
	public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=1; i<=n; i++) {
        	int k=1;
            while(i-k*k>=0) {
                dp[i]=Math.min(dp[i], dp[i-k*k]+1);
                k++;
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }
	
	public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            while (i < nums.length - 1 && nums[i] + 1 == nums[i + 1]) {
                i++;
            }
            if (num != nums[i]) {
                res.add(num + "->" + nums[i]);
            } else {
                res.add(num + "");
            }
        }
        return res;
    }
	
	public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int rows = matrix.length;
        if(rows == 0) return res;
        
        int cols = matrix[0].length;
        if (cols == 0) return res;
        
        int left = 0;
        int right = cols-1;
        int top = 0;
        int bottom = rows - 1;
        while(top <= bottom || left <= right) {
            for(int i=left; i<=right; i++) {
                res.add(matrix[top][i]);
            }
            for(int i=top+1; i<=bottom-1; i++) {
                res.add(matrix[i][right]);
            }
            if(bottom > top) {
                for(int i=right; i>=left; i--) {
                    res.add(matrix[bottom][i]);
                }
            }
            if(left<right) {
                for(int i=bottom-1; i>=top+1; i--) {
                    res.add(matrix[i][left]);
                }
            }
            top += 1;
            bottom -= 1;
            left += 1;
            right -= 1;
        }
        return res;
    }
	
	public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits == null || digits.length() == 0) return res;
        
        combinate(digits, "", res);
        return res;
    }
    
    private void combinate(String digits, String s, List<String> res) {
        if(digits.length() == 0) {
            res.add(s);
            return;
        }
        char c = digits.charAt(0);
        String left = digits.substring(1);
        String[] mapping = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        for(char ch: mapping[c- '0'].toCharArray()) {
            combinate(left, s + ch, res);
        }
    }
	
	public int trap(int[] height) {
        int len = height.length;
        if(len == 0) return 0;
        
        int[] left = new int[len];
        int[] right = new int[len];
        
        left[0] = height[0];
        int max = left[0];
        for(int i=1; i<len; i++) {
            max = Math.max(max, height[i]);
            left[i] = max;
        }
        
        right[len-1] = height[len-1];
        max = right[len-1];
        for(int i=len-2; i>=0; i--) {
            max = Math.max(max, height[i]);
            right[i] = max;
        }
                        
        int res = 0;
        for(int i=0; i<len; i++)
            res += Math.min(left[i], right[i]) - height[i];
        
        return res;
    }
	
	public boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()) {
            if(c == '{' || c == '(' || c == '[') {
                stack.push(c);
            } else {
                if(stack.isEmpty()) return false;
                char ch = stack.pop();
                if ((c != '}' && ch == '{') || (c != ')' && ch == '(') || (c != ']' && ch == '[')) return false;
            }
        }
        if(stack.isEmpty()) return true;
        return false;
    }
	
	public void dfs(char[] digits, String s) {
		if(s.length() == 4) {

			int h = Integer.parseInt(s.substring(0,2));
			int m = Integer.parseInt(s.substring(2));
			if(h>23 || m > 59) return;
			System.out.println(h + ":" + m);
			return;
		}
		for(int i=0; i<digits.length; i++) {
			dfs(digits, s + digits[i]);
		}
	}

	public static void main1(String[] args) throws Exception {
		System.out.println(new Other().isValid("([]"));

		new Other().printDiagonals2(new int[][]{
			{1,2,3,10},
			{4,5,6, 11},
			{7,8,9, 12},
			{13,14,15,16}
		});

		System.out.println(new Diamond(4));
		System.out.println(new Diamond(5));
		/*printDiamond2(4);


		System.out.println(new Other().fib3(5));
		System.out.println(isPalid("aba"));*/

		//System.out.println(new Other().fib4(1,1, 5));

		new Other().category("d1:i1, i2, i3\n"
				+ "d2: i2, i3, i4\n"
				+ "d3: i4, i5\n"
				+ "d4: i6, i7\n");

		System.out.println(new Other().isInt("+1"));
		System.out.println(new Other().isInt("+-1"));
		System.out.println(new Other().isInt("1"));
		System.out.println(new Other().isInt("-1"));
		System.out.println(new Other().isInt("+123.0"));
		System.out.println(new Other().isInt("+0.0.1"));
		System.out.println(new Other().isInt("+.0001"));
		System.out.println(new Other().isInt("+1.0000"));
		System.out.println(new Other().isInt("-1..0"));

		/*List<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,2,3,4,4,5));
		//System.out.println(list);
		for(int i=0; i<100000; i++) {
			list.add(i);list.add(i);
		}
		long t1 = System.currentTimeMillis();
		new Other().delete(list);
		System.out.println(System.currentTimeMillis() - t1);
		//System.out.println(list);

		HashMap<Integer,String> map = new HashMap<Integer,String>();
		String str1 = new String("abc");
		String str2 = new String("abce");
		map.put(1,  str1);
		map.put(1,  str2);
		System.out.println(map);*/

		new Other().shitOddEven(1234);
		new Other().shitOddEvenX(1234);

		List<Integer> tmp = new ArrayList<Integer>();
		TreeNode t = TreeNode.deserialize("20,10,30,5,15,25,35,3,8,13,17,27,29,34,38");
		
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		new Other().searchSum(t, results, tmp, 30);
		System.out.println(results);
		new Other().dfs(new char[]{'0', '1','2','3'}, "");
	}


	public void searchSum(TreeNode root, List<List<Integer>> results, List<Integer> tmp, int sum) {
		if(root == null) {
			return;
		}
		
		tmp.add(root.val);
		if(root.val > sum) {
			if(tmp.size() > 1) {
				int prev = tmp.remove(0);
				searchSum(root.left, null, new ArrayList<Integer>(tmp), sum + prev - root.val);
			}
		}else if(sum == root.val) {
			System.out.println(tmp);
		} else {
			searchSum(root.left, results, tmp, sum - root.val);
			searchSum(root.right, results, tmp, sum - root.val);
		}
		if(tmp.size() > 0)
			tmp.remove(tmp.size() - 1);
	}
	
	public void searchSumx(TreeNode root, List<List<Integer>> results, List<Integer> tmp, int sum) {
		if(root == null) {
			return;
		}

		tmp.add(root.val);
		if(sum == root.val) {
			if(root.left == null || root.right == null) {
				results.add(new ArrayList<Integer>(tmp));
				System.out.println("##" + tmp);
			}
		} else {
			searchSumx(root.left, results, tmp, sum - root.val);
			searchSumx(root.right, results, tmp, sum - root.val);
		}
		tmp.remove(tmp.size() - 1);
	}

	public int shitOddEven(int n) {
		int nn = 0;
		for(int i=0; i<32; i+=2) {
			nn |=  ((n & (0x1 << i)) << 1)  | ((n & ( 0x1 << (i+1))) >> 1);
		}
		System.out.println(Integer.toBinaryString(n));
		System.out.println(Integer.toBinaryString(nn));
		return nn;
	}

	public int shitOddEvenX(int n) {
		System.out.println(Integer.toBinaryString(n));
		int nn = 0;
		for(int i=0; i<16; i++) {
			int x = (n&0x1)<<1 | (n&0x2)>>1;
			nn = (x << (i*2)) | nn;

			n = n >> 2;
		}
		System.out.println(Integer.toBinaryString(nn));
		return nn;
	}

	public void delete(List<Integer> list) {
		int size = list.size();
		if(size == 0) return;

		/*if(ArrayList.class.getClass().isAssignableFrom(list.getClass())) {
			int tmp = list.get(size-1);
			for(int i=size-2; i>=0; i--) {
				int cur = list.get(i);
				if(cur == tmp) {
					list.remove(i);
				}
				tmp = cur;
			}
		} else */{
			Iterator<Integer> it = list.iterator();
			int tmp = it.next();

			while(it.hasNext()) {
				int cur = it.next();

				if(cur == tmp) {
					it.remove();
				} else {
					tmp = cur;
				}
			}
		}
	}

	public void delete3(LinkedList<Integer> list) {
		int size = list.size();
		if(size == 0) return;

		int tmp = list.removeFirst();
		list.addLast(tmp);
		while(size > 1) {
			int cur = list.removeFirst();

			if(cur != tmp) {
				list.addLast(cur);
				tmp = cur;
			}
			size--;
		}
	}

	public void delete2(LinkedList<Integer> list) {
		int size = list.size();
		if(size == 0) return;

		Iterator<Integer> it = list.iterator();
		int tmp = it.next();

		while(it.hasNext()) {
			int cur = it.next();

			if(cur == tmp) {
				it.remove();
			} else {
				tmp = cur;
			}
		}
	}

	public boolean isInt(String s) {
		if(s == null) return false;
		s = s.trim();
		int flag = 0;
		if(s.startsWith("+")) {
			s = s.substring(1);
			flag = 1;
		}

		if(s.startsWith("-")) {
			if(flag == 1) return false;
			s = s.substring(1);
			flag = 1;
		}


		if(s.equals("")) return false;

		//char[] a = s.toCharArray();
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if(c == '.') {
				if(flag == 2) return false;
				flag = 2;
				continue;
			}

			if(!(c >= '0' && c <='9')) return false;

			//if(flag == 2 && c != '0') return false;
		}

		return true;
	}

	public static void printDiamond(int m) {
		int max = m%2==0?m-1:m;

		for(int i=0; i<(m+1)/2; i++) {
			for(int j=0; j<m; j++) {
				if(j == max/2 - i || j == max/2 + i) {
					System.out.print("#");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		for(int i=m/2-1; i>=0; i--) {
			for(int j=m-1-(m%2==0?1:0); j>=0; j--) {
				if(j == max/2 - i || j == max/2 + i) {
					System.out.print("#");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

	public static void printDiamond2(int m) {
		int row = m;
		int col = m%2==0?m-1:m;
		//int[][] matrix = new int[row][col];

		for(int i=0; i<row; i++) {
			int x = i>=row/2?(row-i-1):i;
			for(int j=0; j<col; j++) {
				if(j == col/2 - x || j == col/2 + x) {
					System.out.print("#");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

	public void printDiagonals(int[][] matrix) {
		int n = matrix.length;

		for(int i=n-1; i>=0; i--) {
			int startRow = i;
			int startCol = 0;

			for(int j=0; j<n-i; j++) {
				//System.out.print("[" + startRow + ", " + startCol + "]");
				System.out.print(matrix[startRow][startCol] + " ");
				startRow++;
				startCol++;
			}
			System.out.println();
		}

		for(int i=1; i<n; i++) {
			int startRow = 0;
			int startCol = i;

			for(int j=0; j<n-i; j++) {
				//System.out.print("[" + startRow + ", " + startCol + "]");
				System.out.print(matrix[startRow][startCol] + " ");
				startRow++;
				startCol++;
			}
			System.out.println();
		}
	}

	public void printDiagonals2(int[][] matrix) {
		int r = matrix.length;
		int c = matrix[0].length;

		for(int i=r-1; i>=0; i--) {
			int startRow = i;
			int startCol = 0;

			while(startRow < r) {
				//System.out.print("[" + startRow + ", " + startCol + "]");
				System.out.print(String.format("%02d ", matrix[startRow][startCol]));
				startRow++;
				startCol++;
			}
			System.out.println();
		}

		for(int i=1; i<c; i++) {
			int startRow = 0;
			int startCol = i;

			while(startCol < c) {
				//System.out.print("[" + startRow + ", " + startCol + "]");
				System.out.print(String.format("%02d ", matrix[startRow][startCol]));
				startRow++;
				startCol++;
			}
			System.out.println();
		}
	}

	public int fib(int n) {
		if(n == 1) return 1;
		if(n == 0) return 1;

		return fib(n-1) + fib(n-2);
	}

	public int fib2(int n) {
		if(n<0) return 0;
		if(n<2) return 1;

		int f0 = 1;
		int f1 = 1;

		for(int i=2; i<=n; i++) {
			int f2 = f0 + f1;
			f0 = f1;
			f1 = f2;
		}

		return f1;
	}

	public int fib3(int n) {
		if(n<0) return 0;
		if(n<2) return 1;

		int[] f = new int[n+1];
		f[0] = 1;
		f[1] = 1;


		for(int i=2; i<=n; i++) {
			f[i] = f[i-1] + f[i-2];
		}

		return f[n];
	}

	public int fib4(int f0, int f1, int n) {
		if(n == 0) return f0;
		if(n == 1) return f1;

		return fib4(f1, f0+f1, n-1);
	}

	public static boolean isPalid(String s) {
		if(s == null || s.equals("")) return false;
		int len = s.length();
		if(len == 1) return true;

		int start = 0;
		int end = len - 1;
		while(start < end) {
			if(s.charAt(start) != s.charAt(end)) return false;
			start++;
			end--;
		}
		return true;
	}

	public void category(String str) throws Exception {
		BufferedReader br = new BufferedReader(new StringReader(str));
		String line = null;

		Map<String,Set<String>> dish = new HashMap<String,Set<String>>();
		while((line=br.readLine()) != null) {
			String[] s1 = line.trim().split(":");

			Set<String> ing = new HashSet<String>();
			for(String s: s1[1].split(",")) {
				ing.add(s.trim());
			}
			dish.put(s1[0].trim(), ing);
		}
		br.close();

		String[] keys = new String[dish.size()];
		dish.keySet().toArray(keys);

		for(int i=0; i<keys.length; i++) {
			String k1 = keys[i];
			for(int j=i+1; j<keys.length; j++) {
				String k2 = keys[j];

				//if(Sets.intersection(dish.get(k1), dish.get(k2)).size() > 0)
				if(hasInt(dish.get(k1), dish.get(k2)))
					System.out.println("(" + k1 + ", " + k2 + ")");
			}
		}
	}

	private boolean hasInt(Set<String> s1, Set<String> s2) {
		for(String ss1: s1) {
			if(s2.contains(ss1)) return true;
		}
		return false;
	}
}

class Diamond {
	private int row;
	private int col;

	public Diamond(int r) {
		row = r;
		col = (row%2==0)?row-1:row;
	}

	public int getRowCount() {
		return row;
	}

	public String getRow2(int i) {
		int space = i;
		if(i>(row/2-1)) space = row - i - 1;

		System.out.println(i + " " + space);
		StringBuffer sbf = new StringBuffer();
		for(int j=0; j<col; j++) {
			if(j == col/2 - space || j == col/2 + space) {
				sbf.append("#");
			} else {
				sbf.append(" ");
			}
		}
		return sbf.toString();
	}

	public String getRow(int r) {
		if(r>(row-1)/2) {
			r = row - 1 - r;
		}
		int spaces = col/2 - r;

		char[] rowChars = new char[col];
		for(int i=0; i<col; i++) {
			rowChars[i] = ' ';
		}
		rowChars[spaces]='#';
		rowChars[col-1-spaces]='#';

		return new String(rowChars);
	}

	public String toString() {
		StringBuffer sbf = new StringBuffer();
		for(int i=0; i<row; i++) {
			sbf.append(this.getRow(i)).append("\n");
		}
		return sbf.toString();
	}
}
