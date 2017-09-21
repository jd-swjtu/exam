package exams.n2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:

"abc" -> "bcd" -> ... -> "xyz"
Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.

For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"], 
A solution is:

[
  ["abc","bcd","xyz"],
  ["az","ba"],
  ["acef"],
  ["a","z"]
]

 */
public class N249 {

	public static void main(String[] args) {
		for(List<String> r: new N249().groupStrings(new String[]{"abc","bcd","acef","xyz","az","ba","a","z"})) {
			System.out.println(r);
		}
	}

	public List<List<String>> groupStrings(String[] strings) {
        Map<String,List<String>> map = new HashMap<>();
        for(String s: strings) {
        	String key = this.stringKey(s);
        	if (key == "") continue;
        	
        	List<String> ret = map.get(key);
        	if(ret == null) {
        		ret = new ArrayList<String>();
        		map.put(key, ret);
        	}
        	ret.add(s);
        }
        
        List<List<String>> results = new ArrayList<>();
        results.addAll(map.values());
        return results;
    }
	
	private String stringKey(String s) {
		if(s.length() == 1) return "+1";
		char fc = s.charAt(0);
		char pc = s.charAt(1);
		int d = pc - fc;
		if (d == 'z' - 'a')
			d = -1;
		else if (d == 'a' - 'z')
			d = 1;
		
		for(char c: s.substring(2).toCharArray()) {
			if (c - pc != d) {
				if (! (( c - pc == 'z' - 'a' && d == -1) || (c-pc == 'a' - 'z' && d == 1)))
					return "";
			}
			pc = c;
		}
		return ((d>0)?"+":"-") + s.length();
	}
}
