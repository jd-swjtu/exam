package exam;

public class RomanNumber {



	public static void main(String[] args) {
		RomanNumber rn = new RomanNumber();
		System.out.println(rn.intToRoman(3999));
		System.out.println(rn.romanToInt(rn.intToRoman(3999)));
	}
	
	public int romanToInt(String s) {
		int[] vv = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		String[] pp = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
		
		int v = 0;
		int i = 0;
		while(s.length() > 0 && i<pp.length) {
			String ss = pp[i];
			if(s.startsWith(ss)) {
				v += vv[i];
				
				s = s.substring(ss.length());
			} else {
				i++;
			}
		}
		
		return v;
    }

	public String intToRoman(int num) {
		if(num > 3999) return "";

		StringBuffer sb = new StringBuffer();
		int[] vv = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		String[] pp = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
		int i = 0;
		while(num > 0) {
			if(num >= vv[i]) {
				sb.append(pp[i]);

				num -= vv[i];
			} else {
				i++;
			}
		}

		return sb.toString();
	}
}
