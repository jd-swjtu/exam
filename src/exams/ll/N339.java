package exams.ll;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class N339 {
/*
 * Given a nested list of integers, return the sum of all integers in the list weighted by their depth.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Example 1:
Given the list [[1,1],2,[1,1]], return 10. (four 1's at depth 2, one 2 at depth 1)
 */
	
	public static void main(String[] args) {
		NI ni = new NI("1,2,[3,[4,5]]");
		System.out.println(new N339().depthSum(ni.getList()));
		System.out.println(new N339().depthSum2(ni.getList()));
		System.out.println(new N339().depthSumInverse(ni.getList()));
		System.out.println(new N339().depthSumInverse(new NI("1,[4,[6]]").getList()));
	}

	public int depthSum(List<NestedInteger> nestedList) {
		return depthSum(nestedList, 1, 0);
	}

	private int depthSum(List<NestedInteger> nestedList, int level, int w) {
		for(NestedInteger ni: nestedList) {
			if(ni.isInteger()) {
				w += ni.getInteger().intValue() * level;
			} else {
				w = depthSum(ni.getList(), level+1, w);
			}
		}
		return w;
	}
	
	public int depthSum2(List<NestedInteger> nestedList) {
		int sum = 0;
		
		int levels = 0;
		Queue<NestedInteger> q = new LinkedList<NestedInteger>();
		for(NestedInteger ni: nestedList) {
			q.add(ni);
		}
		
		while(!q.isEmpty()) {
			levels++;
			int size = q.size();
			for(int i=0; i<size; i++) {
				NestedInteger ni = q.poll();
				if(ni.isInteger()) {
					sum += levels * ni.getInteger();
				} else {
					for(NestedInteger nii: ni.getList()) {
						q.add(nii);
					}
				}
			}
		}
		
		return sum;
	}
	
	public int depthSumInverse(List<NestedInteger> nestedList) {
		Map<Integer, Integer> results = new HashMap<Integer, Integer>();
		
		for(NestedInteger ni: nestedList) {
			levels(ni, results, 0);
		}
		
		int size = results.keySet().size();
		int sum = 0;
		for(Integer k: results.keySet()) {
			sum += (size - k.intValue()) * results.get(k).intValue();
		}
		return sum;
	}
	
	private void levels(NestedInteger ii, Map<Integer, Integer> results, int level) {
		if(ii.isInteger()) {
			if(!results.containsKey(level)) {
				results.put(level, ii.getInteger());
			} else {
				results.put(level, ii.getInteger() + results.get(level));
			}
		} else {
			for(NestedInteger ni: ii.getList()) {
				levels(ni, results, level+1);
			}
		}
	}
}

class NI implements NestedInteger {
	private boolean isInteger = false;
	private Integer val = null;;
	private List<NestedInteger> vals = new ArrayList<NestedInteger>();

	public NI(){}

	public NI(int v) {
		this.val = v;
		isInteger = true;
	}

	public void add(NI ni) {
		vals.add(ni);
	}

	public String toString() {
		StringBuffer sbf = new StringBuffer();
		if(this.isInteger) sbf.append(this.val).append(", ");
		else
			for(NestedInteger ni: this.vals) {
				if(!ni.isInteger())
					sbf.append("[");
				sbf.append(ni.toString());
				if(!ni.isInteger()) sbf.append("]");
			}

		return sbf.toString();
	}

	public NI(String s) {
		LinkedList<NI> stack = new LinkedList<NI>();
		stack.add(this);

		NI cur = this;
		String[] strs = s.split(",");
		for(int i=0; i<strs.length;) {
			String ss = strs[i];

			ss = ss.trim();

			if(ss.startsWith("[")) {
				NI ni = new NI();
				stack.push(ni);

				cur.add(ni);
				cur = ni;
				ss = ss.substring(1);
				strs[i] = ss;

				continue;
			}

			int levels = 0;
			while(ss.endsWith("]")) {
				levels ++;

				ss = ss.substring(0, ss.length()-1);
				ss = ss.trim();
			}

			NI ni = new NI(Integer.parseInt(ss));
			cur.add(ni);

			while(levels > 0) {
				cur = stack.pop();
				levels--;
			}
			cur = stack.peek();
			i++;
		}
	}

	@Override
	public boolean isInteger() {
		return this.isInteger;
	}

	@Override
	public Integer getInteger() {
		if(this.isInteger) return val;
		return null;
	}

	@Override
	public List<NestedInteger> getList() {
		return this.vals;
	}

}

//This is the interface that allows for creating nested lists.
//You should not implement it, or speculate about its implementation
interface NestedInteger {

	// @return true if this NestedInteger holds a single integer, rather than a nested list.
	public boolean isInteger();

	// @return the single integer that this NestedInteger holds, if it holds a single integer
	// Return null if this NestedInteger holds a nested list
	public Integer getInteger();

	// @return the nested list that this NestedInteger holds, if it holds a nested list
	// Return null if this NestedInteger holds a single integer
	public List<NestedInteger> getList();
}