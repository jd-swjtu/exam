package exams.n1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N120 {

	public static void main(String[] args) {
		List<List<Integer>> t = new ArrayList<List<Integer>>();
		t.add(Arrays.asList(2));
		t.add(Arrays.asList(3,4));
		t.add(Arrays.asList(6,5,7));
		t.add(Arrays.asList(4,1,8,3));
		
		System.out.println(new N120().minimumTotal(t));
		
	}

	public int minimumTotal(List<List<Integer>> triangle) {
		int n = triangle.size();
		
	
		List<Integer> v = triangle.get(n-1);
		for(int i=n-2; i>=0; i--) {
			List<Integer> c = triangle.get(i);
			
			for(int j=0;j<c.size();j++)
			  v.set(j, Math.min(v.get(j), v.get(j+1)) + c.get(j));
		}
		return v.get(0);
        
    }
}
