package exam;

public class Resolution35 {

	public static void main(String[] args) {
		System.out.println(new Resolution35().searchInsert(new int[]{1,  2, 4, 5,7}, 8));

		//System.out.println(new Resolution35().search(new int[]{1,  2, 4, 5,7}, 5));
		int[] v = new Resolution35().searchRange(new int[]{2,2}, 2);
		System.out.println("[" + v[0] + "," + v[1] + "]");
	}

	public int searchInsert(int[] nums, int target) {
		int len = nums.length;

		return searchInsert(nums, target, 0, len);
	}

	private int searchInsert(int[] nums, int target, int s, int e) {
		int mid = s + (e-s)/2;
		if(nums[mid] == target) return mid;

		if(target < nums[mid]) {
			if(mid == s) {
				return s;
			}
			return searchInsert(nums, target, s, mid);
		} else {
			if(mid >= e-1) return e;
			return searchInsert(nums, target, mid+1, e);
		}
	}

	public int[] searchRange(int[] nums, int target) {
		int s = this.search(nums, target, 0, nums.length);
		if(s == -1) {
			return new int[]{-1, -1};
		}
		int i = s+1;
		for(;i<nums.length;) {
			if(nums[i] != target) break;
			i++;
		}
		return new int[]{s, i-s-1};
	}


	public int search(int[] nums, int target, int s, int e) {
		if(s == e) return -1;
		
		int mid = s + (e-s)/2;
		if(nums[mid] == target) return mid;

		

		if(target < nums[mid]) {
			return search(nums, target, s, mid);
		} else {
			return search(nums, target, mid+1, e);
		}
	}
}
