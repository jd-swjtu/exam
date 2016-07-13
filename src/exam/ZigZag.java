package exam;

public class ZigZag {

	public static void main(String[] args) {
		System.out.println(new ZigZag().convert("0123456789abcdefg", 5));
	}

	public String convert(String s, int numRows) {
		int n = 2 * numRows - 2;
		int len = s.length();
		StringBuffer sbf = new StringBuffer();
		for(int i=0; i<numRows; i++) {
			for(int j=i; j<len; j+=n) {
				sbf.append(s.charAt(j));

				if(i != 0  && i != numRows - 1)
					if(j+n-i-i < len)
						sbf.append(s.charAt(j + n - i-i));
			}
		}

		return sbf.toString();
	}
}
