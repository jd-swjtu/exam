package exams.n0;

public class N69 {

	public static void main(String[] args) {
		System.out.println(new N69().sqrt(15));

	}

	long sqrt(int x) {
	    long i = 0;
	    long j = x / 2 + 1;
	    while (i <= j)
	    {
	        long mid = (i + j) / 2;
	        long sq = mid * mid;
	        if (sq == x) return mid;
	        else if (sq < x) i = mid + 1;
	        else j = mid - 1;
	    }
	    return j;
	}
}
