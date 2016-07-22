package exam;

public class ZigZag {

	public static void main(String[] args) {
		System.out.println(new ZigZag().convert("Ajjjjjjjjjjjjjjjhhhhhhhhhhhhhhhhggggggcycyctcuyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyydddd"
				+ "dddduuuuuuuuuuuuuuuuuuuuuuuuuuggggggggggggggggggggggggggddddddddddddddeeeeeeeeeeeee", 1));
		System.out.println(new ZigZag().convert("", 1));
		
		System.out.println(new ZigZag().reverse(0));
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
}
