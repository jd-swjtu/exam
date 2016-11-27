package exams.n0;

public class N07 {

	public static void main(String[] args) {
		System.out.println(new N07().reverse(1234));
		System.out.println(new N07().isPalindromic(121));
	}

	public int reverse(int x) {
		int v = 0;
		while(x > 0) {
			v = v * 10 + x%10;
			x = x/10;
		}
		return v;
	}
	
	public boolean isPalindromic(int x) {
		return x == reverse(x);
	}
}
