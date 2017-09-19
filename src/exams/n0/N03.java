package exams.n0;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class N03 {

	public static void main(String[] args) {
		System.out.println(new N03().longString("axxab"));
		System.out.println(new N03().longString2("axxab"));
		System.out.println(new N03().longString3("axxab"));
	}

	public int longString(String ss) {
		if(ss == null || ss.length() < 1) return 0;
		
		Map<Character,Integer> hash = new HashMap<Character,Integer>();
		int len = ss.length();
		
		int start = 0;
		int max = 0;
		for(int i=0; i<len; i++) {
			char c = ss.charAt(i);
			if(hash.containsKey(c)) {
				start = Math.max(start, hash.get(c).intValue() + 1);
			}
			
			hash.put(c, i);
			max = Math.max(max, i - start + 1);
			//System.out.println(start + " ##: " + ss.substring(start, i+1));
		}
		
		return max;
	}
	
	public int longString2(String ss) {
		if(ss == null || ss.length() < 1) return 0;
		
		LinkedList<Character> q = new LinkedList<Character>();
		for(char c: ss.toCharArray()) {
			if(q.contains(c)) {
				while(q.removeFirst().charValue() != c){}
			}
			q.add(c);
		}
		return q.size();
	}
	
	public int longString3(String ss) {
		if(ss == null || ss.length() < 1) return 0;
		int max = 0;
		Map<Character,Integer> map = new HashMap<>();
		
		int start=0;
		int end=0;
		int count=0;
		while(end < ss.length()) {
			char c = ss.charAt(end++);
			map.put(c, map.getOrDefault(c, 0)+1);
			if(map.get(c) > 1) {
				count++;
			}
			while(count>0) {
				c = ss.charAt(start++);
				map.put(c, map.getOrDefault(c, 0)-1);
				if(map.get(c) == 1) count--;
			}
			max = Math.max(max, end-start);
		}

		return max;
	}
}
