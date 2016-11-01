package exams.aa;

import exam.LeetCode;

public class N5 {

	public static void main(String[] args) {
		System.out.println(new N5().longestPalindrome("cccxccxccx"));
	}

	@LeetCode(value=5, c="a")
	public String longestPalindrome(String s) {
		if(s == null || s.length() <=1) return s;
		
		int len = s.length();
		
		String maxString = "";
		for(int i=0; i<len; i++) {
			String ss = helper(s, i-1, i+1, len);
			if(ss.length() > maxString.length()) maxString = ss;
			
			ss = helper(s, i, i+1, len);
			if(ss.length() > maxString.length()) maxString = ss;
		}
		return maxString;
	}
	
	private String helper(String s, int l, int r, int len) {
		while(l>=0 && r<len && s.charAt(l) == s.charAt(r)) {
			l--;
			r++;
		}
		return s.substring(l+1, r);
	}
}
