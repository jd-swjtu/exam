package exams.ll;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class N56 {

	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(1,3));
		intervals.add(new Interval(2,6));
		intervals.add(new Interval(8,10));
		intervals.add(new Interval(15, 18));
		
		System.out.println(new N56().merge(intervals));
	}

	/*
	 * Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18]. 
	 */

	public List<Interval> merge(List<Interval> intervals) {
		Collections.sort(intervals, new Comparator<Interval>(){

			@Override
			public int compare(Interval arg0, Interval arg1) {
				if(arg0.start == arg1.start) {
					return arg0.end - arg1.end;
				} else {
					return arg0.start - arg1.start;
				}
			}
			
		});
		
		List<Interval> results = new ArrayList<Interval>();
		Interval tmp = intervals.get(0);
		for(int i=1; i<intervals.size(); i++) {
			Interval cur = intervals.get(i);
			
			if(cur.start <= tmp.end) {
				tmp.end = Math.max(tmp.end, cur.end);
			} else {
				results.add(tmp);
				tmp = cur;
			}
		}
		results.add(tmp);
		
		return results;
	}

	static class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
		
		public String toString() { return "[" + start + ", " + end + "]"; }
	}
}
