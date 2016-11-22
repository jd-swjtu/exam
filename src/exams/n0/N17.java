package exams.n0;

import java.util.ArrayList;
import java.util.List;

public class N17 {

	public static void main(String[] args) {
		System.out.println(new N17().letterCombinations("23"));
	}

	public List<String> letterCombinations(String digits) {
		String[] mapping = new String[]{"+", "", "abc","def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

		List<String> results = new ArrayList<String>();
		results.add("");
		
		for(int i=0; i<digits.length(); i++) {
			int offset = digits.charAt(i) - '0';
			String ss = mapping[offset];
			if(ss.equals("")) continue;

			int size = results.size();

			List<String> tmp = new ArrayList<String>();
			for(int j=0; j<size; j++) {
				String prev = results.get(j);
				for(char c: ss.toCharArray()) {
					tmp.add(prev + c);
				}
			}
			results = tmp;
		}
		return results;
	}
}
