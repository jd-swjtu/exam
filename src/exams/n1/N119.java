package exams.n1;

import java.util.ArrayList;
import java.util.List;

public class N119 {

	public static void main(String[] args) {
		System.out.println(new N119().getRow2(5));
	}

	public List<Integer> getRow(int rowIndex) {
		List<Integer> results = new ArrayList<Integer>();

		results.add(1);
		if(rowIndex >= 1) {
			results.add(1);
		}

		if(rowIndex >=2) {
			for(int i=2; i<=rowIndex; i++) {
				int lsize = results.size();

				int tmp = results.get(lsize-2);
				results.add(lsize-1, results.get(lsize-1) + tmp);

				for(int k=lsize-2; k>=1; k--) {
					results.set(k, tmp + results.get(k-1));
					tmp = results.get(k-1);
				}
			}
		}

		return results;
	}
	
	public List<Integer> getRow2(int rowIndex) {
		List<Integer> results = new ArrayList<Integer>();

		results.add(1);
		if(rowIndex >= 1) {
			results.add(1);
		}

		if(rowIndex >= 2) {
			for(int i=2; i<=rowIndex; i++) {
				int lsize = results.size();

				results.add(1);
				for(int j=lsize-1; j>0; j--) {
					results.set(j, results.get(j) + results.get(j-1));
				}
			}
		}

		return results;
	}
}
