package exam;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class AA {

	public static void main(String[] args) {
		AA aa = new AA();

		System.out.println(aa.addTwoNumbers(ListNode.create("1999"), ListNode.create("222")));
		
		char[][] grid = {
				{'1', '1', '0', '0', '0'},
				{'1', '1', '0', '0', '0'},
				{'1', '1', '0', '0', '0'},
				{'0', '0', '1', '0', '0'},
				{'0', '0', '0', '1', '1'}
		};
		System.out.println(aa.numIslands_2(grid));
		//System.out.println(aa.numIslands(grid));
		
		System.out.println(aa.longestPalindrome("bb"));
		System.out.println(aa.isValid("(([{}()[]]))"));
		
		System.out.println(aa.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
		
		System.out.println(aa.subsets(new int[]{1,2,3,4}));
		System.out.println(aa.firstNonRepeatedChar("leetcodel"));
		
		System.out.println(aa.combine(4, 3));
		
		System.out.println(aa.isIsomorphic("ab", "aa"));
		System.out.println(aa.isIsomorphic("aa", "ab"));
		
		List<Long> results = new ArrayList<Long>();
		aa.split(5, results);
		System.out.println(results + "\n" + results.size());
		
		int count = 0;
		for(int i=1; i<=2; i++)
			count += sum_dig.countRec(i, 3);
		System.out.println(count);
		System.out.println(sum_dig.countRec(2, 2));
		
		//System.out.println(aa.grayCode(3));
		aa.convertNumber(1234);
		
		aa.convertNumber(23204);
	}

	/**
	 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution.
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] twoSum(int[] nums, int target) {
		Map<Integer,Integer> mapping = new HashMap<Integer,Integer>();
		for(int i=0; i<nums.length; i++) {
			mapping.put(nums[i], i);
		}

		for(int i=0; i<nums.length; i++) {
			int v = target - nums[i];
			if(mapping.containsKey(v)) {
				return new int[]{i, mapping.get(v).intValue()};
			}
		}

		return new int[]{0,0};
	}
	
	public int numIslands_2(char[][] grid) {
		int rows = grid.length;
		if(rows == 0) return 0;
		int cols = grid[0].length;

		int count = 0;
		int max = 0;
		int cur = 0;
		for(int i=0; i<rows; i++)
			for(int j=0; j<cols; j++) {
				char c = grid[i][j];
				if (c == '0') continue;
				if((j>0 && grid[i][j-1] == c) || (i>0 && grid[i-1][j] == c) || (i==0 && j==0)) {
					cur++;
				} else {
						cur = 1;
				}
				if(cur == 1) {
					count++;
				}
				if(cur > max) {
					max = cur;
				}
				System.out.println(max + " " + cur + " " + count);
			}
		
		System.out.println("Count: " + count);
		return max;
	}

	public int numIslands(char[][] grid) {
		int rows = grid.length;
		if(rows == 0) return 0;
		int cols = grid[0].length;

		int count = 0;
		int max = 0;
		for(int i=0; i<rows; i++)
			for(int j=0; j<cols; j++) {
				char c = grid[i][j];
				if(c == '1') {
					count++;

					int w = search(grid, rows, cols, i, j, 0);
					if(w > max) max = w;
					System.out.println("Island " + count + ": " + w);
				}
			}

		System.out.println("Max Island:" + max);
		return count;
	}

	private int search(char[][] grid, int r, int c, int x, int y, int w) {
		if(x<0 || y <0 || x >= r || y >= c) return w;

		char cc = grid[x][y];
		if(cc == '1') {
			grid[x][y] = '0';
			w += 1;

			w = search(grid, r, c, x-1, y, w);
			w = search(grid, r, c, x+1, y, w);
			w = search(grid, r, c, x, y+1, w);
			w = search(grid, r, c, x, y-1, w);
		}
		return w;
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if(l1 == null) return l2;
		if(l2 == null) return l1;

		ListNode dummy = new ListNode(0);
		ListNode p = dummy;
		int c = 0;
		while(l1 != null && l2 != null) {
			int v = l1.val + l2.val + c;
			ListNode tmp = new ListNode(v%10);
			c = v / 10;

			tmp.next = p.next;
			p.next = tmp;

			l1 = l1.next;
			l2 = l2.next;
		}

		ListNode q = l1!=null?l1:l2;
		while(q != null) {
			int v = q.val + c;
			ListNode tmp = new ListNode(v%10);
			c = v / 10;

			tmp.next = p.next;
			p.next = tmp;
			q = q.next;
		}

		if(c != 0) {
			dummy.val = c;
			return dummy;
		}
		return dummy.next;
	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null) return null;

		if(root == p || root == q) return root;

		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);

		if(left != null && right != null) return root;
		return left!=null?left:right;
	}

	public int wordLadder(String beginWord, String endWord, String... others) {
		Set<String> dict = new HashSet<String>();
		for(String s: others) dict.add(s);
		dict.add(endWord);

		HashSet<String> hash = new HashSet<String>();

		Queue<String> queue = new LinkedList<String>();
		queue.offer(beginWord);
		hash.add(beginWord);

		int length = 1;
		while(!queue.isEmpty()) {
			length++;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String word = queue.poll();
				for (String nextWord: getNextWords(word, dict)) {
					if (hash.contains(nextWord)) {
						continue;
					}
					if (nextWord.equals(endWord)) {
						return length;
					}

					hash.add(nextWord);
					queue.offer(nextWord);
				}
			}
		}

		return 0;
	}

	// get connections with given word.
	// for example, given word = 'hot', dict = {'hot', 'hit', 'hog'}
	// it will return ['hit', 'hog']
	private ArrayList<String> getNextWords(String word, Set<String> dict) {
		ArrayList<String> nextWords = new ArrayList<String>();
		for (char c = 'a'; c <= 'z'; c++) {
			for (int i = 0; i < word.length(); i++) {
				if (c == word.charAt(i)) {
					continue;
				}
				String nextWord = replace(word, i, c);
				if (dict.contains(nextWord)) {
					nextWords.add(nextWord);
				}
			}
		}
		return nextWords;
	}
	private String replace(String s, int index, char c) {
		char[] chars = s.toCharArray();
		chars[index] = c;
		return new String(chars);
	}
	
	public ListNode reverseList(ListNode head) {
		if(head == null) return null;

		ListNode p = head.next;
		head.next = null;
		while(p != null) {
			ListNode q = p;
			p = p.next;
			q.next = head;
			head = q;
		}
		return head;
	}
	
	public String longestPalindrome(String s) {
		if (s.isEmpty()) {
			return null;
		}
	 
		if (s.length() == 1) {
			return s;
		}
	 
		String longest = s.substring(0, 1);
		for (int i = 0; i < s.length(); i++) {
			// get longest palindrome with center of i
			String tmp = helper(s, i-1, i+1);
			if (tmp.length() > longest.length()) {
				longest = tmp;
			}
	 
			// get longest palindrome with center of i, i+1
			tmp = helper(s, i, i + 1);
			if (tmp.length() > longest.length()) {
				longest = tmp;
			}
		}
	 
		return longest;
	}
	 
	// Given a center, either one letter or two letter, 
	// Find longest palindrome
	public String helper(String s, int begin, int end) {
		while (begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {
			begin--;
			end++;
		}
		return s.substring(begin + 1, end);
	}
	
	@LeetCode(value=17, c="a")
	public List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<String>();
		String[] dict = new String[]{"+", " ", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

		if(digits == null || digits.equals("")) return result;
		generateString(result, dict, digits, "", 0);
		return result;
	}

	public void generateString(List<String> result, String[] dict, String numbers, String s, int idx) {
		if(idx == numbers.length()) {
			result.add(s);
			return;
		}
		int num = numbers.charAt(idx) - '0';
		for(int i=0; i<dict[num].length(); i++) {
			generateString(result, dict, numbers, s + dict[num].charAt(i), idx+1);
		}
	}
	
	@LeetCode(value=20, c="a")
	public boolean isValid(String s) {
		Stack<Character> q = new Stack<Character>();
		if(s == null || s.length() == 0) return true;
		
		Map<Character,Character> mapping = new HashMap<Character,Character>();
		mapping.put('{', '}');
		mapping.put('[', ']');
		mapping.put('(', ')');

		if(s.length() % 2 != 0) return false;

		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if(q.isEmpty()) {
				if(mapping.keySet().contains(c)) {
					q.push(c);
					continue;
				} else {
					return false;
				}
			}
			char h = q.peek();
			if(mapping.get(h).equals(c)) {
				q.pop();
			} else {
				q.push(c);
			}
		}

		return q.isEmpty();
	}
	
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		
		for(int i=0; i<nums.length - 2; i++) {
			if(i != 0 && nums[i] == nums[i-1]) continue;
			int s =  i+1;
			int e = nums.length - 1;
			
			while(s < e) {
				int v = nums[i] + nums[s] + nums[e];
				if(v == 0) {
					List<Integer> result = new ArrayList<Integer>();
					result.add(nums[i]);
					result.add(nums[s]);
					result.add(nums[e]);
					results.add(result);
					
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
	
	@LeetCode(value=239, c="a")
	public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
		// write your code here
		ArrayList<Integer> ans = new ArrayList<Integer>();
		Deque<Integer> deque = new ArrayDeque<Integer>();
		if (nums.length == 0) {
			return ans;
		}
		for (int i = 0; i < k - 1; i++) {
			inQueue(deque, nums[i]);
		}

		for(int i = k - 1; i < nums.length; i++) {
			inQueue(deque, nums[i]);
			ans.add(deque.peekFirst());
			outQueue(deque, nums[i - k + 1]);
		}
		return ans;
	}
	
	void inQueue(Deque<Integer> deque, int num) {
		while (!deque.isEmpty() && deque.peekLast() < num) {
			deque.pollLast();
		}
		deque.offer(num);
	}

	void outQueue(Deque<Integer> deque, int num) {
		if (deque.peekFirst() == num) {
			deque.pollFirst();
		}
	}
	
	@LeetCode(78)
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> sets = new ArrayList<List<Integer>>();
		sets.add(new ArrayList<Integer>());
		
		for(int i=0; i<nums.length; i++) {
			int len = sets.size();
			for(int j=0; j<len; j++) {
				List<Integer> n = new ArrayList<Integer>(sets.get(j));
				n.add(nums[i]);
				
				sets.add(n);
			}
		}
		
		return sets;
	}
	
	@LeetCode(387)
	public int firstNonRepeatedChar(String str) {
		if(str == null || str.length() == 0) return -1;
		if(str.length() == 1) return 0;
		
		int[] m = new int[26];
		for(int i=0; i<str.length(); i++) {
			int v = str.charAt(i) - 'a';
			if(m[v] > 0) {
				m[v] = -1;
			} else if(m[v] == 0) {
				m[v] = i+1;
			}
		}
		
		int min = Integer.MAX_VALUE;
		for(int i=0; i<26; i++) {
			if(m[i] >0 && m[i] < min)
				min = m[i];
		}
		if(min == Integer.MAX_VALUE)
			return -1;
		return min-1;
	}
	
	public List<List<Integer>> combine(int n, int k) {
		if(k == 0 || k>n) return new ArrayList<List<Integer>>();
		if(k == 1) {
			List<List<Integer>> nResults = new ArrayList<List<Integer>>();
			for(int i=1; i<=n; i++) {
				List<Integer> item = new ArrayList<Integer>();
				item.add(i);
				nResults.add(item);
			}
			return nResults;
		}
		
		List<List<Integer>> nResults = combine(n-1, k-1);
		for(List<Integer> x: nResults) {
			x.add(n);
		}
		nResults.addAll(combine(n-1, k));
		
		return nResults;
	}
	
	@LeetCode(205)
	public boolean isIsomorphic(String s, String t) {
		int[] a = new int[256];
		int[] b = new int[256];

		for(int i=0; i<s.length(); i++) {
			char c1 = s.charAt(i);
			char c2 = t.charAt(i);

			if(a[c1] != 0) {
				if(a[c1] != c2) return false;
			} else {
				if(b[c2] != 0) return false;
				a[c1] = c2;
				b[c2] = c1;
			}
		}
		return true;
	}
	
	public void split(int n, List<Long> results) {
		if(n == 1) {
			results.add(1L);
			return;
		}
		
		List<Long> tmp = new ArrayList<Long>();
		split(n-1, tmp);
		for(Long s: tmp) {
			System.out.println("#"+s);
			results.add(s*10 + 1);
			results.add(s + 1);
			//int v = Integer.parseInt(s.substring(s.length()-1));
			//if(v < 9)
			//	results.add(s.substring(0,  s.length()-1) + String.valueOf(v + 1));
		}
	}
	
public List<Integer> grayCode(int n) {
        List<Integer> results = new ArrayList<Integer>();
        results.add(0);
       // results.add(1);
         int v = 0;
        	v = grayCode(v, n, results);
        
        return results;
    }

private int grayCode(int v, int n, List<Integer> results) {
	if(n < 2) {
	for(int i=0; i<n; i++) {
		v =  0x1 << i ^ v;
		
		results.add(v);
	}
	
	for(int i=0; i<n-1; i++) {
		v =  0x1 << i ^ v;
		
		results.add(v);
	}
	} else {
		grayCode(v, n-1, results);
	}
	
	return v;
}

private int revertBit(int num, int n) {
	return (num >> n) & 0x1 << n ^ num;
}

public String convertNumber(int n) {
	StringBuffer sbf = new StringBuffer();
	
	if(n/1000 > 0) {
		sbf.append(this.convert3digits(n/1000)).append(" thousand ");
	}
	
	sbf.append(this.convert3digits((n%1000)));
	
	System.out.println(sbf.toString());
	return sbf.toString();
}

private String convert3digits(int n) {
	StringBuffer sbf = new StringBuffer();

	int v = n % 1000;

	while (v > 0) {
		if ( v / 100 > 0) {
			sbf.append(v/100).append(" hundred ");
			v = v % 100;
		} else if(v / 10 > 1 ) {
			sbf.append(v/10).append(" tens ");

			v = v % 10;
		} else {
			sbf.append(v);
			v = 0;
		}
	}

	
	return sbf.toString();
}

}


class LRUCache {
	private int counter = 0;
	private int capacity = 0;

	private Map<Integer,Integer> items = new HashMap<Integer,Integer>();
	private LinkedList<Integer> list = new LinkedList<Integer>();

	public LRUCache(int capacity) {
		this.capacity = capacity;
	}

	public int get(int key) {
		if(items.keySet().contains(key)) {
			list.removeFirstOccurrence(key);
			list.addLast(key);
			return items.get(key).intValue();
		}
		return -1;
	}

	@LeetCode(value=146, c="a")
	public void set(int key, int value) {
		if(items.keySet().contains(key)) {
			list.removeFirstOccurrence(key);
			list.addLast(key);

			items.put(key, value);
		} else {
			if(counter >= capacity) {
				items.remove(list.removeFirst());
			} else {
				counter++;
			}

			list.add(key);
			items.put(key, value);
		}
	}
}

class sum_dig
{
    // Recursive function to count 'n' digit numbers
    // with sum of digits as 'sum'. This function
    // considers leading 0's also as digits, that is
    // why not directly called
    static int countRec(int n, int sum)
    {
        // Base case
        if (n == 0)
           return sum == 0 ?1:0;
      
        // Initialize answer
        int ans = 0;
      
        // Traverse through every digit and count
        // numbers beginning with it using recursion
        for (int i=0; i<=9; i++)
           if (sum-i >= 0)
              ans += countRec(n-1, sum-i);
      
        return ans;
    }
      
    // This is mainly a wrapper over countRec. It
    // explicitly handles leading digit and calls
    // countRec() for remaining digits.
    static int finalCount(int n, int sum)
    {
        // Initialize final answer
        int ans = 0;
      
        // Traverse through every digit from 1 to
        // 9 and count numbers beginning with it
        for (int i = 1; i <= 9; i++)
          if (sum-i >= 0)
             ans += countRec(n-1, sum-i);
      
        return ans;
    }
 
    /* Driver program to test above function */
    public static void main (String args[])
    {
          int n = 2, sum = 5;
          System.out.println(finalCount(n, sum));
    }
}/* This code is contributed by Rajat Mishra */
