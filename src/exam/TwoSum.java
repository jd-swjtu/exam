package exam;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	public static void main(String[] args) {
		int[] x = (new TwoSum()).twoSum(new int[]{1,2,2,3,5,7,9}, 7);
		System.out.println(x[0] + ":" + x[1]);
	}

	public int[] twoSum(int[] nums, int target) {
		Map<Integer,Integer> mapping = new HashMap<Integer,Integer>();
        for(int i=0; i<nums.length; i++) {
        	mapping.put(nums[i], i);
        }
        
        for(int i=0; i<nums.length; i++) {
        	int v = target - nums[i];
        	
        	if(mapping.keySet().contains(v)) {
        		return new int[]{i, mapping.get(v)};
        	}
        }
        return new int[]{0,0};
    }
}
