package exams.n2;

public class N238 {

	public static void main(String[] args) {
		int[] nums = new int[]{1,2,3,4};
		
		int[] results = new N238().productExceptSelf(nums);
		for(int i=0; i<results.length; i++) {
			System.out.print(results[i] + ", ");
		}
		System.out.println();
	}
	
	public int[] productExceptSelf(int[] nums) {
		int len = nums.length;
		if(len == 0) return new int[0];
		
		int[] results = new int[len];
		
		results[0] = 1;
		for(int i=1; i<len; i++) {
			results[i] = results[i-1] * nums[i-1];
		}
		
		int base = 1;
		for(int i=len-1; i>=0; i--) {
			results[i] = results[i] * base;
			
			base = base * nums[i];
		}
		
		return results;
	}
	
	
}
