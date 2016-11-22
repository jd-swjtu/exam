package exams.n1;

public class N191 {

	public static void main(String[] args) {
		System.out.println(new N191().hammingWeight(15));
	}

	/*
	 * Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).

For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.
	 */

	public int hammingWeight(int n) {
		int c = 0;
		while(n > 0) {
			c += n & 0x1;
			n = n>>1;
		}
		return c;
	}
}
