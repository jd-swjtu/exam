package exam;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class N339_Solution {

	public static void main(String[] args) {
		NI ni = new NI("1,2,[3,[4,5]]");
		System.out.println(new N339_Solution().depthSum(ni.getList()));
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
}

class NI implements NestedInteger {
	private int val;
	private List<NestedInteger> vals = new ArrayList<NestedInteger>();
	private boolean isInt = false;

	public NI(){}

	public NI(int v) {
		this.val = v;
		isInt = true;
	}

	public void add(NI ni) {
		vals.add(ni);
	}

	public String toString() {
		StringBuffer sbf = new StringBuffer();
		if(this.isInt) sbf.append(this.val).append(", ");
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
		return isInt;
	}

	@Override
	public Integer getInteger() {
		return this.val;
	}

	@Override
	public List<NestedInteger> getList() {
		return this.vals;
	}

}

// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
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
