package exam;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Resolution35 {

	public static void main(String[] args) {
		//System.out.println(new Resolution35().searchInsert(new int[]{1,2,3,4,5,6,7}, 1));

		//System.out.println(new Resolution35().search(new int[]{0,1,2,3,4,5,6}, 6, 0, 6));

		//int[] v = new Resolution35().searchRange(new int[]{1,2,2,4,5}, 2);
		//System.out.println("[" + v[0] + "," + v[1] + "]");
		//System.out.println(new Resolution35().searchRound(new int[]{3,1}, 1, 0, 1));
		int[] a = new int[]{1,3,1,1,1,1};
		for(int i=0; i<a.length; i++) {
			System.out.println(new Resolution35().searchRound(a, a[i], 0, a.length - 1));
		}

		//System.out.println(new Resolution35().searchRound(a, 1, 0, 4));

//		System.out.println(new Resolution35().countAndSay(0));
//
//
//
//		char[][] grid = {
//				{'1', '1', '0', '0', '0'},
//				{'1', '1', '0', '0', '0'},
//				{'1', '1', '0', '0', '0'},
//				{'0', '0', '1', '0', '0'},
//				{'0', '0', '0', '1', '1'}
//		};
//		System.out.println(new Resolution35().numIslands(grid));
//		
//		System.out.println(new Resolution35().combinationSum(new int[]{2,3,5}, 7));
//		System.out.println(new Resolution35().combinationSum(new int[]{6,8,12,5,9,3,4,11}, 31));
	}

	@LeetCode(35)
	public int searchInsert(int[] nums, int target) {
		int len = nums.length;

		return searchInsert(nums, target, 0, len);
	}

	private int searchInsert(int[] nums, int target, int s, int e) {
		if(s>e) return s;
		int mid = s + (e-s)/2;
		if(nums[mid] == target) return mid;

		if(target < nums[mid]) {
			return searchInsert(nums, target, s, mid-1);
		} else {
			return searchInsert(nums, target, mid+1, e);
		}
	}

	//#34
	@LeetCode(34)
	public int[] searchRange(int[] nums, int target) {
		int s = this.search(nums, target, 0, nums.length-1);
		if(s == -1) {
			return new int[]{-1, -1};
		}
		int i = s+1;
		for(;i<nums.length;) {
			if(nums[i] != target) break;
			i++;
		}
		int e = i-1;
		i = s -1;
		for(;i>=0;) {
			if(nums[i] != target) break;
			i--;;
		}

		return new int[]{i+1, e};
	}

	public int search(int[] nums, int target, int s, int e) {
		if(s > e) return -1;

		int mid = s + (e-s)/2;
		if(nums[mid] == target) return mid;

		if(target < nums[mid]) {
			return search(nums, target, s, mid - 1);
		} else {
			return search(nums, target, mid+1, e);
		}
	}

	public int searchRound(int[] nums, int target, int s, int e) {
		if(s > e) return -1;

		int mid = s + (e-s)/2;
		if(nums[mid] == target) return mid;
		
		if(nums[s] <= nums[mid]) {
			if(target >= nums[s] && target <  nums[mid]) {
				return searchRound(nums, target, s, mid-1);
			} else {
				return searchRound(nums, target, mid+1, e);
			}
		} else {
			if(target > nums[mid] && target <= nums[e]) {
				return searchRound(nums, target, mid+1, e);
			} else {
				return searchRound(nums, target, s, mid-1);
			}
		}
	}
	
	public int searchRoundRep(int[] nums, int target, int s, int e) {
		if(s > e) return -1;

		int mid = s + (e-s)/2;
		if(nums[mid] == target) return mid;
		
		if(nums[s] < nums[mid]) {
			if(target >= nums[s] && target <  nums[mid]) {
				return searchRound(nums, target, s, mid-1);
			} else {
				return searchRound(nums, target, mid+1, e);
			}
		} else if (nums[s] > nums[mid]){
			if(target > nums[mid] && target <= nums[e]) {
				return searchRound(nums, target, mid+1, e);
			} else {
				return searchRound(nums, target, s, mid-1);
			}
		} else {
			int r = searchRound(nums, target, mid+1, e);
			if(r == -1)
				return searchRound(nums, target, s, mid-1);
			return r;
		}
	}


	public int searchx(int[] A, int target) {
		if (A == null || A.length == 0) {
			return -1;
		}

		int start = 0;
		int end = A.length - 1;
		int mid;

		while (start + 1 < end) {
			mid = start + (end - start) / 2;
			if (A[mid] == target) {
				return mid;
			}
			if (A[start] < A[mid]) {
				// situation 1, red line
				if (A[start] <= target && target <= A[mid]) {
					end = mid;
				} else {
					start = mid;
				}
			} else {
				// situation 2, green line
				if (A[mid] <= target && target <= A[end]) {
					start = mid;
				} else {
					end = mid;
				}
			}
		} // while

		if (A[start] == target) {
			return start;
		}
		if (A[end] == target) {
			return end;
		}
		return -1;
	}

	@LeetCode(38)
	public String countAndSay(int n) {
		if(n==0) return "";
		String s = "1";

		while( n > 1) {
			s = sayIt(s);
			n--;
		}

		return s;
	}

	private String sayIt(String n) {
		StringBuffer sbf = new StringBuffer();

		char cc = n.charAt(0);
		int count = 1;
		for(int i=1; i<n.length(); i++) {
			char c = n.charAt(i);

			if(c == cc) {
				count++;
			} else {
				sbf.append(String.valueOf(count)).append(cc);

				cc = c;
				count = 1;
			}
		}
		sbf.append(String.valueOf(count)).append(cc);
		return sbf.toString();
	}

	@LeetCode(200)
	public int numIslands(char[][] grid) {
		int rows = grid.length;
		if(rows == 0) return 0;
		int cols = grid[0].length;

		int count = 0;
		int max = 0;
		for(int i=0; i<rows; i++)
			for(int j=0; j<cols; j++) {
				char c = grid[i][j];
				if(c == '1') {
					count++;

					int w = search(grid, rows, cols, i, j, 0);
					if(w > max) max = w;
					System.out.println("Island " + count + ": " + w);
				}
			}

		System.out.println("Max Island:" + max);
		return count;
	}

	private int search(char[][] grid, int r, int c, int x, int y, int w) {
		if(x<0 || y <0 || x >= r || y >= c) return w;

		char cc = grid[x][y];
		if(cc == '1') {
			grid[x][y] = '0';
			w += 1;

			w = search(grid, r, c, x-1, y, w);
			w = search(grid, r, c, x+1, y, w);
			w = search(grid, r, c, x, y+1, w);
			w = search(grid, r, c, x, y-1, w);
		}
		return w;
	}
	
	@LeetCode(39)
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> results  = new ArrayList<List<Integer>>();
		
		Arrays.sort(candidates);
		Deque<Integer> value = new ArrayDeque<Integer>();
		solve(candidates, target, value, results, 0);

		return results;
	}

	private void solve(int[] candidates, int target, Deque<Integer> value, List<List<Integer>> results, int start) {
		if(target == 0 ) {
			List<Integer> vv = new ArrayList<Integer>();
			vv.addAll(value);
			results.add(vv);
			return;
		}
		
		for(int k=start; k<candidates.length; k++) {
			//if(k>start && candidates[k]==candidates[k-1]) continue;
			
			int c = candidates[k];
			if(c <= target) {
				int x = target - c;
				
				value.addLast(c);
				solve(candidates, x, value, results, k);
				value.removeLast();
			}
		}
	}
}
