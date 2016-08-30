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
	}


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
}
