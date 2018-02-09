package exams.n0;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
 Substring with Concatenation of All Words

You are given a string, s, and a list of words, words, that are all of the same length. 
Find all starting indices of substring(s) in s that is a concatenation of each word in 
words exactly once and without any intervening characters.

For example, given:
s: "barfoothefoobarman"
words: ["foo", "bar"]

You should return the indices: [0,9].
(order does not matter).
 */
public class N30 {

	public static void main(String[] args) {
		System.out.println(new N30().findSubstring1("vvvvvvvvbafobafobafo", new String[]{"fo", "ba", "fo"}));
		
		System.out.println(new N30().findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","good"}));
	}

	public List<Integer> findSubstring1(String S, String[] L) {
        List<Integer> res = new LinkedList<>();
        if (L.length == 0 || S.length() < L.length * L[0].length())   return res;
        int N = S.length(), M = L.length, K = L[0].length();
        Map<String, Integer> map = new HashMap<>(), curMap = new HashMap<>();
        for (String s : L) {
            if (map.containsKey(s))   map.put(s, map.get(s) + 1);
            else                      map.put(s, 1);
        }
        String str = null, tmp = null;
        for (int i = 0; i < K; i++) {
            int count = 0;  // remark: reset count 
            for (int l = i, r = i; r + K <= N; r += K) {
                str = S.substring(r, r + K);
                if (map.containsKey(str)) {
                    if (curMap.containsKey(str))   curMap.put(str, curMap.get(str) + 1);
                    else                           curMap.put(str, 1);
                    
                    if (curMap.get(str) <= map.get(str))    count++;
                    while (curMap.get(str) > map.get(str)) {
                        tmp = S.substring(l, l + K);
                        curMap.put(tmp, curMap.get(tmp) - 1);
                        l += K;
                        if (curMap.get(tmp) < map.get(tmp)) count--;
                    }
                    if (count == M) {
                        res.add(l);
                        tmp = S.substring(l, l + K);
                        curMap.put(tmp, curMap.get(tmp) - 1);
                        l += K;
                        count--;
                    }
                }else {
                    curMap.clear();
                    count = 0;
                    l = r + K;
                }
            }
            curMap.clear();
        }
        return res;
    }
	
	public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> results = new ArrayList<>();
        if(words.length == 0 || s.length() == 0) return results;
        
        int len = words[0].length();
        Map<String,Integer> map = new HashMap<>();
        for(String ss: words) map.put(ss, map.getOrDefault(ss, 0)+1);
        
        for(int i=0; i<=s.length()-len*words.length; i++) {
        	Map<String,Integer> copy = new HashMap<>(map);
        	for(int j=0; j<words.length; j++) {
        		String str = s.substring(i + j*len , i+ j*len + len);
        		if(!copy.containsKey(str)) break;
        		int c = copy.get(str) - 1;
        		if(c == 0) {
        			copy.remove(str);
        		} else {
        			copy.put(str, c);
        		}
        	}
        	if(copy.isEmpty()) {
        		results.add(i);
        	}
        	
        }
        return results;
    }
}
