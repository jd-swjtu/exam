package exams.n0;

public class N07 {

	public static void main(String[] args) {
		System.out.println(new N07().reverse(-1234));
		System.out.println(new N07().isPalindromic(121));
	}

	public int reverse(int x) {
		if(x == Integer.MIN_VALUE) return 0;
		
		int v = 0;
		int sign = 1;
		if(x < 0) {
			x = -1 * x;
			sign = -1;
		}
		while(x > 0) {
			v = v * 10 + x%10;
			x = x/10;
		}
		return v *sign;
	}
	
	public boolean isPalindromic(int x) {
		return x == reverse(x);
	}
}
