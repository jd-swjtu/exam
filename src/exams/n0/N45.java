package exams.n0;

/*
 Jump Game II
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]
The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

Note:
You can assume that you can always reach the last index.
 */
public class N45 {

	public static void main(String[] args) {
		System.out.println(new N45().jump(new int[]{2,3,1,1,4}));
	}

	public int jump(int[] nums) {
		int curr = 0;
		int last = 0;
		int ret = 0;
		for (int i = 0; i < nums.length; ++i) {
	        if (i > last) {
	            last = curr;
	            ++ret;
	        }
	        curr = Math.max(curr, i+nums[i]);
	    }
	
	    return ret;
	}
    
	public int jump1(int[] nums) {
		int jumps = 0, curEnd = 0, curFarthest = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			curFarthest = Math.max(curFarthest, i + nums[i]);
			if (i == curEnd) {
				jumps++;
				curEnd = curFarthest;
			}
		}
		return jumps; 
    }
}
