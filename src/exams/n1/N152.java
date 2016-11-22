package exams.n1;

public class N152 {

	public static void main(String[] args) {
		System.out.println(new N152().maxProduct(new int[]{2, 3, -2, 4, 0,2, 12}));
	}

	/*
	 * 
	 *  Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.

Subscribe to see which companies asked this question

	 */

	public int maxProduct(int[] nums) {
	    int max = nums[0];
	    int min = nums[0];
	    
	    int result = nums[0];
	 
	    for(int i=1; i<nums.length; i++){
	    	int curMax, curMin;
	        if(nums[i]>0){
	            curMax=Math.max(nums[i], max*nums[i]);
	            curMin=Math.min(nums[i], min*nums[i]);
	        }else{
	            curMax=Math.max(nums[i], min*nums[i]);
	            curMin=Math.min(nums[i], max*nums[i]);
	        }
	 
	        max = curMax;
	        min = curMin;
	        result = Math.max(result, max);
	    }
	 
	    return result;
	}
}
