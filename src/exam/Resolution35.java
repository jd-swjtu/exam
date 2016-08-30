package exam;

public class Resolution35 {

	public static void main(String[] args) {
		System.out.println(new Resolution35().searchInsert(new int[]{1,2,3,4,5,6,7}, 1));

		//System.out.println(new Resolution35().search(new int[]{0,1,2,3,4,5,6}, 6, 0, 6));
		
		//int[] v = new Resolution35().searchRange(new int[]{1,2,2,4,5}, 2);
		//System.out.println("[" + v[0] + "," + v[1] + "]");
		/*System.out.println(new Resolution35().searchRound(new int[]{3,1}, 1, 0, 1));
		int[] a = new int[]{3,1};
		for(int i=0; i<a.length; i++) {
			System.out.println(new Resolution35().searchRound(a, a[i], 0, a.length - 1));
		}*/
		
		//System.out.println(new Resolution35().searchRound(a, 1, 0, 4));
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
		if(s == e) return -1;
		
		if(nums[s] < nums[mid]) {
			if(target >= nums[s] && target <=  nums[mid]) {
				return searchRound(nums, target, s, mid);
			} else {
				return searchRound(nums, target, mid+1, e);
			}
		} else {
			if(target > nums[mid] && target <= nums[e]) {
				return searchRound(nums, target, mid+1, e);
			} else {
				return searchRound(nums, target, s, mid);
			}
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
}
