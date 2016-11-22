package exams.n4;

import java.util.ArrayList;
import java.util.List;

public class N438 {

	public static void main(String[] args) {
		System.out.println(new N438().findAnagrams("abab", "ab"));
		
		System.out.println(new N438().findAnagrams("cbaebabacd", "abc"));
	}

	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> results = new ArrayList<Integer>();
		if(s == null || s.length() < p.length()) return results;
		
		int plen = p.length();
		int slen = s.length();
		
		char[] cc = new char[26];
		for(int i=0; i<p.length(); i++) {
			cc[p.charAt(i)-'a']++;
		}
		String key = new String(cc);

		cc = new char[26];
		for(int i=0; i<plen-1; i++) {
			cc[s.charAt(i)-'a']++;
		}
		
		for(int i=plen-1; i<slen; i++) {
			cc[s.charAt(i)-'a']++;
			
			if((new String(cc)).equals(key)) results.add(i-plen+1);
			cc[s.charAt(i-plen+1)-'a']--;
		}
		
		return results;
	}
}
