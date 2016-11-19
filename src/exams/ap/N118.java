package exams.ap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N118 {

	public static void main(String[] args) {
		System.out.println(new N118().generate(3));
	}
	/*
	 * Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]

	 */
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> results = new ArrayList<>();
		if(numRows <= 0) return results;

		results.add(new ArrayList<Integer>(Arrays.asList(1)));
		if(numRows == 1) return results;

		results.add(new ArrayList<Integer>(Arrays.asList(1,1)));
		if(numRows == 2) return results;

		for(int i=1; i<numRows-1; i++) {
			List<Integer> prev = results.get(i);
			List<Integer> tmp = new ArrayList<Integer>();
			tmp.add(1);
			for(int j=0; j<prev.size()-1; j++) {
				tmp.add(prev.get(j) + prev.get(j+1));
			}
			tmp.add(1);
			results.add(tmp);
		}

		return results;
	}
}
