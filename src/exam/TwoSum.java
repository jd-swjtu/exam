package exam;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	public static void main(String[] args) {
		int[] x = (new TwoSum()).twoSum(new int[]{1,2,2,3,5,7,9}, 7);
		System.out.println(x[0] + ":" + x[1]);

		/*System.out.println(new TwoSum().atoi("0"));
		System.out.println(new TwoSum().atoi("23xx11"));
		System.out.println(new TwoSum().atoi("+123"));
		System.out.println(new TwoSum().atoi("-123xx"));
		System.out.println(new TwoSum().atoi("-2147483648"));
		System.out.println(new TwoSum().atoi("2147483648"));*/

		System.out.println(new TwoSum().atoi("9223372036854775809"));
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

	public int atoi(String s) {
		if (s == null || "".equals(s)) return 0;

		s = s.trim();
		int sign = 1;
		if(s.charAt(0) == '-') {
			sign = -1;
			s = s.substring(1);
		} else if(s.charAt(0) == '+') {
			s = s.substring(1);
		}

		long v = 0;
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);

			if(c >= '0' && c <= '9') {
				v = v*10 + c - '0';
			} else {
				break;
			}

			if(sign == 1 && v > Integer.MAX_VALUE) return Integer.MAX_VALUE;
			if(sign == -1 && (-1 * v) < Integer.MIN_VALUE) return Integer.MIN_VALUE;
		}

		return (int)(v*sign);
	}
}
