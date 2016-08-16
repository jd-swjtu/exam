package exam;

import java.util.ArrayList;
import java.util.List;

public class ZigZag {

	public static void main(String[] args) {
		System.out.println(new ZigZag().convert("Ajjjjjjjjjjjjjjjhhhhhhhhhhhhhhhhggggggcycyctcuyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyydddd"
				+ "dddduuuuuuuuuuuuuuuuuuuuuuuuuuggggggggggggggggggggggggggddddddddddddddeeeeeeeeeeeee", 4));
		System.out.println(new ZigZag().convert("", 1));
		
		System.out.println(new ZigZag().reverse(0));
		
		for(String s: new ZigZag().letterCombinations("234")) {
			System.out.println(s);
		}
		
		new ZigZag().removeElement(new int[]{3, 2,2,3}, 3);
	}

	public String convert(String s, int numRows) {
		if(numRows < 1) return "";
		if(numRows == 1) return s;
		
		int n = 2 * numRows - 2;
		int len = s.length();
		StringBuffer sbf = new StringBuffer();
		for(int i=0; i<numRows; i++) {
			for(int j=i; j<len; j+=n) {
				sbf.append(s.charAt(j));

				if(i != 0  && i != numRows - 1) {
					int loc = j/n*n + (n-i);
					if(loc < len)
						sbf.append(s.charAt(loc));
				}
			}
		}

		return sbf.toString();
	}
	
	public int reverse(int x) {
		long y = 0;
		int sign = (x>0)?1:(-1);
		x = x * sign;
		
		while(x > 0) {
			y = y * 10 + x%10;
			x = x/10;
		}

		if(y<0) return 0;
		if(y>Integer.MAX_VALUE) return 0;
		return (int)y*sign;
	}
	
	public List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<String>();
		String[] dict = new String[]{"+", " ", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		
		if(digits == null || digits.equals("")) return result;
		generateString(result, dict, digits, "", 0);
		return result;
    }
    
    public void generateString(List<String> result, String[] dict, String numbers, String s, int idx) {
		if(idx == numbers.length()) {
			result.add(s);
			return;
		}
		int num = numbers.charAt(idx) - '0';
		for(int i=0; i<dict[num].length(); i++) {
			generateString(result, dict, numbers, s + dict[num].charAt(i), idx+1);
		}
	}
    
    //#27
//    public int removeElement1(int[] nums, int val) {
//    	int len = nums.length;
//        if(len == 0) return 0;
//        
//      int i=0, j=len - 1;
//        while(true) {
//        	while(j>=0 && val == nums[j]) j--;
//        	if(j<0) return 0;
//        	
//        	while(i<j && val != nums[i]) i++;
//        	
//        	if(i<j) {
//        	nums[i] = nums[j];
//        	} else {
//        	    return j;
//        	}
//        }
//     }
    
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int loc = 0;
        for(int i=0; i<len; i++) {
            if(val != nums[i]) {
                nums[loc++] = nums[i];
            }
        }
        return loc;
     }
}
