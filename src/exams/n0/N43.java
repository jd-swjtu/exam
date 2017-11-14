package exams.n0;

/*
 Multiply Strings
Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.

Note:

The length of both num1 and num2 is < 110.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class N43 {

	public static void main(String[] args) {
		System.out.println(new N43().multiply("12", "12"));
	}

public String multiply(String num1, String num2) {
        int l1 = num1.length();
        int l2 = num2.length();
        
        int[] d = new int[l1+l2];
        for(int i=0; i<l1; i++) {
        	int a = num1.charAt(l1-1-i) - '0';
        	for(int j=0; j<l2; j++) {
        		int b = num2.charAt(l2-1-j) - '0';
        		d[i+j] += a*b;
        	}
        }
        
        StringBuilder sb = new StringBuilder();
        int c = 0;
        for(int i=0; i<l1+l2; i++) {
        	d[i] += c;
        	
        	c = d[i] / 10;
        	d[i] = d[i] % 10;
        	sb.insert(0, d[i]);
        }
        
        while (sb.length() > 0 && sb.charAt(0) == '0') {
			sb.deleteCharAt(0);
		}
		return sb.length() == 0 ? "0" : sb.toString();
    }
}
