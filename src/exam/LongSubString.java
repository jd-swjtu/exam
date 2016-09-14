package exam;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class LongSubString {
	public static void main(String[] args) {
		String[] ss = { "abcabcbb", "bbbbb", "pwwkew" };

		for (String s : ss) {
			System.out.println(new LongSubString().longString(s));
		}
		
		System.out.println(new LongSubString().strStr("",""));
		System.out.println(new LongSubString().longestPalindrome("ccc"));
		
		System.out.println(new LongSubString().isAnagram("aacc", "ccac"));
		Set<String> wordDict = new HashSet<String>();
		wordDict.add("leet");
		wordDict.add("code");
		System.out.println(new LongSubString().wordBreak("leetcode", wordDict));
		
	}

	@LeetCode(value=242, c="a")
	public boolean isAnagram(String s, String t) {
        if(s == null && t == null) return true;
        if(s == null || t == null) return false;
        if(s.length() != t.length()) return false;
        
        int[][] v = new int[2][26];
        int len = s.length();
        for(int i=0; i<len; i++) {
            v[0][s.charAt(i) - 'a']++;
            v[1][t.charAt(i) - 'a']++;
        }
        
        for(int i=0; i<26; i++) {
        	if (v[0][i] != v[1][i]) return false;
        }
        return true;
    }
/*
 Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

Subscribe to see which companies asked this question
 */
	@LeetCode(3)
	public int longString(String ss) {
		System.out.println("####" + ss);
		Set<Character> s = new HashSet<Character>();
		Queue<Character> q = new ArrayDeque<Character>();
		int max = 0;

		for (int i = 0; i < ss.length(); i++) {
			char c = ss.charAt(i);

			if (s.contains(c)) {
				char x = 0;
				do {
					x = q.poll();
					s.remove(x);
				} while ( x != c);

			}
			s.add(c);
			q.add(c);

			int m = s.size();
			if (m > max) {
				max = m;

				/*for(Object k: q.toArray()) {
					System.out.print(k);
				}
				System.out.println( " ---  " + m);
				for(Object k: s) {
					System.out.print(k);
				}
				System.out.println( " -+--  " + m);*/
			}
		}
		return max;
	}

	@LeetCode(value=5, c="a")
	public String longestPalindrome(String s) {
		if(s == null) return "";
		if(s.length() == 1) return s;
		
		int max = 0;
		String result = "";
		int len = s.length();
		for(int i=0; i<len; i++) {
			int count = 1;
			while(i-count>=0 && i+count <len && s.charAt(i-count) == s.charAt(i+count)) {
				count++;
			}
			count -= 1;
			
			if(2 * count + 1 > max) {
				max = count * 2 +1;
				result = s.substring(i-count, i+count+1);
			}
			
			//other
			count = 1;
			while(1 + i-count>=0 && i+count <len && s.charAt(1 + i-count) == s.charAt(i+count)) {
				count++;
			}
			count -= 1;
			
			if(2 *count > max) {
				max = count * 2;
				result = s.substring(1 + i-count, i+count+1);
			}
		}
		return result;
	}
	
	//#28
	@LeetCode(28)
	public int strStr(String haystack, String needle) {
		if(haystack == null || needle == null) return -1;
		if(needle.length() > haystack.length()) return -1;
		//if(needle.equals(haystack)) return 0;
		
		for(int i=0; i<=haystack.length() - needle.length(); i++) {
			int j=0;
			while(j<needle.length() && haystack.charAt(i+j) == needle.charAt(j)) {
				j++;
			}
			if(j == needle.length()) return i;
		}
		
		return -1;
	}
	
	/*Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

	For example, given
	s = "leetcode",
	dict = ["leet", "code"].

	Return true because "leetcode" can be segmented as "leet code".*/
	@LeetCode(value=139, c="a")
	public boolean wordBreak(String s, Set<String> wordDict) {
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;
		for(int i=0; i<s.length(); i++) {
			for(int j=i; j>=0; j--) {
				if(dp[j] && wordDict.contains(s.substring(j,  i+1))) {
					dp[i+1] = true;
					break;
				}
			}
		}
		
		return dp[s.length()];
	}

	//low performance
	private boolean wordBreak(String str, int s, int e, Set<String> wordDict) {
		if(s == e) return true;
		for(int i=s+1; i<=e; i++) {
			String ss = str.substring(s, i);
			if(wordDict.contains(ss)) {
				if(wordBreak(str, i, e, wordDict)) return true;
			}
		}
		return false;
	}
	
	private boolean wordBreak2(String str, int s, int e, Set<String> wordDict) {
		if(s == 0) return true;
		for(int i=e-1; i>=s; i--) {
			String ss = str.substring(i, e);
			if(wordDict.contains(ss)) {
				if(wordBreak2(str, 0, i, wordDict)) return true;
			}
		}
		return false;
	}
}
