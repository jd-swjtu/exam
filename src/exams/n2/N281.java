package exams.n2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Given two 1d vectors, implement an iterator to return their elements alternately.

For example, given two 1d vectors:

v1 = [1, 2]
v2 = [3, 4, 5, 6]
By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1, 3, 2, 4, 5, 6].

Follow up: What if you are given k 1d vectors? How well can your code be extended to such cases?

Clarification for the follow up question - Update (2015-09-18):
The "Zigzag" order is not clearly defined and is ambiguous for k > 2 cases. If "Zigzag" does not look right to you, replace "Zigzag" with "Cyclic". For example, given the following input:

[1,2,3]
[4,5,6,7]
[8,9]
It should return [1,4,8,2,5,9,3,6,7].
 */
public class N281 {

	public static void main(String[] args) {
		//ZigzagIterator it = new ZigzagIterator(Arrays.asList(1,2), Arrays.asList(3,4,5,6));
		ZigzagIterator it = new ZigzagIterator(Arrays.asList(1,2,3), Arrays.asList(4,5,6,7), Arrays.asList(8,9));
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

}

class ZigzagIterator {
	class Source {
		List<Integer> s;
		int idx = 0;
		
		public Source(List<Integer> s) {
			this.s = s;
		}
	}

	private Queue<Source> sources;
	private Source cur = null;

    public ZigzagIterator(List<Integer>... args) {
    	sources = new LinkedList<>();
    	for(List<Integer> v: args)
    		sources.offer(new Source(v));
    	
    	if(sources.size() > 0)
    		cur = sources.poll();
    }

    public int next() {
    	if(cur != null) {
    		int v = cur.s.get(cur.idx);
    		cur.idx += 1;
    		
    		if(sources.size() > 0) {
				sources.offer(cur);
				cur = sources.poll();
    		} else {
    			if(cur.idx == cur.s.size()) {
    				cur = null;
    			}
    		}
    		return v;
    	}
    	return -1;
    	
    }

    public boolean hasNext() {
    	if(cur == null) return false;
    	
    	if(cur.idx < cur.s.size()) return true;
    	while (!sources.isEmpty()) {
    		cur = sources.poll();
    		if(cur.idx < cur.s.size()) return true;
    	}
    	return false;
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
