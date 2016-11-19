package exams.ll;

public class N53 {

	public static void main(String[] args) {
		System.out.println(new N53().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));

	}
/**
  Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6. 
 * @param nums
 * @return
 */
public int maxSubArray(int[] nums) {
        int ls = nums[0];
        int gs = nums[0];
        
        for(int i=1; i<nums.length; i++) {
        	ls = Math.max(ls+nums[i], nums[i]);
        	gs = Math.max(gs, ls);
        }
        
        return gs;
    }
}
