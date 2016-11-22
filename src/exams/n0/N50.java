package exams.n0;

public class N50 {

	public static void main(String[] args) {
		System.out.println(new N50().myPow(2, -20));
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
			n = -1 * n;
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
}
