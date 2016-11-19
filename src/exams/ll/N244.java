package exams.ll;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class N244 {

	public static void main(String[] args) {
		N244 n = new N244(new String[]{"practice", "makes", "perfect", "coding", "makes"});
		
		String word1 = "coding", word2 = "practice";
		System.out.println(n.shortestDistance(word1, word2));
	}

	private Map<String,List<Integer>> map = new HashMap<String,List<Integer>>();
	
	public N244(String[] words) {
		for(int i=0; i<words.length; i++) {
			String word = words[i];
			if(!map.containsKey(word))
				map.put(word, new ArrayList<Integer>());
			
			map.get(word).add(i);
		}
	}
	
	public int shortestDistance(String word1, String word2) {
		int min = Integer.MAX_VALUE;
		for(int i: map.get(word1)) {
			for(int j: map.get(word2)) {
				min = Math.min(min, Math.abs(i-j));
			}
		}
		return min;
	}
}
