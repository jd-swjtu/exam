package exams.n0;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class N49 {

	public static void main(String[] args) {
		System.out.println(new N49().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
	}

	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> results = new ArrayList<List<String>>();
		Map<String,List<String>> resultss = new HashMap<String,List<String>>();
		
		for(String str: strs) {
			char[] counts = new char[26];
			for(char c: str.toCharArray()) {
				counts[c-'a']++;
			}
			String key = new String(counts);
			if(!resultss.containsKey(key)) {
				resultss.put(key, new ArrayList<String>());
			}
			resultss.get(key).add(str);
		}
		
		results.addAll(resultss.values());
		return results;
	}
}
