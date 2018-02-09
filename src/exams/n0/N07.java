package exams.n0;

public class N07 {

	public static void main(String[] args) {
		System.out.println(new N07().reverse(Integer.MAX_VALUE));
		System.out.println(new N07().isPalindromic(121));
	}

	public int reverse(int x) {
		if(x == Integer.MIN_VALUE) return 0;
		
		int v = 0;
		boolean negative = false;
		if(x < 0) {
			x = -x;
			negative = true;
		}
		while(x > 0) {
			v = v * 10 + x%10;
			x = x/10;
		}
		if(negative) return -v;
		return v;
	}
	
	public boolean isPalindromic(int x) {
		return x == reverse(x);
	}
}
