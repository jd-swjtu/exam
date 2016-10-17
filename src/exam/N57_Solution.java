package exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

import exam.Utils.Pair;

public class N57_Solution {

	public static void main(String[] args) {
		List<Interval> old = new ArrayList<Interval>();
		old.add(new Interval(1, 2));
		old.add(new Interval(3, 5));
		old.add(new Interval(5, 7));
		old.add(new Interval(4, 13));
		old.add(new Interval(12, 16));
		System.out.println(merge(old));
		
		int arr[] = {900, 940, 950, 1100, 1500, 1800};
	    int dep[] = {910, 1200, 1120, 1130, 1900, 2000};
	    System.out.println(maxPlatforms(arr, dep));
		//System.out.println(insert2(old, new Interval(4, 9)));
	}

	public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		ListIterator<Interval> it = intervals.listIterator();
		while(it.hasNext()) {
			Interval ii = it.next();
			
			if(ii.end < newInterval.start) {
			} else if(newInterval.end < ii.start) {
				it.previous();
				it.add(newInterval);
				
				return intervals;
			} else {
				ii.start = Math.min(ii.start, newInterval.start);
				ii.end = Math.max(ii.end, newInterval.end);
				
				it.remove();

				newInterval = ii;
			}
		}
		it.add(newInterval);
		return intervals;
	}
	
	public static List<Interval> merge(List<Interval> intervals) {
		List<Interval> results = new ArrayList<Interval>();
		
		Collections.sort(intervals, new Comparator<Interval>(){

			@Override
			public int compare(Interval o1, Interval o2) {
				if(o1.start != o2.start) {
					return o1.start - o2.start;
				} else {
					return o1.end - o2.end;
				}
			}});
		Interval tmp = intervals.get(0);
		for( int i=0; i<intervals.size(); i++) {
			Interval ii = intervals.get(i);
			
			if(ii.start <= tmp.end) {
				tmp.end = Math.max(tmp.end, ii.end);
			} else {
				results.add(tmp);
				tmp = ii;
			}
		}
		results.add(tmp);
		
		return results;
	}
	
	public static List<Interval> insert2(List<Interval> intervals, Interval newInterval) {
		List<Interval> results = new ArrayList<Interval>();

		for( int i=0; i<intervals.size(); i++) {
			Interval ii = intervals.get(i);
			if(ii.end < newInterval.start) {
				results.add(ii);
			} else if(newInterval.end < ii.start) {
				results.add(newInterval);

				/*for(int j=i; j<intervals.size(); j++) {
					results.add(intervals.get(j));
				}
				return results;*/
				newInterval = ii;
			} else {
				newInterval.start = Math.min(ii.start, newInterval.start);
				newInterval.end = Math.max(ii.end, newInterval.end);
				//newInterval = ii;
			}
		}
		results.add(newInterval);

		return results;
	}
	
	public static int maxPlatforms(int[] arr, int[] dep) {
		List<Pair<Integer,Integer>> vals = new ArrayList<Pair<Integer,Integer>>();
		for(int i=0; i<arr.length; i++) {
			vals.add(new Pair<Integer,Integer>(arr[i], 1));
		}
		for(int i=0; i<dep.length; i++) {
			vals.add(new Pair<Integer,Integer>(dep[i], -1));
		}
		
		Collections.sort(vals, new Comparator<Pair<Integer,Integer>>(){
			@Override
			public int compare(Pair<Integer,Integer> o1, Pair<Integer,Integer> o2) {
					return o1.t1 - o2.t1;
			}});
		
		int max = 0;
		int v = 0;
		for(int i=0; i<vals.size(); i++) {
			v += vals.get(i).t2;
			
			if(v>max) max = v;
		}
		
		return max;
	}
}


class Interval {
	int start;
	int end;

	Interval() { start = 0; end = 0; }
	Interval(int s, int e) { start = s; end = e; }

	public String toString() {
		return "[" + start + ", " + end + "]";
	}
}