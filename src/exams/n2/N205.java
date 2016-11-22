package exams.n2;

import java.util.HashMap;
import java.util.Map;

public class N205 {

	public static void main(String[] args) {
		System.out.println(new N205().isIsomorphic("egg", "add"));
		System.out.println(new N205().isIsomorphic("foo", "bar"));
		System.out.println(new N205().isIsomorphic("paper", "title"));
		System.out.println(new N205().isIsomorphic("abcd", "xyzz"));
	}
	/*
	 * Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

For example,
Given "egg", "add", return true.

Given "foo", "bar", return false.

Given "paper", "title", return true.
	 */

	public boolean isIsomorphic(String s, String t) {
		Map<Character,Character> st = new HashMap<Character,Character>();
		
		int len = s.length();
		if(t.length() != len) return false;
		
		for(int i=0; i<len; i++) {
			char sc = s.charAt(i);
			char tc = t.charAt(i);
			
			if(!st.containsKey(sc)) {
				if(st.values().contains(tc)) return false;
				st.put(sc, tc);
			} else {
				if(!st.get(sc).equals(tc)) return false;
			}
		}
		return true;
	}
}
