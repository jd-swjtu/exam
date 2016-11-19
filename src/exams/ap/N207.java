package exams.ap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class N207 {

	public static void main(String[] args) {
		System.out.println(new N207().canFinish(2, new int[][]{{1,0}}));
	}

	/*
	 * 
	 *  There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

For example:

2, [[1,0]]

There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

2, [[1,0],[0,1]]

There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
	 */
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		if(prerequisites == null){
			throw new IllegalArgumentException("illegal prerequisites array");
		}

		int len = prerequisites.length;

		if(numCourses == 0 || len == 0){
			return true;
		}

		// counter for number of prerequisites
		int[] pCounter = new int[numCourses];
		for(int i=0; i<len; i++){
			pCounter[prerequisites[i][0]]++;
		}

		//store courses that have no prerequisites
		LinkedList<Integer> queue = new LinkedList<Integer>();
		for(int i=0; i<numCourses; i++){
			if(pCounter[i]==0){
				queue.add(i);
			}
		}

		// number of courses that have no prerequisites
		int numNoPre = queue.size();

		while(!queue.isEmpty()){
			int top = queue.remove();
			for(int i=0; i<len; i++){
				// if a course's prerequisite can be satisfied by a course in queue
				if(prerequisites[i][1]==top){
					pCounter[prerequisites[i][0]]--;
					if(pCounter[prerequisites[i][0]]==0){
						numNoPre++;
						queue.add(prerequisites[i][0]);
					}
				}
			}
		}

		return numNoPre == numCourses;
	}

	public boolean canFinishX(int numCourses, int[][] prerequisites) {
		if(prerequisites == null){
			throw new IllegalArgumentException("illegal prerequisites array");
		}

		int len = prerequisites.length;

		if(numCourses == 0 || len == 0){
			return true;
		}

		//track visited courses
		int[] visit = new int[numCourses];

		// use the map to store what courses depend on a course 
		HashMap<Integer,ArrayList<Integer>> map = new HashMap<Integer,ArrayList<Integer>>();
		for(int[] a: prerequisites){
			if(map.containsKey(a[1])){
				map.get(a[1]).add(a[0]);
			}else{
				ArrayList<Integer> l = new ArrayList<Integer>();
				l.add(a[0]);
				map.put(a[1], l);
			}
		}

		for(int i=0; i<numCourses; i++){
			if(!canFinishDFS(map, visit, i))
				return false;
		}

		return true;
	}

	private boolean canFinishDFS(HashMap<Integer,ArrayList<Integer>> map, int[] visit, int i){
		if(visit[i]==-1) 
			return false;
		if(visit[i]==1) 
			return true;

		visit[i]=-1;
		if(map.containsKey(i)){
			for(int j: map.get(i)){
				if(!canFinishDFS(map, visit, j)) 
					return false;
			}
		}

		visit[i]=1;

		return true;
	}

	public boolean canFinish4(int numCourses, int[][] prerequisites) {
		Map<Integer,Set<Integer>> mapping = new HashMap<Integer,Set<Integer>>();

		int len = prerequisites.length;
		for(int i=0; i<len; i++) {
			int[] preq = prerequisites[i];
			if(preq[0] <0 || preq[0] >= numCourses) continue;
			if(preq[1] <0 || preq[1] >= numCourses) continue;

			if(!mapping.containsKey(preq[0])) {
				mapping.put(preq[0], new HashSet<Integer>());
			}
			mapping.get(preq[0]).add(preq[1]);
		}

		Queue<Integer> solved = new LinkedList<Integer>();
		for(int i=0; i<numCourses; i++) {
			if(!mapping.containsKey(i)) {
				solved.add(i);
			}
		}

		while(!solved.isEmpty()) {
			int cur = solved.poll();
			Iterator<Integer> it = mapping.keySet().iterator();
			while(it.hasNext()) {
				Integer next = it.next();
				Set<Integer> deps = mapping.get(next);
				deps.remove(cur);

				if(deps.isEmpty()) {
					solved.add(next);
					it.remove();
				}
			}
		}
		return mapping.isEmpty();
	}

	public boolean canFinish3(int numCourses, int[][] prerequisites) {
		Map<Integer,List<Integer>> mapping = new HashMap<Integer,List<Integer>>();

		int len = prerequisites.length;
		for(int i=0; i<len; i++) {
			int[] preq = prerequisites[i];
			if(preq[0] <0 || preq[0] >= numCourses) continue;
			if(preq[1] <0 || preq[1] >= numCourses) continue;

			if(!mapping.containsKey(preq[0])) {
				mapping.put(preq[0], new ArrayList<Integer>());
			}
			mapping.get(preq[0]).add(preq[1]);
		}

		int finished = 0;
		boolean[] flag = new boolean[numCourses];
		for(int i=0; i<numCourses; i++) {
			if(!mapping.containsKey(i)) {
				flag[i] = true;
				finished++;
			}
		}

		while(finished < numCourses) {
			int newFinished = 0;
			for(int i=0; i<numCourses; i++) {
				if(flag[i]) continue;
				if(mapping.containsKey(i)) {
					boolean f = true;
					for(Integer j: mapping.get(i)) {
						if(!flag[j]) {
							f=false;
							break;
						}
					}
					if(f) {
						flag[i] = true;
						newFinished++;
					}
				}
			}
			finished += newFinished;
			if(newFinished == 0) return false;
		}
		return true;
	}

	public boolean canFinish2(int numCourses, int[][] prerequisites) {
		Map<Integer,List<Integer>> mapping = new HashMap<Integer,List<Integer>>();

		int len = prerequisites.length;
		for(int i=0; i<len; i++) {
			int[] preq = prerequisites[i];
			if(preq[0] <0 || preq[0] >= numCourses) continue;
			if(preq[1] <0 || preq[1] >= numCourses) continue;

			if(!mapping.containsKey(preq[0])) {
				mapping.put(preq[0], new ArrayList<Integer>());
			}
			mapping.get(preq[0]).add(preq[1]);
		}

		boolean[] flag = new boolean[numCourses];
		Stack<Integer> q = new Stack<Integer>();
		for(int i=0; i<numCourses; i++) {

			if(!mapping.containsKey(i)) {
				flag[i] = true;
				continue;
			}


			boolean[] visited = new boolean[numCourses];
			q.push(i);
			visited[i] = true;
			while(!q.isEmpty()) {
				int k = q.peek();
				if(flag[k]) q.pop();

				if(!mapping.containsKey(k)) {
					flag[k] = true;
					q.pop();
				} else {
					for(int j: mapping.get(k)) {
						if(flag[j]) continue;
						if(visited[j]) return false;
						visited[j] = true;
						q.push(j);
					}
				}
			}
		}

		return true;
	}

}
