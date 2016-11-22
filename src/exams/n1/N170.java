package exams.n1;

import java.util.HashMap;
import java.util.Map;

public class N170 {

	public static void main(String[] args) {
		TwoSum ts = new TwoSum();
		ts.add(1); 
		ts.add(3);
		ts.add(1);
		ts.add(5);
		System.out.println(ts.find(4));
		System.out.println(ts.find(7));
		System.out.println(ts.find(2));
	}

	/*
	 *Design and implement a TwoSum class. It should support the following operations: add and find.

add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the value.

For example,

add(1); 
add(3); 
add(5);
find(4) -> true
find(7) -> false
	 */
}

class TwoSum {
	private Map<Integer,Integer> nums = new HashMap<Integer,Integer>();
	
	public TwoSum() {}
	
	public void add(int n) {
		if(!nums.containsKey(n)) {
			nums.put(n, 1);
		} else {
			nums.put(n, nums.get(n).intValue()+1);
		}
	}
	
	public boolean find(int n) {
		for(Integer i: nums.keySet()) {
			int v = n - i.intValue();
			
			if(i.equals(v)) {
				int vv = nums.get(i).intValue();
				return vv>1;
			} else {
				if(nums.containsKey(v)) return true;
			}
		}
		return false;
	}
}
