package exams.aa;

public class N396 {

	public static void main(String[] args) {
		System.out.println(new N396().maxRotateFunction(new int[]{4, 3, 2, 6}));
	}

	public int maxRotateFunction(int[] A) {
		int n = A.length;

		int total = 0;
		int t0 = 0;
		for(int i=0; i<n; i++) {
			total += A[i];
			t0 += A[i] * i;
		}

		int max = t0;
		for(int i=1; i<n; i++) {
			int t1 = t0 - total + n * A[i-1];

			max = Math.max(max, t1);
			t0 = t1;
		}

		return max;
	}
}
