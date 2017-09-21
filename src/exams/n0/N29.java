package exams.n0;

/*
 Divide Two Integers

Divide two integers without using multiplication, division and mod operator.

If it is overflow, return MAX_INT.
 */
public class N29 {

	public static void main(String[] args) {
		System.out.println(new N29().divide(10, -2));
	}

	public int divide(int dividend, int divisor) {
		if(dividend == 0 || (dividend < divisor)) return 0;
		if(divisor == 0) return Integer.MAX_VALUE;
		
		int sign = 1;
		if ( (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0))
			sign = -1;
		
        int dvd = Math.abs(dividend);
        int dvs = Math.abs(divisor);
        
        int res = 0;
        while(dvd >= dvs) {
        	int t = dvs;
        	int mul = 1;
        	while(dvd >= t) {
        		t = t << 1;
        		mul = mul << 1;
        	}
        	dvd -= (t>>1);
        	res += (mul>>1);
        }
        
        if (sign == -1)
        	return -res;
        return res;
    }
}
