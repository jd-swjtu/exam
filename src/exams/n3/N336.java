package exams.n3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class N336 {

	public static void main(String[] args) {
		String[] words = {"abcd", "dcba", "lls", "s", "sssll"};
		//String[] words = {"a", ""};
		//String[] words = {"abb", "bba", "bb", "a"};
		System.out.println(new N336().palindromePairs(words));
	}
	
    public List<List<Integer>> palindromePairs(String[] words) {
    	List<List<Integer>> result = new ArrayList<>();
    	
    	Map<String,Integer> map = new HashMap<>();
		int i=0;
		for(String s: words) {
			map.put(s, i++);
		}
		for(i=0; i<words.length; i++) {
			String s = words[i];
			for(int j=0; j<s.length()+1; j++) {
				String left = s.substring(0, j);
				String right = s.substring(j);
				
				if (isPalindrome(left)) {
					String rev = reverse(right);
					if(map.containsKey(rev) && map.get(rev).intValue() != i) {
						List<Integer> ret = new ArrayList<>();
						ret.add(map.get(rev));
						ret.add(i);
						result.add(ret);
					}
				}
				if (isPalindrome(right)) {
					String rev = reverse(left);
					if(map.containsKey(rev) && map.get(rev).intValue() != i) {
						List<Integer> ret = new ArrayList<>();
						ret.add(i);
						ret.add(map.get(rev));
						result.add(ret);
					}
				}
			}
		}
		return result;
    }
	
	public String reverse(String s) {
		return new StringBuffer(s).reverse().toString();
	}
	
	public boolean isPalindrome(String s) {
		if (s==null || s.length() == 0 || s.length() == 1) return true;
		int start =0;
		int end = s.length() - 1;
		while (start < end) {
			if(s.charAt(start++) != s.charAt(end--))
				return false;
		}
		return true;
	}

}
