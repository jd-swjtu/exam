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
		
		int[] a = new int[]{ 1, 12, 34, 56, 23, 12};//7, 2, 5, 3, 2, 1}; //{5,4,3,2,1};// {1,2,3,4,5}; //
		new TwoSum().nextPermutation(a);
		for(int i=0; i<a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println();
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
	
	
	//#31 - 7 2 5 3 2 1
	public void nextPermutation(int[] nums) {
		boolean found = false;
		int v = 0;
		int i;
		for(i = nums.length - 1; i >0; i--) {
			if(nums[i] > nums[i-1]) {
				found = true;
				v = nums[i-1];
				break;
			}
		}
		
		if(found) {
			int j = 0;
			int vv = Integer.MAX_VALUE;
			for(int k = nums.length - 1; k >= i; k--) {
				if(nums[k] > v) {
					if(nums[k] <= vv) {
						vv = nums[k];
						j = k;
					}
				}
			}
			vv = nums[j];
			nums[j] = nums[i-1];
			nums[i-1] = vv;
		}
		//sort 
		for(int j=i; j<nums.length - 1; j++) {
			int vv = nums[j];
			int l = 0;
			for(int k = j+1; k<nums.length ; k++) {
				if(nums[k] < vv) {
					vv = nums[k];
					l = k;
				}
			}
			if(l != 0) {
				vv = nums[j];
				nums[j] = nums[l];
				nums[l] = vv;
			}
		}
	}
}
