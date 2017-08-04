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
		LinkedList<Character> list = new LinkedList<>();
		
		int max = 0;
		for(int i=0;i<s.length(); i++) {
			Character c = s.charAt(i);

			if (!map.keySet().contains(c)) {
				while ( map.keySet().size() == k) {
					//move the first one
					Character cc = list.removeFirst();
					int nr = map.get(cc);
					if (nr - 1 == 0) {
						map.remove(cc);
						break;
					} else {
						map.put(cc, nr - 1);
					}
				}
				map.put(c, 1);
				list.addLast(c);
			} else {
				map.put(c, map.getOrDefault(c, 0) + 1);
				list.addLast(c);
			}
			
			if (map.keySet().size() == k) {
				if(list.size() > max) {
					max = list.size();
				}
			}
		}
		
        return max;
    }

	public static void main(String[] args) {
		System.out.println(new N340().lengthOfLongestSubstringKDistinct("eceba",  2));
	}

}
