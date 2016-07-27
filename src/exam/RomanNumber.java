package exam;

import java.util.ArrayList;
import java.util.List;

public class RomanNumber {
	List<String> results = new ArrayList<String>();


	public static void main(String[] args) {
		RomanNumber rn = new RomanNumber();
		System.out.println(rn.intToRoman(3999));
		System.out.println(rn.romanToInt(rn.intToRoman(3999)));

		System.out.println(rn.isPalindrome(12121));

		rn.generateParenthesis(4);
		System.out.println(rn.results.size());
	}

	public List<String> generateParenthesis(int n) {
		List<String> results = new ArrayList<String>();
		this.go(1, 0, n, "(");
		return results;
	}

	public void go(int l, int r, int t, String s) {
		if(r == t) {
			System.out.println(s);
			results.add(s);
			return;
		}

		if(r < l) {
			if(l < t) {
				go(l+1, r, t, s + "(");
				go(l, r+1, t, s + ")");
			} else {
				go(l, r+1, t, s + ")");
			}
		} else {
			if(l < t) {
				go(l+1, r, t, s + "(");
			} else {
				go(l, r+1, t, s + ")");
			}
		}
	}

	public boolean isPalindrome(int x) {
		if(x<0) return false;

		int n = x;
		int r = 0;

		while(n > 0) {
			r = r * 10 + n % 10;
			n = n/10;
		}

		if(r == x) return true;
		return false;
	}

	public int romanToInt(String s) {
		int[] vv = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		String[] pp = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

		int v = 0;
		int i = 0;
		while(s.length() > 0 && i<pp.length) {
			String ss = pp[i];
			if(s.startsWith(ss)) {
				v += vv[i];

				s = s.substring(ss.length());
			} else {
				i++;
			}
		}

		return v;
	}

	public String intToRoman(int num) {
		if(num > 3999) return "";

		StringBuffer sb = new StringBuffer();
		int[] vv = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		String[] pp = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
		int i = 0;
		while(num > 0) {
			if(num >= vv[i]) {
				sb.append(pp[i]);

				num -= vv[i];
			} else {
				i++;
			}
		}

		return sb.toString();
	}
}
