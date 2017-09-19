package exams.n0;

/*
 Determine whether an integer is a palindrome. Do this without extra space.
 */
public class N09 {

	public static void main(String[] args) {
		System.out.println(new N09().isPalindrome(1221));
	}

	public boolean isPalindrome(int x) {
		int v = x;
		int vv = 0;
		while(v % 10 > 0) {
			vv = vv * 10 + (v%10);
			v = v/10;
		}
		
		if (vv == x) return true;
		return false;
    }
}
