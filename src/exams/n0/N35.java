package exams.n0;

/*
Search Insert Position

Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
 */
public class N35 {

	public static void main(String[] args) {
		System.out.println(new N35().searchInsert(new int[]{1,2,5,6}, 5));
		System.out.println(new N35().searchInsert(new int[]{1,3,5,6}, 2));
		System.out.println(new N35().searchInsert(new int[]{1,2,5,6}, 7));
		System.out.println(new N35().searchInsert(new int[]{1,2,5,6}, 0));
	}

	public int searchInsert(int[] nums, int target) {
		int s = 0;
		int e = nums.length - 1;
		while(s<=e) {
			int m = (s+e)/2;
			if(nums[m] == target) return m;
			if(nums[m] > target) {
				e = m - 1;
			} else {
				s = m + 1;
			}
		}
		return s;
    }
}
