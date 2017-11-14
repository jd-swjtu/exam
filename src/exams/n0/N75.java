package exams.n0;

import java.util.Arrays;

public class N75 {

	public static void main(String[] args) {
		int[] a=new int[]{2,2,0,1,1,0,1,0,2,1};
		new N75().sortColors(a);
		System.out.println(Arrays.toString(a));
	}

	void sortColors(int A[]) {
		int n = A.length;
        int second=n-1, zero=0;
        System.out.println(Arrays.toString(A));
        for (int i=0; i<=second; i++) {
            while (A[i]==2 && i<second) {
            	int t = A[i];
            	A[i] = A[second];
            	A[second] = t;
            	second--;
            	
            }
            System.out.println(Arrays.toString(A));
            while (A[i]==0 && i>zero) {
            	int t = A[i];
            	A[i] = A[zero];
            	A[zero] = t;
            	zero++;
            }
           // System.out.println(Arrays.toString(A));
        }
    }
}
