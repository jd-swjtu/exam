package exam;

public class ZigZag {

	public static void main(String[] args) {
		System.out.println(new ZigZag().convert("Ajjjjjjjjjjjjjjjhhhhhhhhhhhhhhhhggggggcycyctcuyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyydddd"
				+ "dddduuuuuuuuuuuuuuuuuuuuuuuuuuggggggggggggggggggggggggggddddddddddddddeeeeeeeeeeeee", 1));
		System.out.println(new ZigZag().convert("", 1));
		
		System.out.println(new ZigZag().reverse(0));
		
		System.out.println("######");
		int[] nums = new int[]{1,2,3};
		for(int i=0; i<new ZigZag().removeDuplicates(nums); i++) {
			System.out.println(nums[i]);
		}
		
		System.out.println("######");
		System.out.println(new ZigZag().isMatch("abcdd", "a.*d"));
		System.out.println(new ZigZag().isMatch("aab", "c*a*b"));
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
	
	//#26
	public int removeDuplicates(int[] nums) {
       int len = nums.length;
       if(len < 2) return len;
       
       int k=1;
       for(int i=1; i<len; i++) {
    	   if(nums[i] - nums[i-1] != 0) {
    		   nums[k++] = nums[i];
    	   }
       }
       return k;
    }
	
	//#10
	public boolean isMatch(String s, String p) {
        if(p == null || p.length() == 0) {
        	if(s == null || s.length() == 0) return true;
        	return false;
        }
        
        if(p.length() < 2) {
        	if(s == null || s.length() == 0) return false;
        	if(p.charAt(0) == s.charAt(0) || p.charAt(0) == '.') {
        		if(s.length() == 1) return true;
        		return false;
        	}
        	return false;
        }
        
        if(p.charAt(1) != '*') {
        	if(p.charAt(0) == s.charAt(0) || p.charAt(0) == '.') {
        		return isMatch(s.substring(1), p.substring(1));
        	}
        	return false;
        }
        
        int start = 0;
        while(p.charAt(0) == s.charAt(0) || p.charAt(0) == '.') {
        	boolean r = isMatch(s, p.substring(2));
    		while(!r && start < s.length()) {
    			start++;
    			r = isMatch(s.substring(start), p.substring(2));
    		}
    		return r;
    	}
        return isMatch(s, p.substring(2));
    }
}
