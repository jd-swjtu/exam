package exams.n0;

import java.util.HashMap;
import java.util.Map;
/*
 Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.


 */
public class N13 {

	public static void main(String[] args) {
		System.out.println(new N13().romanToInt("IX"));

	}

	public int romanToInt(String s) {
		Map<Character,Integer> mapping = new HashMap<>();
		mapping.put('M', 1000);
		mapping.put('D', 500);
		mapping.put('C', 100);
		mapping.put('L', 50);
		mapping.put('X', 10);
		mapping.put('V', 5);
		mapping.put('I', 1);
	
		int value = 0;
		/*for(int i=0; i<s.length(); i++) {
			int cv = mapping.get(s.charAt(i));
			value += cv;
			if(i+1<s.length()) {
				int nv = mapping.get(s.charAt(i+1));
				if(nv>cv) {
					value -= cv + cv;
				}
			}
		}
		*/
		
		int pv = mapping.get(s.charAt(s.length()-1));
		value = pv;
		for(int i=s.length()-2; i>=0; i--) {
			int cv = mapping.get(s.charAt(i));
			value += (cv<pv)?-cv:cv;
			
			pv = cv;
		}
		return value;
	}
}
