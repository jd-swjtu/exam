package exams.aa;

import java.util.HashMap;
import java.util.Map;

public class N1 {

	public static void main(String[] args) {
		N1 n1 = new N1();
		int[] ret = n1.twoSum(new int[]{1, 3,4,5,7,2,4,6}, 10);
		System.out.println(ret[0] + " : " + ret[1]);

	}

	public int[] twoSum(int[] nums, int target) {
		if(nums.length < 2) return new int[]{0,0};

		Map<Integer,Integer> numsMap = new HashMap<Integer,Integer>();
		int i=0;
		for(int num: nums) {
			numsMap.put(num, i++);
		}

		i=0;
		for(int num: nums) {
			int anum = target - num;
			if(numsMap.containsKey(anum)) {
				return new int[]{i, numsMap.get(anum)};
			}
			i++;
		}

		return new int[]{0,0};
	}

}
