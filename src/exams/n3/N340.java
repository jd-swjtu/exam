package exams.n3;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/*
 Given a string, find the length of the longest substring T that contains at most k distinct characters.

For example, Given s = “eceba” and k = 2,

T is "ece" which its length is 3.
 */
public class N340 {
	
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
		if (s == null || s.length() == 0 || k <= 0) return 0;
		
		Map<Character,Integer> map = new HashMap<>();
		
		int max = 0;
		int left=0;
		for(int i=0;i<s.length(); i++) {
			
			Character c = s.charAt(i);

			map.put(c, map.getOrDefault(c, 0) + 1);
			
			while ( map.keySet().size() > k) {
				//del from the first
				char cc = s.charAt(left++);
				int nr = map.get(cc);
				if (nr - 1 == 0) {
					map.remove(cc);
					break;
				} else {
					map.put(cc, nr - 1);
				}
			}
			
			if(map.keySet().size() == k) {
				max = Math.max(max, i-left+1);
			}
		}
		
        return max;
    }

	public static void main(String[] args) {
		System.out.println(new N340().lengthOfLongestSubstringKDistinct("ecbeeebbaaa",  3));
	}

}
