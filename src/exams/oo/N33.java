package exams.oo;

public class N33 {

	public static void main(String[] args) {
		int[] a = new int[]{4, 5, 6, 7, 0, 1, 2};
		//for(int i=0; i<a.length; i++)
		//	System.out.println(new N33().search(a, a[i]));

		System.out.println(new N33().search(a, 9));

		System.out.println(new N33().search(new int[]{1,0}, 0));
	}

	public int search(int[] nums, int target) {
		int s = 0;
		int e = nums.length-1;

		while(s <= e) {
			int m = (s+e)/2;

			if(nums[m] == target) return m;

			if(nums[s] <= nums[m]) {
				if(target >= nums[s] && target < nums[m]) {
					e = m - 1;
				} else {
					s = m + 1;
				}
			} else {
				if(target > nums[m] && target <= nums[e]) {
					s = m + 1;
				} else {
					e = m - 1;
				}
			}
		}
		return -1;
	}

	public int search2(int[] nums, int target) {
		return searchRound(nums, target, 0, nums.length - 1);
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
}
