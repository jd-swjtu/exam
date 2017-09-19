package exams.n2;

import java.util.HashMap;
import java.util.Map;

public class N267 {

	public static void main(String[] args) {
		Map<Character,Integer> chars = new HashMap<>();
		chars.put('1', 1);
		chars.put('2', 3);
		//chars.put('3', 1);
		
		new N267().get(chars, "", 4);
		
	}
	
	public void get(Map<Character,Integer> chars, String s, int l) {
		if(s.length() == l) {
			System.out.println("#" + s);
		}
		
		for(Character c: chars.keySet()) {
			int count = chars.get(c).intValue();
			if(count > 0) {
				chars.put(c, count-1);
				this.get(chars, s + c, l);
				chars.put(c, count);
			}
		}
	}

}
