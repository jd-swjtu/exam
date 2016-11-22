package exams.n2;

import java.util.LinkedList;

public class N239 {

	public static void main(String[] args) {
		int[] results = new N239().maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);
		for(int i=0; i<results.length; i++) {
			System.out.print(results[i] + ",");
		}
		System.out.println();
	}

	public int[] maxSlidingWindow(int[] nums, int k) {
		int len = nums.length;
		if(len < k) return new int[0];

		LinkedList<Integer> q = new LinkedList<Integer>();
		int[] result = new int[len-k+1];
		for(int i=0; i<k-1; i++) {
			enter(q, (nums[i]));
		}

		for(int i=k-1; i<len; i++) {
			enter(q, nums[i]);
			result[i-k + 1] = q.peekFirst();

			exit(q, nums[i-k + 1]);
		}

		return result;
	}

	private void enter(LinkedList<Integer> q, int v) {
		while(!q.isEmpty()) {
			int vv = q.peekLast();

			if(vv<v) {
				q.removeLast();
			} else {
				break;
			}
		}
		q.addLast(v);
	}

	private void exit(LinkedList<Integer> q, int v) {
		if(!q.isEmpty()) {
			int vv = q.peekFirst();

			if(vv == v) q.removeFirst();
		}
	}
}
