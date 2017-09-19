package exams.n0;

public class N12 {

	public static void main(String[] args) {

		System.out.println(new N12().intToRoman(123));
	}
	
	public String intToRoman(int value) {
		int[] vv = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		String[] pp = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
		
		StringBuilder sbf = new StringBuilder();
		int s = 0;
		while(value > 0) {
			if(value >= vv[s]) {
					sbf.append(pp[s]);
					value -= vv[s];
			} else {
				s++;
			}
		}
		return sbf.toString();
	}
}
