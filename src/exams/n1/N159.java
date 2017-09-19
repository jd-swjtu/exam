package exams.n1;

import java.util.HashMap;
import java.util.Map;

public class N159 {

	public static void main(String[] args) {
		String s ="ecacecce";
		System.out.println(new N159().get(s));
		System.out.println(new N159().getMax(s));
	}
	
	public int getMax(String s) {
		Map<Character, Integer> map = new HashMap<>();
		int max = 0;
		
		char[] chars = s.toCharArray();
		
	    int start = 0;
	    int end = 0;
	    while(end < chars.length) {
	    	char c = chars[end++];
	    	map.put(c, map.getOrDefault(c, 0)+1);

	    	while(map.size() >2) {
	    		c = chars[start];
	    		int count = map.get(c)-1;
	    		if (count == 0) {
	    			map.remove(c);
	    		} else
	    		map.put(c, count);
	    		start++;
	    	}
	    	max = Math.max(max, end-start);
	    }
		
		return max;
	}
	
	public int get(String s) {
		int lcs=0; //last char handled - position
		char lc=' '; //last char handled
		int start = 0; 
		char ca=' ', cb=' '; //current two chars
		int max = 0;
		
		char[] a = s.toCharArray();
		for(int i=0; i<a.length; i++) {
			//two chars are not filled in
			if (ca == ' ' || cb == ' ') {
				max = Math.max(i-start + 1, max);
				//char a has been filled in, and current char is not char a. It must be char b
				if (ca != ' ' && a[i] != ca) {
					cb = a[i];
				} else {
					ca = a[i];
				}
				//Since char a/b is empty, so last char always changed
				lcs = i;
				lc = a[i];
			} else if ( a[i] != ca && a[i] != cb) {
				//current char is not char a or b, need move forward
				start = lcs;
				lcs = i;
				//move out char a
				if (lc == ca) {
					cb = a[i];
				} else {
					ca = a[i];
				}
				lc = a[i];
			} else {
				//current is char a or b, if last char changed, change lcs/lc
				if (lc != a[i]) {
					lcs = i;
					lc = a[i];
				}
				max = Math.max(i-start + 1, max);
			}
		}
		System.out.println("Max: " + max);
		return max;
	}
}
