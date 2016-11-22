package exams.n2;

import java.util.ArrayList;
import java.util.List;

public class N254 {

	public static void main(String[] args) {
		//new N254().helper(16, 2, "");

		List<Integer> list = new ArrayList<Integer>();
		new N254().helper(2, 1, 16, list);
		
	}
/*
 * numbers can be regarded as product of its factors. For example,

8 = 2 x 2 x 2;
  = 2 x 4.

Write a function that takes an integer n and return all possible combinations of its factors.

Note:
You may assume that n is always positive.
Factors should be greater than 1 and less than n.
 */
	
	public List<List<Integer>> getFactors(int n) {
		return null;
	}
	
	public void helper(int n, int start, String s) {
	 
		int l = n/start;
		boolean divided = false;
		for(int i=start; i<=l; i++) {
			//if(i * prod > n) break;
			if(n%i == 0) {
				//if(n/i>3)
				divided = true;
					helper(n/i, i, String.format("%s x %d", s, i));
			}
		}
		if(!divided) {
			System.out.println(s + " * " + n);
		}
	}
	
	public void helper(int start, int product, int n, List<Integer> curr){
	    if(start>n || product > n )
	        return ;
	 
	    if(product==n) {
	        System.out.println(curr);
	        return;
	    }   
	 
	    for(int i=start; i<n; i++){
	        if(i*product>n)
	            break;
	 
	        if(n%i==0){
	            curr.add(i);
	            helper(i, i*product, n, curr);
	            curr.remove(curr.size()-1);
	        }
	    }
	}
}
