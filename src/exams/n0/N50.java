package exams.n0;

public class N50 {

	public static void main(String[] args) {
		System.out.println(Integer.MIN_VALUE);
		System.out.println(new N50().myPow(-2,	-2147483647));
	}

	public double myPow(double x, int n) {
		if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return x;
        }

		boolean negative = false;
		if(n < 0) {
			n = -n;
			negative = true;
		}
		
		int t = n/2;
		int r = n%2;
		
		double result = myPow(x, t);
		result = result * result * myPow(x, r);
		
		if(negative) {
			result = 1/result;
		}
		
		return result; 
	}
	
	public double power(double x, int n) {
        if (n == 0)
            return 1;
 
        double v = power(x, n / 2);
 
        if (n % 2 == 0) {
            return v * v;
        } else {
            return v * v * x;
        }
    }
 
    public double myPowx(double x, int n) {
        if (n < 0) {
            return 1 / power(x, -1 * n);
        } else {
            return power(x, n);
        }
    }
}
